package Lab10.strategy;

import Modele.Student;
import java.util.List;

public class Exporter {
    public void startExport(IStudentiExport studentExport, List<Student> studenti) {
        studentExport.doExport(studenti);
    }
}
