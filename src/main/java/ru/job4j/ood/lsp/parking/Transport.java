package ru.job4j.ood.lsp.parking;

/*
Общий интерфейс для классов Car и Truck. Нужен для того, что в общем методе
будем через него узнавать размер машины. И он также будет использоваться в парметрах.
 */
public interface Transport {
    int getSize();
}
