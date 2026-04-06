package Lab5;

import Modele.Student;
import Modele.StudentBursier;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AppBursieri {
    public static void main(String[] args) {
        Set<StudentBursier> bursieri = new HashSet<>();

        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        writeToFile("src/lab5/bursieri_out.txt", bursieri);

        System.out.println("Fisierul bursieri_out.txt a fost creat.");
    }

    public static void writeToFile(String filename, Collection<? extends Student> studenti) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            for (Student s : studenti) {
                out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Eroare la scriere in fisier: " + e.getMessage());
        }
    }
}
