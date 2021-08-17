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
        String rsl;
        Gson gson = new GsonBuilder().create();
        rsl = gson.toJson(store.findBy(filter));
        System.out.println(rsl);
        return rsl;
    }
}
