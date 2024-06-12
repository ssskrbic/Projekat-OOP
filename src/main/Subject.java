package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Subject {
    private String naziv;
    private int id;
    private Map<String, List<Integer>> ocene;

    public Subject(String naziv, int id) {
        this.naziv = naziv;
        this.id = id;
        this.ocene = new HashMap<>();
    }
    public String getNaziv() {
        return naziv;
    }

    public void dodajOcenu(String student, int ocena) {
        ocene.putIfAbsent(student, new ArrayList<>());
        ocene.get(student).add(ocena);
    }

    public double prosekPoStudentu(String student) {
        if (ocene.containsKey(student)) {
            List<Integer> listaOcena = ocene.get(student);
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
        return "Predmet: " + naziv + ", ID: " + id + ", Ocene: " + ocene;
    }

    public int getId() {
        return id;
    }
}
