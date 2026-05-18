package Lab10;

import Lab10.strategy.Exporter;
import Lab10.strategy.Importer;
import Lab10.strategy.IStudentiExport;
import Lab10.strategy.IStudentiImport;
import Lab10.strategy.StudentiDinFisierText;
import Lab10.strategy.StudentiDinFisierXlsx;
import Lab10.strategy.StudentiInConsola;
import Lab10.strategy.StudentiInFisierText;
import Lab10.strategy.StudentiInFisierXlsx;
import Modele.Student;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10f),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10f),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33f),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20f),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22f)
        );

        Exporter exporter = new Exporter();

        System.out.println("=== EXPORT IN CONSOLA ===");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        System.out.println("\n=== EXPORT IN FISIER TEXT ===");
        String textFileName = "studentiStrategyText.txt";
        IStudentiExport strategyFisierText = new StudentiInFisierText(textFileName);
        exporter.startExport(strategyFisierText, studenti);

        System.out.println("\n=== EXPORT IN FISIER EXCEL ===");
        String excelFileName = "studentiStrategyExcel.xlsx";
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx(excelFileName);
        exporter.startExport(strategyFisierExcel, studenti);

        Importer importer = new Importer();

        System.out.println("\n=== CITIRE DIN FISIER TEXT ===");
        IStudentiImport importText = new StudentiDinFisierText(textFileName);
        List<Student> studentiDinText = importer.startImport(importText);
        exporter.startExport(new StudentiInConsola(), studentiDinText);

        System.out.println("\n=== CITIRE DIN FISIER EXCEL ===");
        IStudentiImport importExcel = new StudentiDinFisierXlsx(excelFileName);
        List<Student> studentiDinExcel = importer.startImport(importExcel);
        exporter.startExport(new StudentiInConsola(), studentiDinExcel);
    }
}
