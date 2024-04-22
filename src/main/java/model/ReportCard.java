package model;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ReportCard extends BaseEntity<Long> {
    @NotNull(message = "please enter year of term")
    @Range(min = 1375,max= 1402,message = "year of term must be between 1375 - 1402")
    private
    int yearOfTerm;
    @NotNull(message = "please enter the half term")
    @Range(min = 1,max = 2,message = "half term number must be 1 or 2")
    private
    int halfTerm;
    @Range(min = 0,max = 20,message = "the lesson grade must be between 0 - 20")
    private
    int lessonGrade;
    @NotNull
    private
    Long lessonId;
    @NotNull
    private
    Long studentId;

    public ReportCard(int yearOfTerm, int halfTerm, int lessonGrade, Long lessonId, Long studentId) {
        this.yearOfTerm = yearOfTerm;
        this.halfTerm = halfTerm;
        this.lessonGrade = lessonGrade;
        this.lessonId = lessonId;
        this.studentId = studentId;
    }

    public String toString() {
        return "ReportCard(yearOfTerm=" + this.getYearOfTerm() + ", halfTerm=" + this.getHalfTerm() + ", lessonGrade=" + this.getLessonGrade()  + ")";
    }
}
