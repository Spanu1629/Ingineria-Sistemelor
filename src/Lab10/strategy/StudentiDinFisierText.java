package Lab10.strategy;

import Modele.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private final String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linie;

            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(";");

                if (valori.length == 5) {
                    int nrMatricol = Integer.parseInt(valori[0]);
                    String nume = valori[1];
                    String prenume = valori[2];
                    String formatie = valori[3];
                    float nota = Float.parseFloat(valori[4]);

                    studenti.add(new Student(nrMatricol, nume, prenume, formatie, nota));
                }
            }

            System.out.println("Studentii au fost cititi din fisierul text: " + fileName);
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisierul text: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Eroare la conversia datelor: " + e.getMessage());
        }

        return studenti;
    }
}
