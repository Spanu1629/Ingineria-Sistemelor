package Lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lab3 {
      void main(){
          try {
              List<String> liniiFisier = Files.readAllLines(Paths.get("src/Lab3/in.txt"));

              // transformam lista intr-un singur text
              String text = "";
              for (String linie : liniiFisier) {
                  text = text + linie + "\n";
              }

              // folosim split pentru a separa liniile
              String[] linii = text.split("\n");

              // liste pentru rezultate
              List<String> rezultatA = new ArrayList<>();
              List<String> rezultatB = new ArrayList<>();

              // a) adaugam inca un newline la sfarsitul fiecarei linii
              System.out.println("Rezultatul pentru a):");
              for (String linie : linii) {
                  String linieNoua = linie + "\n";
                  rezultatA.add(linieNoua);
                  System.out.println(linieNoua);
              }

              // b) adaugam newline dupa fiecare punct
              System.out.println("Rezultatul pentru b):");
              for (String linie : linii) {
                  String linieNoua = linie.replace(".", ".\n");
                  rezultatB.add(linieNoua);
                  System.out.println(linieNoua);
              }

              // c) salvam in out.txt rezultatele de la a) si b)
              List<String> outLines = new ArrayList<>();
              outLines.add("Rezultatul de la a):");
              outLines.addAll(rezultatA);
              outLines.add("Rezultatul de la b):");
              outLines.addAll(rezultatB);

              //Path pathOut = Paths.get("out.txt");
              Files.write(Paths.get("src/Lab3/out.txt"), outLines);

              System.out.println("S-a scris in out.txt");

            } catch (IOException e) {
             System.out.println("Eroare la citire");;
            }
      }
}

