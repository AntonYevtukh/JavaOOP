package homework.lection03.task03;

import java.util.Random;
import java.util.StringJoiner;

public class Computer {

    private Cpu cpu;
    private Ram ram;
    private Hdd hdd;
    private Odd odd;
    private boolean isOn;

    public Computer(Cpu cpu, Ram ram, Hdd hdd, Odd odd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.odd = odd;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Hdd getHdd() {
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        this.hdd = hdd;
    }

    public Odd getOdd() {
        return odd;
    }

    public void setOdd(Odd odd) {
        this.odd = odd;
    }

    public void start() {
        isOn = true;
        System.out.println("Windows is starting...");
    }

    public void shutDown() {
        isOn = false;
        System.out.println("Working on updates 0 of 100500... Shutting down... ");
    }

    public void checkDisk() {
        if (isOn) {
            boolean temp = false;
            if (hdd.isInfected() || new Random().nextBoolean()) {
                hdd.setInfected(true);
                System.out.println("Checking disk... Viruses detected.");
            }
            else
                System.out.println("Checking disk... No viruses found.");
        } else
            System.out.println("It's not possible to check disk for viruses. Computer is not running.");
    }

    public void printHdd() {
        System.out.println("HDD size is " + hdd.getSize() + " " + hdd.getUnits() + "B.");
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("\n","Computer contains:\n","\n");
        joiner.add(cpu.toString()).add(ram.toString()).add(hdd.toString()).add(odd.toString());
        return joiner.toString();
    }
}
