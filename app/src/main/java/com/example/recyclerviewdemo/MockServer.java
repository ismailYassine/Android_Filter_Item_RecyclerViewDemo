package com.example.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

public class MockServer {

    public List<Contries> getCountries() {

        List <Contries> contriesList = new ArrayList<>();
        contriesList.add(new Contries("Canada"));
        contriesList.add(new Contries("Cuba"));
        contriesList.add(new Contries("Senegal"));
        contriesList.add(new Contries("Japan"));
        contriesList.add(new Contries("Chine"));
        contriesList.add(new Contries("Mail"));
        contriesList.add(new Contries("Mexique"));
        contriesList.add(new Contries("Suede"));
        contriesList.add(new Contries("South Korea"));
        contriesList.add(new Contries("Spain"));

    return contriesList;
    }
}
