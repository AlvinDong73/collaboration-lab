import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TeamApp {
    public static void main(String[] args) {
        System.out.println("Our team application");
        System.out.println("Welcome!");
        System.out.println("Feature added by Dan");
        System.out.println("Some other feature");
        System.out.println("Christian's new line of code");

        printTeamInfo();
    }

    public static void printTeamInfo()
    {
        System.out.println("Created by the CS 067 team (second branch)");
        printGoodbye();
    }

    public static void printGoodbye() {
        System.out.println("Thanks for using our application!");
    }

    public static void saveTestPerson() {
        try {
            FileOutputStream stream = new FileOutputStream("TestPerson.dat");
            ObjectOutputStream objectFile = new ObjectOutputStream(stream);
            Person p = new Person("Alvin", 20);
            objectFile.writeObject(p);
            objectFile.close();
        } catch (IOException e) {
            System.out.println("Something went wrong during serialization:");
            System.out.println(e);
        }
    }

    public static Person loadTestPerson() {
        try {
            FileInputStream stream = new FileInputStream("TestPerson.dat");
            ObjectInputStream objectInput = new ObjectInputStream(stream);
            Person p = (Person) objectInput.readObject();
            objectInput.close();
            return p;
        } catch (FileNotFoundException e) {
            System.out.println("TestPerson.dat does not exist.");
        } catch (Exception e) {
            System.out.println("Something went wrong during deserialization:");
            System.out.println(e);
        }
        return null;
    }
}