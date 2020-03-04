package homework.usersystem.annotations;

import homework.usersystem.constants.ErrorMessages;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements ConstraintValidator<Email, CharSequence> {
    private int minUsernameLength;
    private int maxUsernameLength;
    private int maxHostNameLength;
    private Pattern pattern;

    @Override
    public void initialize(final Email email) {
        this.minUsernameLength = email.minUsernameLength();
        this.maxUsernameLength = email.maxUsernameLength();
        this.maxHostNameLength = email.maxHostNameLength();
        this.pattern = Pattern.compile(email.regex());
    }

    @Override
    public boolean isValid(final CharSequence value, final ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        String email = value.toString();
        int usernameLength = email.indexOf('@');
        int hostNameLength = email.length() - usernameLength - 1;

        if (usernameLength < this.minUsernameLength) {
            AnnotationUtil.setErrorMessage(context, ErrorMessages.EMAIL_NAME_LENGTH_TOO_SHORT);
            return false;
        }

        if (usernameLength > this.maxUsernameLength) {
            AnnotationUtil.setErrorMessage(context, ErrorMessages.EMAIL_NAME_LENGTH_TOO_LONG);
            return false;
        }

        if (hostNameLength > this.maxHostNameLength) {
            AnnotationUtil.setErrorMessage(context, ErrorMessages.EMAIL_HOST_LENGTH_TOO_LONG);
            return false;
        }

        return this.pattern.matcher(email).matches();
    }
}
