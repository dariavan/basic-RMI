package RMI;

import java.rmi.registry.*;

public class HelloServiceClient {

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        RemoteHelloService service = (RemoteHelloService) registry.lookup("sample/HelloService");
        String[] names = { "Dasha", "Masha", "Sasha", "Pasha", "Natasha", "Glasha"};
        for (String name : names) {
            System.out.println(service.sayHello(name));
        }
    }

}