package technology.touchmars.webservice.soap;

import java.math.BigDecimal;
import java.time.Instant;

public class Lab {
    public static void main(String[] args) {
        Class c = HelloWebService.class;
        System.out.println(c.getSimpleName());

        String currency = "100,00";
        BigDecimal d = new BigDecimal(currency.replaceAll(",", ""));
        System.out.println(d.floatValue());

        System.out.println(Instant.now().toEpochMilli());

    }
}
