package ServerSide;

import ServerSide.HelloWorld;

import javax.jws.WebService;

@WebService (endpointInterface = "ServerSide.HelloWorld")
public class HelloWorldImpl implements HelloWorld {


    @Override
    public String getHelloWorldAsString(String name) {
        return "meesage returned from the server " + Math.random() + name ;
    }
}
