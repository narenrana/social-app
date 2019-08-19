package com.sgroup.socialapp.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class LengthValidator implements ConstraintValidator<ValidLength, List<String> > {

    @Override
    public boolean isValid(List<String> userList, ConstraintValidatorContext context) {

          if(userList.size()!=2){ return false;}

        return  true;

    }
}