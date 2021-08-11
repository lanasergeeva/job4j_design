package ru.job4j.ood.srp.design;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportIT implements Report {
    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ls = System.lineSeparator();
        text.append("<html>" + ls + "<head>" + ls + "<title>Отчёт</title>" + ls + "</head>" + ls)
                .append("<H1>Сотрудники</H1>" + ls + "<p> ")
                .append("Name; Hired; Fired; Salary </p>" + ls + "<p> ");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(" </p>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) {
        String ls = System.lineSeparator();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        StringBuilder st = new StringBuilder();
        st.append("<html>" + ls + "<head>" + ls + "<title>Отчёт</title>" + ls + "</head>" + ls)
                .append("<H1>Сотрудники</H1>" + ls + "<p> ")
                .append("Name; Hired; Fired; Salary </p>" + ls + "<p> ")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(" </p>");
        System.out.println(st);
    }
}
