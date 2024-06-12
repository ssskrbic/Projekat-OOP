package test;
import main.Sistem;
import main.Student;
import main.Subject;

public class StudentSistemTest {
    private Student student;
    private Subject subject;
    private System system;

    
    public void setUp() {
        student = new Student("Marko Marković", 1);
        subject = new Subject("Matematika", 1);
        system = new System();
    }

    
    public void testDodajOcenuStudentu() {
        student.dodajOcenu("Matematika", 5);
        assertEquals(1, student.getOcene().get("Matematika").size());
        assertEquals(5, student.getOcene().get("Matematika").get(0).intValue());
    }

    
    public void testProsekPoPredmetu() {
        student.dodajOcenu("Matematika", 5);
        student.dodajOcenu("Matematika", 4);
        assertEquals(4.5, student.prosekPoPredmetu("Matematika"));
    }

    
    public void testUkupniProsek() {
        student.dodajOcenu("Matematika", 5);
        student.dodajOcenu("Fizika", 4);
        assertEquals(4.5, student.ukupniProsek());
    }

    
    public void testDodajStudentaIPredmetUSistem() {
        system.dodajStudenta(student);
        system.dodajPredmet(subject);
        assertTrue(system.getStudenti().contains(student));
        assertTrue(system.getPredmeti().contains(subject));
    }

    
    public void testDodajOcenuSistemu() {
        system.dodajStudenta(student);
        system.dodajPredmet(subject);
        system.dodajOcenu(1, 1, 5);
        assertEquals(1, student.getOcene().get("Matematika").size());
        assertEquals(5, student.getOcene().get("Matematika").get(0).intValue());
    }

    
    public void testProsekStudenta() {
        system.dodajStudenta(student);
        system.dodajPredmet(subject);
        system.dodajOcenu(1, 1, 5);
        system.dodajOcenu(1, 1, 3);
        assertEquals(4.0, system.prosekStudenta(1));
    }

    
    public void testProsekPredmeta() {
        system.dodajStudenta(student);
        system.dodajPredmet(subject);
        system.dodajOcenu(1, 1, 5);
        system.dodajOcenu(1, 1, 3);
        assertEquals(4.0, system.prosekPredmeta(1));
    }
}

