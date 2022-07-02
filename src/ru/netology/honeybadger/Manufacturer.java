package ru.netology.honeybadger;

public class Manufacturer {
    private CarDealership carDealership;

    public Manufacturer(CarDealership carDealership) {
        this.carDealership = carDealership;
    }

    public synchronized void releaseCar() {
        try {
            System.out.printf("Производитель  %s собирает авто!\n", Thread.currentThread().getName());
            Thread.sleep(3000);
            carDealership.getCars().add(new Car());
            System.out.printf("Производитель  %s выпустил 1 авто!\n", Thread.currentThread().getName());
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellCar() {
        try {
            System.out.printf("%s: зашел в автосалон!\n", Thread.currentThread().getName());
            while (carDealership.getCars().size() == 0) {
                System.out.printf("%s: Машин нет\n", Thread.currentThread().getName());
                wait();
            }
            Thread.sleep(3000);
            System.out.printf("%s: уехал на новеньком авто!\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
