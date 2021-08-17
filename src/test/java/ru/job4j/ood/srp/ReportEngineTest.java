package ru.job4j.ood.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.ood.srp.design.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportAc() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportAccounting reportAccounting = new ReportAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 86.4).append(";")
                .append(System.lineSeparator());
        assertThat(reportAccounting.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ilya", now, now, 380);
        store.add(worker);
        store.add(worker2);
        ReportHR reportHR = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";");
        assertThat(reportHR.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportIT() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        String ls = System.lineSeparator();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportIT reportIT = new ReportIT(store);
        StringBuilder expect = new StringBuilder().append("<html>").append(ls).append("<head>").append(ls)
                .append("<title>Отчёт</title>").append(ls).append("</head>").append(ls)
                .append("<H1>Сотрудники</H1>").append(ls).append("<p> ")
                .append("Name; Hired; Fired; Salary </p>")
                .append(ls).append("<p> ")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(" </p>")
                .append(System.lineSeparator());
        assertThat(reportIT.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 3569);
        Employee worker2 = new Employee("Ilya", now, now, 4569);
        store.add(worker);
        store.add(worker2);
        ReportXML reportXML = new ReportXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n")
                .append("<employees>")
                .append("\n")
                .append("    <employees name=\"Ivan\" salary=\"3569.0\"/>")
                .append("\n")
                .append("    <employees name=\"Ilya\" salary=\"4569.0\"/>")
                .append("\n")
                .append("</employees>")
                .append("\n");
        assertThat(reportXML.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportJSON() {
        String st;
        MemStore store = new MemStore();
        Calendar date = new GregorianCalendar(2015, 5, 8);
        Employee worker = new Employee("Ivan", date, date, 100);
        store.add(worker);
        ReportJSON json = new ReportJSON(store);
        st = "[{"
                + "\"name\":\"Ivan\","
                + "\"hired\":"
                + "{"
                + "\"year\":2015,"
                + "\"month\":5,"
                + "\"dayOfMonth\":8,"
                + "\"hourOfDay\":0,"
                + "\"minute\":0,"
                + "\"second\":0"
                + "},"
                + "\"fired\":"
                + "{"
                + "\"year\":2015,"
                + "\"month\":5,"
                + "\"dayOfMonth\":8,"
                + "\"hourOfDay\":0,"
                + "\"minute\":0,"
                + "\"second\":0"
                + "},"
                + "\"salary\":100.0"
                + "}]";
        assertThat(json.generate(em -> true), is(st));
    }
}