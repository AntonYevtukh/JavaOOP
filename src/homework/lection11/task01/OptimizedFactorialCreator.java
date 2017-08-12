package homework.lection11.task01;

import java.math.BigInteger;

/**
 * Created by Anton on 10.08.2017.
 */
public class OptimizedFactorialCreator implements Runnable {

    private volatile int counter = 0; //счетчик потоков, использовавших этот Runnable объект
    private int multiplier; //К
    private FactorialSaver factorialSaver; //Для сохранения в файл
    private volatile ResultContainer lastResultContainer; //Контейнер результата, полученного предыдущим последним потоком
    private volatile Thread lastThread; //Последний из потоков, испоьзовавших этот объект
    private boolean waitForFileSave; //Ждать ли записи в файл или только передачи результата

    public OptimizedFactorialCreator(int multiplier, String savePath, boolean waitForFileSave) {
        this.multiplier = multiplier;
        this.factorialSaver = new FactorialSaver(savePath);
        this.waitForFileSave = waitForFileSave;
    }

    private BigInteger multiplyLastK(int index) {
        BigInteger result = BigInteger.ONE;
        int upperBound = multiplier * (index) + 1;
        for (int i = upperBound - multiplier; i < upperBound; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public void run() {

        BigInteger result;
        ResultContainer resultContainer = new ResultContainer(); //контейнер результата текущего потока, изначально хранит null
        ResultContainer previousResultContainer; //контейнер результата предыдущего потока
        Thread currentThread = Thread.currentThread(); //текущий поток
        Thread previousThread; //предыдащй поток
        int i;
        synchronized (this) {
            i = ++counter; //увелчиваем счетчик
            previousResultContainer = lastResultContainer; //получаем ссылку на контейнер результата последнего потока
            lastResultContainer = resultContainer; //устанавливаем контейнер результата последнего потока на контейнер текущего потока
            previousThread = lastThread; //считаем, что предыдущий поток - это последний, использовавший этот Runnable
            lastThread = currentThread; //последний поток - это текущий
        }

        result = multiplyLastK(i); //Перемножить К чисел

        if (!waitForFileSave) { //версия с ожиданием непосредственно результата
            if (i > 1) {
                synchronized (previousResultContainer) { //синхронизированно по контейнеру результата предыдущего потока - см. строку 66
                    if (previousResultContainer.getResult() == null) { //если результата от него еще нет - ждем его
                        try {
                            previousResultContainer.wait();
                        } catch (InterruptedException exc) {
                            exc.printStackTrace();
                        }
                    }
                }
                result = result.multiply(previousResultContainer.getResult()); //умножаем текущее произведение К чисел на факториал
                //полученный предыдущим потоком
            }

            synchronized (resultContainer) { //синхронизированно по контейнеру результата текущего потока - см. строку 53
                resultContainer.setResult(result); //записываем результат в контейнер
                resultContainer.notify(); //уведомляем об этом следующий поток, который ждет результата
            }

        } else {
            if (i > 1) {
                try {
                    previousThread.join(); //тут та версия через join
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
                result = result.multiply(previousResultContainer.getResult());
            }
            resultContainer.setResult(result);
        }

        factorialSaver.saveFactorial(result, (i * multiplier));
    }

    private static class ResultContainer {
        private BigInteger result;

        public BigInteger getResult() {
            return result;
        }

        public void setResult(BigInteger result) {
            this.result = result;
        }
    }
}
