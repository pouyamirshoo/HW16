package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import model.person.Student;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Current extends BaseEntity<Long> {
    @NotNull
    int year;
    @NotNull(message = "please enter the half term")
    @Range(min = 1, max = 2, message = "half term number must be 1 or 2")
    int halfTerm;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    Student student;
    @ManyToMany(cascade = CascadeType.MERGE)
    List<Lesson> lessons;

    public Current(int year, int halfTerm) {
        this.year = year;
        this.halfTerm = halfTerm;
    }

}

