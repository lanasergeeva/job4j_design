package ru.job4j.ood.srp.design;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String st;
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            final Gson gson = new GsonBuilder().create();
            st = gson.toJson(employee);
            text.append(st);
        }
        System.out.println(text);
        return text.toString();
    }
}
