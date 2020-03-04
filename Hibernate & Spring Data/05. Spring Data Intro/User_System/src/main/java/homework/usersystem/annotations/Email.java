package homework.usersystem.annotations;

import homework.usersystem.constants.ErrorMessages;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Component
@Constraint(validatedBy = EmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Email {
    String message() default ErrorMessages.INVALID_EMAIL_FORMAT;

    int minUsernameLength() default 4;

    int maxUsernameLength() default 30;

    int maxHostNameLength() default 40;

    String regex() default "^([a-zA-Z0-9][-_.]?)*[a-zA-Z0-9]@([a-zA-Z][-]?)*[a-zA-Z](.([a-zA-Z][-]?)*[a-zA-Z])+$";
}
