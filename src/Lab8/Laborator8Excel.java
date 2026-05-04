package Lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Laborator8Excel {

    public static void main(String[] args) {
        String inputFile = "laborator8_input.xlsx";

        citesteSiAfiseazaExcel(inputFile);

        genereazaOutput2(inputFile, "laborator8_output2.xlsx");

        genereazaOutput3(inputFile, "laborator8_output3.xlsx");
    }

    // 8.5.1
    public static void citesteSiAfiseazaExcel(String fileName) {
        System.out.println("=== 8.5.1 Citire fisier Excel ===");

        try (
                FileInputStream fis = new FileInputStream(fileName);
                Workbook workbook = new XSSFWorkbook(fis)
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    afiseazaCelula(cell);
                    System.out.print("\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }

    private static void afiseazaCelula(Cell cell) {
        if (cell == null) {
            System.out.print("");
            return;
        }

        if (cell.getCellType() == CellType.STRING) {
            System.out.print(cell.getStringCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) {
            double value = cell.getNumericCellValue();

            if (value == (int) value) {
                System.out.print((int) value);
            } else {
                System.out.print(value);
            }
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            System.out.print(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.FORMULA) {
            System.out.print(cell.getCellFormula());
        } else {
            System.out.print("");
        }
    }

    // 8.5.2
    public static void genereazaOutput2(String inputFile, String outputFile) {
        System.out.println("\n=== 8.5.2 Generare output2 ===");

        try (
                FileInputStream fis = new FileInputStream(inputFile);
                Workbook inputWorkbook = new XSSFWorkbook(fis);
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Output2");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());

                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    copiazaCelula(inputCell, outputCell);
                }

                int lastColumnIndex = inputRow.getLastCellNum();

                if (inputRow.getRowNum() == 0) {
                    outputRow.createCell(lastColumnIndex).setCellValue("Media");
                } else {
                    double nota1 = inputRow.getCell(3).getNumericCellValue();
                    double nota2 = inputRow.getCell(4).getNumericCellValue();
                    double nota3 = inputRow.getCell(5).getNumericCellValue();

                    double media = (nota1 + nota2 + nota3) / 3;

                    outputRow.createCell(lastColumnIndex).setCellValue(media);
                }
            }

            for (int i = 0; i <= inputSheet.getRow(0).getLastCellNum(); i++) {
                outputSheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWorkbook.write(fos);
            }

            System.out.println("Fisier creat: " + outputFile);

        } catch (IOException e) {
            System.out.println("Eroare la output2: " + e.getMessage());
        }
    }

    // 8.5.3
    public static void genereazaOutput3(String inputFile, String outputFile) {
        System.out.println("\n=== 8.5.3 Generare output3 ===");

        try (
                FileInputStream fis = new FileInputStream(inputFile);
                Workbook inputWorkbook = new XSSFWorkbook(fis);
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Output3");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());

                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    copiazaCelula(inputCell, outputCell);
                }

                int lastColumnIndex = inputRow.getLastCellNum();

                if (inputRow.getRowNum() == 0) {
                    outputRow.createCell(lastColumnIndex).setCellValue("Media Formula");
                } else {
                    int excelRowNumber = inputRow.getRowNum() + 1;

                    Cell formulaCell = outputRow.createCell(lastColumnIndex);
                    formulaCell.setCellFormula("AVERAGE(D" + excelRowNumber + ":F" + excelRowNumber + ")");
                }
            }

            for (int i = 0; i <= inputSheet.getRow(0).getLastCellNum(); i++) {
                outputSheet.autoSizeColumn(i);
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWorkbook.write(fos);
            }

            System.out.println("Fisier creat: " + outputFile);

        } catch (IOException e) {
            System.out.println("Eroare la output3: " + e.getMessage());
        }
    }

    private static void copiazaCelula(Cell inputCell, Cell outputCell) {
        if (inputCell == null) {
            return;
        }

        if (inputCell.getCellType() == CellType.STRING) {
            outputCell.setCellValue(inputCell.getStringCellValue());
        } else if (inputCell.getCellType() == CellType.NUMERIC) {
            outputCell.setCellValue(inputCell.getNumericCellValue());
        } else if (inputCell.getCellType() == CellType.BOOLEAN) {
            outputCell.setCellValue(inputCell.getBooleanCellValue());
        } else if (inputCell.getCellType() == CellType.FORMULA) {
            outputCell.setCellFormula(inputCell.getCellFormula());
        } else {
            outputCell.setBlank();
        }
    }
}