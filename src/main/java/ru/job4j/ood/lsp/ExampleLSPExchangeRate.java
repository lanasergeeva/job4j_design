package ru.job4j.ood.lsp;

public class ExampleLSPExchangeRate {

    class Bank {
        public double exchange(double money, double rate) {
            double rsl = 0;
            if (money < 1) {
                throw new IllegalArgumentException("Недостаточно денег для обмена");
            }
            return rsl;
        }
    }

    class Terminal extends Bank {
        @Override
        public double exchange(double money, double rate) {
            double rsl = 0;
            if (money < 1) {
                throw new IllegalArgumentException("Недостаточно денег для обмена");
            }
            if (money > 50000) {
                throw new IllegalArgumentException("Лимит для снятия валюты в терминале превышен.");
            }
            return rsl;
        }
    }
}
