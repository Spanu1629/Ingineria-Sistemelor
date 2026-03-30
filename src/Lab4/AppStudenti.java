package Lab4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import Modele.Student;

public class AppStudenti {
    public static void main(String[] args) {
        try {
            List<String> linii = Files.readAllLines(Paths.get("src/Lab3/studenti_in.txt"));

            List<Student> studenti = new ArrayList<>();

            // citim studentii din fisier
            for (String linie : linii) {
                String[] campuri = linie.split(",");

                int id = Integer.parseInt(campuri[0]);
                String prenume = campuri[1];
                String nume = campuri[2];
                String grupa = campuri[3];

                Student s = new Student(id, nume, prenume, grupa);
                studenti.add(s);
            }

            // facem HashMap<Integer, Student>
            HashMap<Integer, Student> mapStudenti = new HashMap<>();
            for (Student s : studenti) {
                mapStudenti.put(s.getNrMatricol(), s);
            }

            // citim notele
            List<String> liniiNote = Files.readAllLines(Paths.get("src/Lab4/note_anon.txt"));

            for (String linie : liniiNote) {
                String[] campuri = linie.split(",");

                int id = Integer.parseInt(campuri[0]);
                float nota = Float.parseFloat(campuri[1]);

                Student s = mapStudenti.get(id);
                if (s != null) {
                    s.setNota(nota);
                }
            }

            // afisam studentii cu notele
            System.out.println("Studentii cu note:");
            for (Student s : mapStudenti.values()) {
                System.out.println(s);
            }

            // tema
            System.out.println();
            System.out.println("Nota studentului Bianca Popescu este: " +
                    gasesteNota("Bianca", "Popescu", mapStudenti));
            System.out.println("Nota studentului Ioan Popa este: " +
                    gasesteNota("Ioan", "Popa", mapStudenti));

        } catch (IOException e) {
            System.out.println("Greseala la citire/scriere");
        }
    }

    public static float gasesteNota(String prenume, String nume, HashMap<Integer, Student> studenti) {
        HashMap<String, Student> mapNume = new HashMap<>();

        for (Student s : studenti.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            mapNume.put(cheie, s);
        }

        String cheieCautata = prenume + "-" + nume;

        if (mapNume.containsKey(cheieCautata)) {
            return mapNume.get(cheieCautata).getNota();
        }

        return 0.0f;
    }
}