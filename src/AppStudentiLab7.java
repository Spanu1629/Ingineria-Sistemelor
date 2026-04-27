import Modele.Student;

import java.util.LinkedHashSet;
import java.util.Set;

public class AppStudentiLab7 {

    public static void main(String[] args) {

        Set<Student> studenti = new LinkedHashSet<>();

        studenti.add(new Student(1, "Popescu", "Andrei", "TI 211", 9.5f));
        studenti.add(new Student(2, "Ionescu", "Maria", "TI 211",6.8f));
        studenti.add(new Student(3, "Georgescu", "Alex", "TI 211",7.2f));
        studenti.add(new Student(4, "Dumitrescu", "Ioana", "TI 211",3.9f));
        studenti.add(new Student(5, "Stan", "Mihai", "TI 211",5.0f));

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        System.out.println("\nLista studenti impartita in doua formatii:");
        for (Student st : studenti) {
            System.out.println(st);
        }
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> rezultat = new LinkedHashSet<>();

        int jumatate = studenti.size() / 2;
        if (studenti.size() % 2 != 0) {
            jumatate++;
        }

        int contor = 0;

        for (Student st : studenti) {
            if (contor < jumatate) {
                rezultat.add(schimbaFormatia(st, formatia1));
            } else {
                rezultat.add(schimbaFormatia(st, formatia2));
            }
            contor++;
        }

        return rezultat;
    }

    static Student schimbaFormatia(Student st, String nouaFormatie) {
        return new Student(
                st.getNrMatricol(),
                st.getNume(),
                st.getPrenume(),
                nouaFormatie,
                st.getNota()
        );
    }
}