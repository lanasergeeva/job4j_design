package ru.job4j.ood.dip;

public class ExampleDIP3 {

    class EventLogWriter {

        public EventLogWriter() {
            // Конструктор
        }

        public void write(String message) {
            // Конструктор
        }
    }

    class AppManager {

        EventLogWriter writer = null;

        public AppManager() {
            // Конструктор
        }

        void notify(String message) {

            if (writer == null) {

                writer = new EventLogWriter();
            }

            writer.write(message);
        }
    }
}
