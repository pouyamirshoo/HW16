package model;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import model.person.Teacher;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
public class Term extends BaseEntity<Long> {
    @NotNull(message = "please enter year of term")
    @Range(min = 1375,max= 1402,message = "year of term must be between 1375 - 1402")
    int yearOfTerm;
    @NotNull(message = "please enter the half term")
    @Range(min = 1,max = 2,message = "half term number must be 1 or 2")
    int halfTerm;
    @NotNull(message = "please enter the count Of Lessons")
    @Range(min = 12,max = 29,message = "teachers can not get less than 12 units or more than 29")
    int countOfLessons;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    Teacher teacher;

    public Term(int yearOfTerm, int halfTerm, int countOfLessons) {
        this.yearOfTerm = yearOfTerm;
        this.halfTerm = halfTerm;
        this.countOfLessons = countOfLessons;
    }
}
