package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import enums.Fields;
import org.hibernate.validator.constraints.Range;


@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
public class Lesson extends BaseEntity<Long> {
    @NotNull(message = "name of lesson must not null")
    @Column(unique = true)
    String name;
    @Range(min = 1, max = 4, message = "lesson count must between 1 to 4")
    int count;
    Fields fields;

    public Lesson(String name, int count, Fields fields) {
        this.name = name;
        this.count = count;
        this.fields = fields;
    }
}
