package ru.job4j.ood.lsp.parking;
/*
С помощью него в классе CarPark будет распределять машины по парковке.
 */
public interface Parking {
    boolean parking(Transport transport);
}
