package Lab10.strategy;

import Modele.Student;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {
    private final String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

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

                studenti.add(new Student(nrMatricol, nume, prenume, formatie, nota));
            }

            System.out.println("Studentii au fost cititi din fisierul Excel: " + fileName);
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisierul Excel: " + e.getMessage());
        }

        return studenti;
    }
}
