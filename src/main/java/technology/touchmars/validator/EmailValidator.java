package technology.touchmars.validator;

import technology.touchmars.util.StringUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator
{

    @Override
    public void validate(FacesContext context, UIComponent c, Object val) throws ValidatorException
    {
        String email = (String) val;
        Pattern mask = null;
        mask = Pattern.compile(StringUtil.EMAIL_REGEXP);
        Matcher matcher = mask.matcher(email);

        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Please enter a valid email");
            message.setSummary("Email not valid");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }

}
