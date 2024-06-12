package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
    private String ime;
    private int id;
    private Map<String, List<Integer>> ocene;

    public Student(String ime, int id) {
        this.ime = ime;
        this.id = id;
        this.ocene = new HashMap<>();
    }
    public String getIme() {
        return ime;
    }

    public void dodajOcenu(String predmet, int ocena) {
        ocene.putIfAbsent(predmet, new ArrayList<>());
        ocene.get(predmet).add(ocena);
    }

    public double prosekPoPredmetu(String predmet) {
        if (ocene.containsKey(predmet)) {
            List<Integer> listaOcena = ocene.get(predmet);
            return listaOcena.stream().mapToInt(Integer::intValue).average().orElse(0);
        }
        return 0;
    }

    public double ukupniProsek() {
        List<Integer> sveOcene = ocene.values().stream().flatMap(List::stream).collect(Collectors.toList());
        return sveOcene.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    @Override
    public String toString() {
        return "Student: " + ime + ", ID: " + id + ", Ocene: " + ocene;
    }

    public int getId() {
        return id;
    }
}
