package Lab10.strategy;

import Modele.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private final String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : studenti) {
                writer.println(student.getNrMatricol() + ";" +
                        student.getNume() + ";" +
                        student.getPrenume() + ";" +
                        student.getFormatieDeStudiu() + ";" +
                        student.getNota());
            }

            System.out.println("Studentii au fost exportati in fisierul text: " + fileName);
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisierul text: " + e.getMessage());
        }
    }
}
