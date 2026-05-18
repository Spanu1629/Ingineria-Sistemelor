package Lab10.strategy;

import Modele.Student;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private final String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Nr Matricol");
            header.createCell(1).setCellValue("Nume");
            header.createCell(2).setCellValue("Prenume");
            header.createCell(3).setCellValue("Formatie");
            header.createCell(4).setCellValue("Nota");

            int rowIndex = 1;

            for (Student student : studenti) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(student.getNrMatricol());
                row.createCell(1).setCellValue(student.getNume());
                row.createCell(2).setCellValue(student.getPrenume());
                row.createCell(3).setCellValue(student.getFormatieDeStudiu());
                row.createCell(4).setCellValue(student.getNota());
            }

            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
            }

            System.out.println("Studentii au fost exportati in fisierul Excel: " + fileName);
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisierul Excel: " + e.getMessage());
        }
    }
}
