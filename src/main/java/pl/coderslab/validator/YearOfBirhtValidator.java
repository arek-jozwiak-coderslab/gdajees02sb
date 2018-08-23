package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class YearOfBirhtValidator implements ConstraintValidator<YearOfBirth, Integer> {

    @Override
    public void initialize(YearOfBirth startWith) {

    }

    public boolean isValid(Integer obj, ConstraintValidatorContext context) {
        return LocalDate.now().getYear() - obj >= 18;
    }
}
