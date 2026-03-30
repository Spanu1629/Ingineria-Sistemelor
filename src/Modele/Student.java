package Modele;
import java.util.List;
import java.util.Objects;

public class Student {
    private int numarMatricol;
    private String nume;
    private String prenume;
    private String formatieDeStudiu;
    private float nota;

    public Student(int nr, String name, String pre, String grupa)
    {
        numarMatricol = nr;
        nume = name;
        prenume = pre;
        formatieDeStudiu = grupa;
        nota = 0.0f;
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String toString() {
        return "Numar Matricol: " + numarMatricol +
                ", Nume: " + nume +
                ", Prenume: " + prenume +
                ", Formatie de Studiu: " + formatieDeStudiu +
                ", Nota: " + nota;
    }

    public boolean existaInLista(List<Student> lista) {
        for (Student st : lista) {
            if (st.numarMatricol == this.numarMatricol &&
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
        return numarMatricol == s.numarMatricol;
    }

    public int hashCode() {
        return Objects.hash(numarMatricol);
    }
}