package client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import server.HelloWorld;

/**
 * Created by toumi on 22/07/14.
 */
public class Client {

    public static void main(String[] args)
    {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(HelloWorld.class);
        factory.setAddress("http://localhost:9000/helloWorld");
        HelloWorld client = (HelloWorld) factory.create();

        String reply = client.sayHi("HI");
        System.out.println("Server said: " + reply);
        System.exit(0);
    }
}
