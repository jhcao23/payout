package technology.touchmars.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWebService {
    private String message = new String("Hello, ");

    public void Hello() {}

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }

    public static void main(String[] args) {
        Class c = HelloWebService.class;
        System.out.println(c.getSimpleName());
    }
}
