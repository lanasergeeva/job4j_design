package ru.job4j.ood.dip;

public class ExampleDIP3 {

    class EventLogWriter {

        public EventLogWriter() {
        }

        public void write(String message) {
        }
    }

    class AppManager {

        EventLogWriter writer = null;

        public AppManager() {

        }

        void notify(String message) {

            if (writer == null) {

                writer = new EventLogWriter();
            }

            writer.write(message);
        }
    }
}
