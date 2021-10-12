package ru.job4j.ood.lsp;

public class ExampleLSPExchangeRate3 {

    static class Client {
        private String name;
        private String passport;
        private boolean encumbrance;

        public Client(String name, String passport, boolean encumbrance) {
            this.name = name;
            this.passport = passport;
            this.encumbrance = encumbrance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassport() {
            return passport;
        }

        public void setPassport(String passport) {
            this.passport = passport;
        }

        public boolean isEncumbrance() {
            return encumbrance;
        }

        public void setEncumbrance(boolean encumbrance) {
            this.encumbrance = encumbrance;
        }
    }

    static class Bank {
        public static void checkEncumbrance(Client client) {
            if (client.encumbrance) {
                throw new IllegalArgumentException("Наложено обременение на ваш счет.");
            }
        }

        public double getMoney(double money, Client client) {
            checkEncumbrance(client);
            if (money < 1) {
                throw new IllegalArgumentException("Укажите верную сумму");
            }
            return money;
        }
    }

    static class Terminal extends Bank {
        @Override
        public double getMoney(double money, Client client) {
            if (money < 1) {
                throw new IllegalArgumentException("Укажите верную сумму");
            }
            return money;
        }
    }

    static class ThirdRule {
        public static void main(String[] args) {
            Client client = new Client("Ivan", "569897", true);
            Bank bank = new Bank();
            bank.getMoney(56847, client);
        }
    }
}
