package technology.touchmars.jsf;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("hello2") // default name is "hello"; developer can alter it in this way
@RequestScoped
//@ViewScoped
public class Hello implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String name;
    private String message;

    public void createMessage() {
        message = "Hello, " + name + "!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message==null? null : message + "::2";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
