package technology.touchmars.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;
import java.io.Serializable;

@Named("reviewBean")
@RequestScoped
public class ReviewBean implements Serializable {

    private static final long serialVersionUID = 1L;

}
