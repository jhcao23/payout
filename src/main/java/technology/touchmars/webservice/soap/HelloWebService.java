package technology.touchmars.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;

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

        String currency = "100,00";
        BigDecimal d = new BigDecimal(currency);
        System.out.println(d.floatValue());

    }
}
