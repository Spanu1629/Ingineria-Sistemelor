public class Student {
    private int numarMatricol;
    private String nume;
    private String prenume;
    private int formatieDeStudiu;
    Student(int nr, String name, String pre, int grupa)
    {
        numarMatricol=nr;
        nume=name;
        prenume=pre;
        formatieDeStudiu=grupa;
    }
    public String toString() {
        return "Numar Matricol: "+numarMatricol+", Nume: "+nume+", Prenume: "+prenume+", Formatie de Studiu: "+formatieDeStudiu;
    }
}