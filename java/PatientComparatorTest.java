package comparator.src.test.java;

import comparator.src.main.java.comparator.PatientComparator;
import comparator.src.main.java.model.Doctor;
import comparator.src.main.java.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PatientComparatorTest {
    private static final String PATIENT_1_TITLE = "Funny English course";
    private static final String PATIENT_2_TITLE = "Germany native course";
    private static final String DOCTOR_1 = "Bill";
    private static final String DOCTOR_2 = "Tom";
    private static final String DOCTOR_1_SUR = "Simpson";
    private static final String DOCTOR_2_SUR = "Muller";
    private static final LocalDate DATE = LocalDate.parse("1998-12-05");
    private static final LocalDate DATE2 = LocalDate.parse("1990-06-18");


    @Test
    @DisplayName("Сортировка только по названию")
    void sortBookByTitle(){

        List<Patient> sortingByTitle = new ArrayList<>();
        sortingByTitle.add(
                new Patient()
                .setTitle(PATIENT_1_TITLE)
                .setDoctor(
                        new Doctor()
                                .setBirthDate(DATE)
                                .setName(DOCTOR_1)
                                .setSurname(DOCTOR_1_SUR)
                ));
        sortingByTitle.add(
                new Patient()
                .setTitle(PATIENT_2_TITLE)
                .setDoctor(
                        new Doctor()
                                .setBirthDate(DATE2)
                                .setName(DOCTOR_2)
                                .setSurname(DOCTOR_2_SUR)
                ));
        sortingByTitle.sort(new PatientComparator());
        Assertions.assertEquals(sortingByTitle.get(0).getTitle(), PATIENT_1_TITLE);
    }

    @Test
    @DisplayName("Сортировка по названию и преподавателя")
    void sortBookByTitleAndAuthor(){

        List<Patient> sortingByTitleAndDoctor = new ArrayList<>();
        sortingByTitleAndDoctor.add(
                new Patient()
                        .setTitle(PATIENT_1_TITLE)
                        .setDoctor(
                                new Doctor()
                                        .setBirthDate(DATE)
                                        .setName(DOCTOR_1)
                                        .setSurname(DOCTOR_1_SUR)
                        ));
        sortingByTitleAndDoctor.add(
                new Patient()
                        .setTitle(PATIENT_2_TITLE)
                        .setDoctor(
                                new Doctor()
                                        .setBirthDate(DATE2)
                                        .setName(DOCTOR_1)
                                        .setSurname(DOCTOR_1_SUR)
                        ));
        sortingByTitleAndDoctor.add(
                new Patient()
                        .setTitle(PATIENT_2_TITLE)
                        .setDoctor(
                                new Doctor()
                                        .setBirthDate(DATE)
                                        .setName(DOCTOR_2)
                                        .setSurname(DOCTOR_2_SUR)
                        ));
        sortingByTitleAndDoctor.sort(Comparator.comparing(Patient::getTitle).thenComparing(Patient::getDoctor));

        Assertions.assertEquals(sortingByTitleAndDoctor.get(1).getDoctor().getName(), DOCTOR_2);
    }

}
