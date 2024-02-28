import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// Напишите программу, которая использует Stream API для обработки списка чисел.
// Программа должна вывести на экран среднее значение всех четных чисел в списке.

        List<Integer> list = Arrays.asList(1,2,3,8,5,4,6,7,9,11,10,15,12,14);
        System.out.println(list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).average().getAsDouble());

    }
}