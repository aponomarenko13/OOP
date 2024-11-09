package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Doctor implements Comparable<Doctor>{

    private String name;
    private String surname;
    private LocalDate birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return name.equals(doctor.name) && surname.equals(doctor.surname) && birthDate.equals(doctor.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }

    @Override
    public int compareTo(Doctor o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.surname.compareTo(o.surname) == 0){
            if (this.name.compareTo(o.name) == 0){
                return this.birthDate.isBefore(o.getBirthDate()) ? 1 : -1;
            } else {
                return this.name.compareTo(o.name);
            }
        }
        return this.surname.compareTo(o.surname);

    }
}
