package model.person;

import enums.HireCondition;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import model.Term;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Teacher extends Person{
    HireCondition hireCondition;
    @NotNull
    @Column(unique = true)
    String teacherCode;
    @OneToMany(mappedBy ="teacher",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Term> terms;

    public Teacher(@NotNull(message = "firstName most not null") String firstName, @NotNull(message = "lastName most not null")
    String lastName, @NotNull(message = "username most not null")
    String username, @NotNull @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#!%&*])[A-Za-z0-9@#!%&*]{8,10}$"
            , message = "password has to be between 8 to 10 and must contain at least 1 lower and upper case and 1 digit and 1 char ")
    String password, @NotNull(message = "nationalCode most not null")
    String nationalCode, @NotNull(message = "phoneNumber most not null") @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$") String phoneNumber, @NotNull(message = "birthDate most not null") String birthDate, @NotNull(message = "firstName most not null") @Email(message = "please enter a valid email") String email, HireCondition hireCondition, String teacherCode,
                   List<Term> terms) {
        super(firstName, lastName, username, password, nationalCode, phoneNumber, birthDate, email);
        this.hireCondition = hireCondition;
        this.teacherCode = teacherCode;
        this.terms = terms;
    }
}
