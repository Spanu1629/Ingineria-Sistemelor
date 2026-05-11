package Lab9;

import java.util.*;
import java.util.stream.Collectors;

public class Exercitiul2 {
    public static void main(String[] args) {

        String text = "Acesta este un program scris in java pentru expresii lambda";

        List<String> cuvinte = Arrays.asList(text.split(" "));

        System.out.println("Lista initiala: " + cuvinte);

        // a) Parcurgeti si numarati cuvintele ale caror lungime este >= 5.
        // Afisati lista filtrata.
        List<String> listaFiltrata = cuvinte.stream()
                .filter(e -> e.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("Lista filtrata: " + listaFiltrata);
        System.out.println("Numar cuvinte cu lungime >= 5: " + listaFiltrata.size());

        // b) Ordonati lista noua si apoi afisati.
        List<String> listaOrdonata = listaFiltrata.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Lista ordonata: " + listaOrdonata);

        // c) Afisati un element care incepe cu litera 'p'.
        Optional<String> element = cuvinte.stream()
                .filter(e -> e.startsWith("p"))
                .findFirst();

        if (element.isPresent()) {
            System.out.println("Element care incepe cu p: " + element.get());
        }
    }
}