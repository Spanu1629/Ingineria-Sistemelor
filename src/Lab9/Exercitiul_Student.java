package Lab9;

import Modele.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Exercitiul_Student {
    public static void main(String[] args) {

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10f),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10f),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33f),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20f),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22f)
        );

        // a) Afisati studentii cu nota 10.
        List<Student> studentiNota10 = studentiCuNote.stream()
                .filter(e -> e.getNota() == 10f)
                .collect(Collectors.toList());

        System.out.println("Studenti cu nota 10:");
        studentiNota10.forEach(e -> System.out.println(e));

        // b) Afisati studentii cu nota sub 5.
        List<Student> studentiSub5 = studentiCuNote.stream()
                .filter(e -> e.getNota() < 5f)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Studenti cu nota sub 5:");
        studentiSub5.forEach(e -> System.out.println(e));

        // c) Transformati lista de studenti intr-o lista in care studentii cu nota < 4 devin studenti cu nota 4.
        List<Student> studentiModificati = studentiCuNote.stream()
                .map(e -> {
                    if (e.getNota() < 4f) {
                        return new Student(
                                e.getNrMatricol(),
                                e.getNume(),
                                e.getPrenume(),
                                e.getFormatieDeStudiu(),
                                4f
                        );
                    } else {
                        return e;
                    }
                })
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Lista modificata:");
        studentiModificati.forEach(e -> System.out.println(e));

        // d) Calculati suma notelor tuturor studentilor folosind reduce.
        float sumaNote = studentiCuNote.stream()
                .map(e -> e.getNota())
                .reduce(0f, (a, b) -> a + b);

        System.out.println();
        System.out.println("Suma notelor: " + sumaNote);

        // e) Calculati media.
        float media = sumaNote / studentiCuNote.size();

        System.out.println("Media notelor: " + media);
    }
}
