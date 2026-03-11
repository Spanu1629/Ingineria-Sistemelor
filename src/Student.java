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
}
void main(){
    Student s1=new Student(120, "Popa", "Alis", "TI21/2");
    Student s2=new Student(112, "Popa", "Maria", "TI21/1");
    Student s3=new Student(125,"Popescu","Paul","ISM 21/1");
    List<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(s1);
    listaStudenti.add(s2);
    for (Student s : listaStudenti) {
        System.out.println(s);
    }
    System.out.println("Studentul Alis exista? " + s1.existaInLista(listaStudenti));
    System.out.println("Studentul Maria exista? " + s2.existaInLista(listaStudenti));
    System.out.println("Studentul Paul exista? " + s3.existaInLista(listaStudenti));
}