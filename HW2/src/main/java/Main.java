import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.

        Class<?> stringClass = Class.forName("java.lang.String");

        Method[] methods = stringClass.getMethods();

        for (Method method: methods) {
            System.out.println("Method: " + method.getName());
        }
    }
}
