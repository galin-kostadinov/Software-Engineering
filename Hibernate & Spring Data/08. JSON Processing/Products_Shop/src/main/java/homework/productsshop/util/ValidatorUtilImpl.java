package homework.productsshop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {
    private final Validator validator;

    @Autowired
    public ValidatorUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).size() == 0;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> violations(T entity) {
        return this.validator.validate(entity);
    }
}
