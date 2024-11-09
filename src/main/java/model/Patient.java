package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Patient {

    private String title;
    private SpecializationType type;
    private Doctor doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return title.equals(patient.title) && type == patient.type && doctor.equals(patient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, doctor);
    }
}
