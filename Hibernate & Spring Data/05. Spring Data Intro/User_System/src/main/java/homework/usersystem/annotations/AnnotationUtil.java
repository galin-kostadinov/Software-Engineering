package homework.usersystem.annotations;

import javax.validation.ConstraintValidatorContext;

public class AnnotationUtil {
    public AnnotationUtil() {
    }

    public static void setErrorMessage(final ConstraintValidatorContext context, final String errorMassege){
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMassege).addConstraintViolation();
    }
}
