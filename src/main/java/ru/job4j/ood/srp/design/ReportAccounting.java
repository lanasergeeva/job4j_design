package ru.job4j.ood.srp.design;

import java.util.function.Predicate;

public class ReportAccounting implements Report {


    private Store store;

    public ReportAccounting(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        double euro = 86.4;
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName())
                    .append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * euro).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
