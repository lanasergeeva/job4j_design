package ru.job4j.ood.lsp.parking;

public class CarPark implements Parking {

    private int spacesForCar;
    private int spacesForTruck;
    private int car = 0;
    private int truck = 0;
    private int index = 0;
    private final Transport[] allCars;


    public CarPark(int parkingSpaceForCar, int parkingSpaceForTruck) {
        this.spacesForCar = parkingSpaceForCar;
        this.spacesForTruck = parkingSpaceForTruck;
        this.allCars = new Transport[parkingSpaceForCar + parkingSpaceForTruck];
    }

    @Override
    public boolean parking(Transport transport) {
        boolean rsl = false;
        if (transport.getSize() == 1 && car < spacesForCar) {
            allCars[index++] = transport;
            car++;
            rsl = true;
        } else if (transport.getSize() > 1 && truck < spacesForTruck) {
            truck++;
            allCars[index++] = transport;
            rsl = true;
        } else if (allCars.length - index >= transport.getSize()) {
            truck++;
            for (int i = 0; i < transport.getSize(); i++) {
                allCars[index++] = transport;
                spacesForCar--;
            }
            rsl = true;
        }
        return rsl;
    }

    public void getAllCarsAndTrucks() {
        System.out.println("There are " + getCar() + " car(s) and "
                + getTruck() + " truck(s) in the parking lot");
    }


    public int getCar() {
        return car;
    }

    public int getTruck() {
        return truck;
    }

    public Transport[] getAllCars() {
        return allCars;
    }
}
