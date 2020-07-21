package technology.touchmars.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

@FacesValidator("csvFileValidator")
public class CsvFileValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part)o;
        if (file.getSize() > 1024*1024) {
            msgs.add(new FacesMessage("file too big"));
        }
        if (!"text/plain".equals(file.getContentType())) {
            msgs.add(new FacesMessage("not a text file"));
        }
        if (!file.getSubmittedFileName().endsWith(".csv")) {
            msgs.add(new FacesMessage("only csv file is allowed to upload!!!"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }
    }
}
