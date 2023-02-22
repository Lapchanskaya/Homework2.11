import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        System.out.println("   *** Задание № 1 ***   ");

        List<Integer> numbers = Arrays.asList(5, 13, 250, 0, 157, 1_000_000, 250_000, 652, 353, 500, 25_657_587);
        List<Integer> numbers1 = List.of();

        BiConsumer<Integer, Integer> minMaxConsumer = (maxValue, minValue) -> {
            System.out.println(" Минимальное значение : " + minValue);
            System.out.println(" Максимальное значение : " + maxValue);
        };

        findMinMax(numbers.stream(), new Order(), minMaxConsumer);
        findMinMax(numbers1.stream(), new Order(), minMaxConsumer);


        printSeparation();
        System.out.println("   *** Задание № 2 ***   ");


        List<Integer> numbers2 = Arrays.asList(2, 40, 11, 15, 27, 30, 33, 44, 58, 50, 61, 96, 101,1,4);
        findEvenNumbers(numbers2);

    }


    public static void printSeparation() {
        System.out.println(" ================== ");
    }

    public static void findMinMax(Stream<Integer> stream,
                                  Comparator<Integer> order,
                                  BiConsumer<Integer, Integer> minMaxConsumer) {
        List<Integer> list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (!list.isEmpty()) {
            Integer minValue = list.get(0);
            Integer maxValue = list.get(list.size() - 1);
            minMaxConsumer.accept(maxValue, minValue);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void findEvenNumbers(List<Integer> list) {
        long numberOfEvens = list.stream()
                .filter(number -> number % 2 == 0)
                .count();
        List<Integer> listOfEvens = list.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(" Четные числа: " + listOfEvens.toString().replace("[", "").replace("]", ""));
        System.out.println(" Количество четных чисел в списке: " + numberOfEvens);
    }


}