import java.io.*;

public class Main {
    // Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл.

    //Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person.
    // Реализуйте методы для добавления, обновления и удаления объектов Person.

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("VolanDeMort", 250);

        try(FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))

        {
            objectOutputStream.writeObject(person);
            System.out.println("Объект Person был сериализован");
        }

        try(FileInputStream fileInputStream = new FileInputStream("userdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))

        {
            person = (Person)objectInputStream.readObject();
            System.out.println("Объект Person был десериализован");
        }
    }
}
