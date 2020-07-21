package technology.touchmars.webservice.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "technology.touchmars.webservice.soap.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    private String message = new String("Hello, ");

    @Override
    public String sayHello(String name) {
        return message + name + "!";
    }

}
