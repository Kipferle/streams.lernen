package SimpleMultiplication;

import java.util.stream.Stream;

public class Sid{
    public static int simpleMultiplication(int number) {
        return Stream.of(number)
                .mapToInt(x -> x % 2 == 0 ? x*8 : x*9)
                .sum();

    }

    public static void main(String[] args) {
        System.out.println( "Müsste  9 rauskommen: " + simpleMultiplication(1));
        System.out.println( "Müsste 16 rauskommen: " + simpleMultiplication(2));
        System.out.println( "Müsste 27 rauskommen: " + simpleMultiplication(3));
    }

}
