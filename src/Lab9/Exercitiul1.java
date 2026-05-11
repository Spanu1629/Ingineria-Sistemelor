package Lab9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercitiul1 {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + numere);

        // a) Calculati suma elementelor folosind java streams si afisati.
        int suma = numere.stream()
                .mapToInt(e -> e)
                .sum();

        System.out.println("Suma elementelor: " + suma);

        // b) Calculati valoarea maxima si minima in lista. Afisati.
        int maxim = numere.stream()
                .max(Comparator.naturalOrder())
                .get();

        int minim = numere.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Maxim: " + maxim);
        System.out.println("Minim: " + minim);

        // c) Pastrarea doar a elementelor in intervalul [10..20].
        List<Integer> listaFiltrata = numere.stream()
                .filter(e -> e >= 10 && e <= 20)
                .collect(Collectors.toList());

        System.out.println("Elemente in intervalul [10..20]: " + listaFiltrata);

        // d) Transformati lista de intregi in alta lista care sa contina valori Double.
        List<Double> listaDouble = numere.stream()
                .map(e -> Double.valueOf(e))
                .collect(Collectors.toList());

        System.out.println("Lista Double: " + listaDouble);

        // e) Afisati daca in lista se gaseste valoarea 12.
        boolean exista12 = numere.stream()
                .anyMatch(e -> e == 12);

        System.out.println("Exista valoarea 12? " + exista12);
    }
}