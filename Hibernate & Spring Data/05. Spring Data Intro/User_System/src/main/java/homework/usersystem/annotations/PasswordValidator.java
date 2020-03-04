package homework.usersystem.annotations;

import homework.usersystem.constants.ErrorMessages;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {
    private static final Pattern PATTERT_LOWER = Pattern.compile("[a-z]");
    private static final Pattern PATTERT_UPPER = Pattern.compile("[A-Z]");
    private static final Pattern PATTERN_DIGIT  = Pattern.compile("[0-9]");
    private static final Pattern PATTERN_SYMBOL = Pattern.compile("[!@#$%^&*()_+<>?]");

    private int minPasswordLength;
    private int maxPasswordLength;
    private boolean hasToContainLowercase;
    private boolean hasToContainUppercase;
    private boolean hasToContainDigit;
    private boolean hasToContainSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minPasswordLength = password.minPasswordLength();
        this.maxPasswordLength = password.maxPasswordLength();
        this.hasToContainLowercase = password.containsLowercaseLetter();
        this.hasToContainUppercase = password.containsUppercaseLetter();
        this.hasToContainDigit = password.containsDigit();
        this.hasToContainSpecialSymbol = password.containsSpecialSymbol();
    }

    @Override
    public boolean isValid(final CharSequence value,final ConstraintValidatorContext context) {
        if (value == null) {
            AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_CANNOT_BE_NULL);
            return false;
        }

        String password = value.toString();

        if (password.length() < this.minPasswordLength) {
            AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_TOO_SHORT);
            return false;
        }

        if (password.length() > this.maxPasswordLength) {
            AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_TOO_LONG);
            return false;
        }

        if (this.hasToContainLowercase){
            if (!PATTERT_LOWER.matcher(password).matches()){
                AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_SHOULD_CONTAIN_LOWERCASE_LETTER);
                return false;
            }
        }

        if (this.hasToContainUppercase){
            if (!PATTERT_UPPER.matcher(password).matches()){
                AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_SHOULD_CONTAIN_UPPERCASE_LETTER);
                return false;
            }
        }

        if (this.hasToContainDigit){
            if (!PATTERN_DIGIT.matcher(password).matches()){
                AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_SHOULD_CONTAIN_DIGIT);
                return false;
            }
        }

        if (this.hasToContainSpecialSymbol){
            if (!PATTERN_SYMBOL.matcher(password).matches()){
                AnnotationUtil.setErrorMessage(context, ErrorMessages.PASSWORD_SHOULD_CONTAIN_SPECIAL_SYMBOL);
                return false;
            }
        }

        return true;
    }
}
