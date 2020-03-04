package homework.usersystem.annotations;


import homework.usersystem.constants.ErrorMessages;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default ErrorMessages.INVALID_PASSWORD_FORMAT;

    int minPasswordLength() default 6;

    int maxPasswordLength() default 50;

    boolean containsLowercaseLetter() default false;

    boolean containsUppercaseLetter() default false;

    boolean containsDigit() default false;

    boolean containsSpecialSymbol() default false;
}
