package RMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class RemoteHelloServiceImpl implements RemoteHelloService {

    public static final String BINDING_NAME = "sample/HelloService";

    public Object sayHello(String name) {
        String string = "Hello, " + name + "! It is " + System.currentTimeMillis() + " ms now";
        return string;
    }

    public static void main(String... args) throws Exception {
        final RemoteHelloService service = new RemoteHelloServiceImpl();

        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        System.out.print("Starting registry...");
        final Registry registry = LocateRegistry.createRegistry(2099);
        System.out.println(" OK");

        System.out.print("Binding service...");
        registry.bind(BINDING_NAME, stub);
        System.out.println(" OK");

    }
}