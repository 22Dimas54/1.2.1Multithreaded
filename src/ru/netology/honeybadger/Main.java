package ru.netology.honeybadger;

public class Main {

    public static void main(String[] args) {
        CarDealership carDealership = new CarDealership();

        new Thread(null, carDealership::sellCar, "Покупатель1").start();
        new Thread(null, carDealership::sellCar, "Покупатель2").start();
        new Thread(null, carDealership::sellCar, "Покупатель3").start();

        new Thread(null, carDealership::releaseCar, "BMW").start();
        new Thread(null, carDealership::releaseCar, "Toyota").start();
        new Thread(null, carDealership::releaseCar, "Honda").start();
    }
}
