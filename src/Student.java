public class Student {
    public int numarMatricol;
    public String nume;
    public String prenume;
    public int formatieDeStudiu;
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