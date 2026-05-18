package Lab10.strategy;

import Modele.Student;
import java.util.List;

public class Importer {
    public List<Student> startImport(IStudentiImport studentImport) {
        return studentImport.doImport();
    }
}
