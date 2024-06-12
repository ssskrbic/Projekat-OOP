package main;

import java.util.ArrayList;
import java.util.List;

public class Sistem {
    private List<Student> studenti;
    private List<Subject> predmeti;

    public void System() {
        studenti = new ArrayList<>();
        predmeti = new ArrayList<>();
    }

    public void dodajStudenta(Student student) {
        studenti.add(student);
    }

    public void dodajPredmet(Subject predmet) {
        predmeti.add(predmet);
    }

    public void dodajOcenu(int studentId, int predmetId, int ocena) {
        Student student = studenti.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
        Subject predmet = predmeti.stream().filter(p -> p.getId() == predmetId).findFirst().orElse(null);
        if (student != null && predmet != null) {
            student.dodajOcenu(predmet.getNaziv(), ocena);
            predmet.dodajOcenu(student.getIme(), ocena);
        }
    }

    public double prosekStudenta(int studentId) {
        Student student = studenti.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
        if (student != null) {
            return student.ukupniProsek();
        }
        return 0;
    }

    public double prosekPredmeta(int predmetId) {
        Subject predmet = predmeti.stream().filter(p -> p.getId() == predmetId).findFirst().orElse(null);
        if (predmet != null) {
            return predmet.ukupniProsek();
        }
        return 0;
    }

    public void prikaziStanje() {
        studenti.forEach(System.out::println);
        predmeti.forEach(System.out::println);
    }
}
