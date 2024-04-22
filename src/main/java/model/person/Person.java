package model.person;

import base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import util.validation.ValidationCode;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
@ToString
public class Person extends BaseEntity<Long> {
    @NotNull(message = "firstName most not null" )
    String firstName;
    @NotNull(message = "lastName most not null" )
    String lastName;
    @NotNull(message = "username most not null" )
    @Column(unique = true)
    String username;
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#!%&*])[A-Za-z0-9@#!%&*]{8,10}$"
            ,message = "password has to be between 8 to 10 and must contain at least 1 lower and upper case and 1 digit and 1 char ")
    String password;
    @NotNull(message = "nationalCode most not null" )
    @ValidationCode(message = "please enter a valid national code")
    @Column(unique = true)
    String nationalCode;
    @NotNull(message = "phoneNumber most not null" )
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")
    @Column(unique = true)
    String phoneNumber;
    @NotNull(message = "birthDate most not null" )
    String birthDate;
    @NotNull(message = "firstName most not null" )
    @Email(message = "please enter a valid email")
    String email;

}
