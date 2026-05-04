package Lab8;

import Modele.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentExcel {

    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student(1, "Popa", "Andrei", "231", 9.5f));
        studenti.add(new Student(2, "Ionescu", "Maria", "231", 8.75f));
        studenti.add(new Student(3, "Dumitrescu", "Paul", "232", 7.8f));

        String xlsxFileName = "laborator8_students.xlsx";

        // 8.5.4 a
        writeToXls(studenti, xlsxFileName);

        // 8.5.4 b
        List<Student> studentsFromXls = readFromXls(xlsxFileName);

        System.out.println("\nStudenti cititi din xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }

    // 8.5.4 a
    // Exporta lista de studenti in fisier Excel
    public static void writeToXls(List<Student> studenti, String fileName) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);

            header.createCell(0).setCellValue("Nr Matricol");
            header.createCell(1).setCellValue("Nume");
            header.createCell(2).setCellValue("Prenume");
            header.createCell(3).setCellValue("Formatie");
            header.createCell(4).setCellValue("Nota");

            int rowNum = 1;

            for (Student student : studenti) {
                Row row = sheet.createRow(rowNum);

                row.createCell(0).setCellValue(student.getNrMatricol());
                row.createCell(1).setCellValue(student.getNume());
                row.createCell(2).setCellValue(student.getPrenume());
                row.createCell(3).setCellValue(student.getFormatieDeStudiu());
                row.createCell(4).setCellValue(student.getNota());

                rowNum++;
            }

            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
            }

            System.out.println("Fisier creat: " + fileName);

        } catch (IOException e) {
            System.out.println("Eroare la scrierea fisierului Excel: " + e.getMessage());
        }
    }

    // 8.5.4 b
    // Citeste studentii din fisier Excel si returneaza List<Student>
    public static List<Student> readFromXls(String fileName) {
        List<Student> studenti = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(fileName);
                Workbook workbook = new XSSFWorkbook(fis)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                String nume = row.getCell(1).getStringCellValue();
                String prenume = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();

                Student student = new Student(nrMatricol, nume, prenume, formatie, nota);

                studenti.add(student);
            }

        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului Excel: " + e.getMessage());
        }

        return studenti;
    }
}