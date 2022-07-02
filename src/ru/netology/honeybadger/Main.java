package ru.netology.honeybadger;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_TRANSACTIONS = 10;
        CarDealership carDealership = new CarDealership();
        String[] arrayBrand = new String[]{"BMW", "Toyota", "Honda"};
        int numberOfBuyers = 0;
        int numberOfCars = 0;

        while (numberOfBuyers != NUMBER_OF_TRANSACTIONS && numberOfCars != NUMBER_OF_TRANSACTIONS) {

            int randomAction = (int) (Math.random() * (arrayBrand.length));
            if (randomAction == 0 && numberOfBuyers != NUMBER_OF_TRANSACTIONS) {
                numberOfBuyers++;
                new Thread(null, carDealership::sellCar, "Покупатель" + numberOfBuyers).start();
            }
            if (randomAction == 1 && numberOfCars != NUMBER_OF_TRANSACTIONS) {
                numberOfCars++;
                int randomNum = (int) (Math.random() * (arrayBrand.length));
                new Thread(null, carDealership::releaseCar, arrayBrand[randomNum]).start();
            }
        }
    }
}
