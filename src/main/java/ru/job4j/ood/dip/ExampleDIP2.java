package ru.job4j.ood.dip;

public class ExampleDIP2 {

    class Bank {
        private Cashier cashier;
        private Terminal terminal;

        public void getMoney(Client client) {
            cashier.getMoneyFromBankAccount(client);
        }

        public void payOnlyByTerminal(Client client) {
            terminal.payUtilities(client);
        }


    }

    class Cashier {
        public void getMoneyFromBankAccount(Client client) {

        }
    }

    class Terminal {
        public void payUtilities(Client client) {

        }
    }

    class Client {

    }

}
