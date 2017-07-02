package homework.lection04.task01;

public class GameRunner {

    public static void main(String[] args) {
        Train train = new GameTrain();
        Train train2 = new GameTrain2();
        System.out.println("Real train's length: " + train);
        System.out.println("Train's length calculated by algorithm: " + findLength(train));
        System.out.println("Real train2's length: " + train2);
        System.out.println("Train's length calculated by algorithm: " + findLength(train2));
    }

    /**
     Идея алгоритма:
     1. Выключить в начальном вагоне свет
     2. Идти вперед, пока не попадешь в вагон с выключенным светом, считая количество пройденных вагонов (инкрементируя счетчик)
     3. Включить свет в текущем вагоне, запомнив колчество пройденных вагонов (сохранить значение, чтобы его потом ввести)
     4. Вернуться на стартовую позицию, зная количество пройденных вагонов (декрементируя счетчик)
     5. Если в стартовом вагоне свет есть, выйти из вагона, введя значене, которое запомнили, иначе goto 2

     Вообще, т.к. в условиях не сказано, что если ввести количество вагонов неправильно, то прозойдет что-то ужасное (например,
     дверь заблокируется навсегда), можно вообще никуда не ходить и использовать последовательный перебор.

     int expectedLength = 1;
     while(!train.isLength(expectedLength)) expectedLength++;
     return expectedLength;
     */
    public static int findLength(Train train) {

        int position = 0; //счетчик шагов от стартового вагона
        int estimatedSize; //позиция вагона с выключенным светом, полученная на крайней итерации

        train.lightOff();

        while(true) {
            do {
                train.turnRight();
                position++;
            } while (train.isLightOn());

            train.lightOn();
            estimatedSize = position;

            do {
                train.turnLeft();
                position--;
            } while (position > 0);

            if (train.isLightOn()) {
                return estimatedSize;
            }
        }
    }
}
