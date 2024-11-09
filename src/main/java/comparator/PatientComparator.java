package comparator;

import comparator.PatientComparator;
import model.Patient;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
