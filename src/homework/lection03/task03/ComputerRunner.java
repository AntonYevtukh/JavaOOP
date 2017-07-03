package homework.lection03.task03;

public class ComputerRunner {

    public static void main(String[] args) {
        Cpu cpu = new Cpu(4,3,Prefix.G);
        Ram ram = new Ram(8, Prefix.G,"DDR3");
        Hdd hdd = new Hdd(2,Prefix.T,7200);
        Odd odd = new Odd("CD/DVD-RW",10400);

        Computer computer = new Computer(cpu, ram, hdd, odd);
        System.out.println(computer);

        computer.checkDisk();
        computer.start();
        computer.checkDisk();
        computer.shutDown();
        computer.printHdd();
    }
}
