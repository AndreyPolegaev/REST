package ru.job4j.job4j_auth.repository;

public class Test {
    public static void main(String[] args) {
        Transport boat = new Boat(false);
        System.out.println("Является ли транспорт наземным: " + boat.isGround() + System.lineSeparator());

        GroundTransport motorcycle = new Motorcycle(true, 2);
        System.out.println("Является ли транспорт наземным: " + motorcycle.isGround());
        System.out.println("Количество колёс: " + motorcycle.wheelsCount  + System.lineSeparator());

        GroundTransport car = new Car(true, 4);
        System.out.println("Является ли транспорт наземным: " + car.isGround());
        System.out.println("Количество колёс: " + car.wheelsCount + System.lineSeparator());

        GroundTransport sportcar = new Sportcar(true, 4);
        System.out.println("Является ли транспорт наземным: " + sportcar.isGround());
        System.out.println("Количество колёс: " + sportcar.wheelsCount());
    }

}

interface Transport {
    boolean isGround();
}

abstract class GroundTransport implements Transport {
    boolean ground;
    int wheelsCount;

    public GroundTransport(boolean ground, int wheelsCount) {
        this.ground = ground;
        this.wheelsCount = wheelsCount;
    }

    @Override
    public boolean isGround() {
        return ground;
    }

    int wheelsCount(){
        return wheelsCount;
    }
}

class Boat implements Transport {

    private final boolean ground;

    public Boat(boolean ground) {
        this.ground = ground;
    }

    @Override
    public boolean isGround() {
        return ground;
    }
}

class Motorcycle extends GroundTransport {

    public Motorcycle(boolean ground, int wheelsCount) {
        super(ground, wheelsCount);
    }
}

class Car extends GroundTransport {

    public Car(boolean ground, int wheelsCount) {
        super(ground, wheelsCount);
    }

}

class Sportcar extends Car {

    public Sportcar(boolean ground, int wheelsCount) {
        super(ground, wheelsCount);
    }
}
