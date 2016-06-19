package main.java;

import java.util.HashMap;
import java.util.Map;

public class MainApp<T> {

    private final Map<String, T> map = new HashMap<String, T>();


    //Вместо String можно использовать некий интерфейс;
    //В данном примере мы из мапы вытаскиваем все зависимости по ключу String.
    public void RegisterType(String string, T type) {
        map.put(string, type);
    }

    public T Resolve(String s) {
        return (T)map.get(s);
    }

    public static void main(String[] args) {
        MainApp main = new MainApp();
        main.RegisterType("Client", new Client());
        Client client = (Client) main.Resolve("Client");
        System.out.println(client.getBellow());
        main.RegisterType("Person", new Person());
        Person person = (Person) main.Resolve("Person");
        System.out.println(person.getName());
    }
}
