package technology.touchmars.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import static javax.jws.soap.SOAPBinding.Style.RPC;

@WebService
@SOAPBinding(style= RPC)
public interface HelloWebService {

    @WebMethod
    public String sayHello(String name);
}
