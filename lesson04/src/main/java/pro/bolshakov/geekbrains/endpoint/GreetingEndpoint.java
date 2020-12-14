package pro.bolshakov.geekbrains.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pro.bolshakov.geekbrains.api.greeting.GetGreetingRequest;
import pro.bolshakov.geekbrains.api.greeting.GetGreetingResponse;
import pro.bolshakov.geekbrains.service.GreetingService;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
public class GreetingEndpoint {

    private static final String NAMESPACE_URL = "http://bolshakov.pro/geekbrains/api/greeting";

    private GreetingService greetingService;

    @Autowired
    public GreetingEndpoint(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getGreetingRequest")
    @ResponsePayload
    public GetGreetingResponse getGreeting(@RequestPayload GetGreetingRequest request)
            throws DatatypeConfigurationException {
        GetGreetingResponse response = new GetGreetingResponse();

        response.setGreeting(greetingService.generateGreeting(request.getName()));

        return response;
    }

}
