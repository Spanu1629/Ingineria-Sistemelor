package Lab4;

import java.util.HashMap;
import java.util.Map;

public class Lab4 {
    public static void main(String[] args) {

        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );

        // a)
        System.out.println("Varste initiale:");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("\nVarste dupa adaugare:");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // b) + c)
        HashMap<String, Tanar> tineri = new HashMap<>();

        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            String nume = entry.getKey();
            int varsta = entry.getValue();
            String adresa = adrese.getOrDefault(nume, "Necunoscuta");

            Tanar tanar = new Tanar(nume, varsta, adresa);
            tineri.put(nume, tanar);
        }

        // d)
        System.out.println("\nTineri:");
        for (Map.Entry<String, Tanar> entry : tineri.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}