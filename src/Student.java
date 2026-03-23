import java.util.List;

public class Student {
    private int numarMatricol;
    private String nume;
    private String prenume;
    private String formatieDeStudiu;
    Student(int nr, String name, String pre, String grupa)
    {
        numarMatricol=nr;
        nume=name;
        prenume=pre;
        formatieDeStudiu=grupa;
    }
    public int getNrMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public String toString() {
        return "Numar Matricol: "+numarMatricol+", Nume: "+nume+", Prenume: "+prenume+", Formatie de Studiu: "+formatieDeStudiu;
    }
    public boolean existaInLista(List<Student> lista) {
        for (Student st : lista) {
            if (st.numarMatricol==this.numarMatricol&&
                    st.nume.equals(this.nume) &&
                    st.prenume.equals(this.prenume) &&
                    st.formatieDeStudiu.equals(this.formatieDeStudiu)) {
                return true;
            }
        }
        return false;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return nume.equals(s.nume) &&
                prenume.equals(s.prenume) &&
                formatieDeStudiu.equals(s.formatieDeStudiu);
    }
    public int hashCode() {
        return Objects.hash(nume, prenume, formatieDeStudiu);
    }
}
void main(){
    /*Student s1=new Student(120, "Popa", "Alis", "TI21/2");
    Student s2=new Student(112, "Popa", "Maria", "TI21/1");
    Student s3=new Student(125,"Popescu","Paul","ISM 21/1");
    List<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(s1);
    listaStudenti.add(s2);
    for (Student s : listaStudenti) {
        System.out.println(s);
    }
    Set<Student> setStudenti = new HashSet<>(listaStudenti);
    System.out.println("Exista studentul Alis? "+setStudenti.contains(s1));
    System.out.println("Exista studentul Maria? "+setStudenti.contains(s2));
    System.out.println("Exista studentul Paul? "+setStudenti.contains(s3));*/
    try {
        List<String> linii = Files.readAllLines(Paths.get("src/studenti_in.txt"));

        List<Student> studenti = new ArrayList<>();

        // citim fiecare linie si folosim split(",")
        for (String linie : linii) {
            String[] campuri = linie.split(",");

            int id = Integer.parseInt(campuri[0]);
            String prenume = campuri[1];
            String nume = campuri[2];
            String grupa = campuri[3];

            Student s = new Student(id, nume, prenume, grupa);
            studenti.add(s);
        }

        // afisam studentii cititi
        System.out.println("Studentii cititi din fisier:");
        for (Student s : studenti) {
            System.out.println(s);
        }

        // sortare dupa grupa, apoi dupa nume
        studenti.sort(Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume));

        // pregatim liniile pentru fisierul de iesire
        List<String> outLines = new ArrayList<>();
        for (Student s : studenti) {
            String linie = s.getNrMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu();
            outLines.add(linie);
        }

        // salvam in studenti_out.txt
        Files.write(Paths.get("src/studenti_out_sorted.txt"), outLines);

        System.out.println("Lista sortata a fost salvata in studenti_out.txt");

    } catch (IOException e) {
        System.out.println("Gresire la scriere");
    }
}