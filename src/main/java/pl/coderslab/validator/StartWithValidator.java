package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {

    private String startString;

    @Override
    public void initialize(StartWith startWith) {
        this.startString = startWith.value();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {

        return obj.startsWith(startString);
    }
}
