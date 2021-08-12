package ru.job4j.ood.srp.design;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            for (Employee employee : store.findBy(filter)) {
                marshaller.marshal(employee, writer);
                xml = writer.getBuffer().toString();
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(xml);
        return xml;
    }

    public static void main(String[] args) throws JAXBException {
        Calendar now = Calendar.getInstance();
        MemStore stores = new MemStore();
        Employee emp = new Employee("Ivan", now, now, 3569);
        Employee emp1 = new Employee("Ilya", now, now, 4000);
        stores.add(emp);
        stores.add(emp1);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp);
        employeeList.add(emp1);
        ReportXML rp = new ReportXML(stores);
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            for (Employee employee : employeeList) {
                marshaller.marshal(employee, writer);
                xml = writer.getBuffer().toString();
                System.out.println(xml);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
