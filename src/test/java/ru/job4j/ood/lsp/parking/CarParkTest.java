package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class CarParkTest {

    @Test
    public void whenJustPark() {
        CarPark cars = new CarPark(3, 1);
        Car car1 = new Car();
        cars.parking(car1);
        assertThat(cars.parking(car1), is(true));
    }

    @Test
    public void whenSize3Cars1TruckAnd4Cars() {
        CarPark cars = new CarPark(3, 1);
        Car car1 = new Car();
        Truck car2 = new Truck(2);
        cars.parking(car1);
        cars.parking(car1);
        cars.parking(car1);
        cars.parking(car1);
        assertThat(cars.getCar(), is(3));
    }

    @Test
    public void whenSize4Cars3Trucks1() {
        CarPark cars = new CarPark(2, 1);
        Car car1 = new Car();
        Truck car2 = new Truck(2);
        cars.parking(car1);
        cars.parking(car1);
        cars.parking(car2);
        assertThat(cars.getTruck(), is(1));
        assertThat(cars.getCar(), is(2));
    }

    @Test
    public void whenSizeFor3Cars1TrucksAnd3Trucks() {
        CarPark cars = new CarPark(2, 1);
        Truck car2 = new Truck(2);
        cars.parking(car2);
        cars.parking(car2);
        cars.parking(car2);
        assertThat(cars.getTruck(), is(2));
    }

    @Test
    public void whenSize3ForCars2Truck1andRsl2Truck() {
        CarPark cars = new CarPark(2, 1);
        Car car1 = new Car();
        Truck car2 = new Truck(2);
        cars.parking(car2);
        cars.parking(car2);
        cars.parking(car1);
        cars.parking(car1);
        assertThat(cars.getTruck(), is(2));
        assertThat(cars.getCar(), is(0));
    }
}