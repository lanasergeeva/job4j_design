package ru.job4j.ood.lsp;

public class ExampleLSPExchangeRateSecond {
    static class Bank {
        public double exchange(double money, double rate) {
            if (money < 1 || money > 100000) {
                throw new IllegalArgumentException("Недостаточно денег для обмена, либо превышен лимит");
            }
            return money * rate;
        }
    }

    static class Terminal extends Bank {
        @Override
        public double exchange(double money, double rate) {
            return money * rate;
        }
    }

    static class SecondRule {
        public static void main(String[] args) {
            Bank bank = new Terminal();
            bank.exchange(145000, 86);

        }
    }

}
