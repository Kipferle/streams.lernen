package MultiplesOf3Or5;

import java.util.stream.IntStream;

public class Solution {
    public static int solution(int numba) {
        int ret = 0;
        int ix = 1;
        while (ix < numba) {
            if (ix % 3 == 0 || ix % 5 == 0) {
                ret = ret + ix;
            }
            ix++;
        }
        return ret;
    }

    public static int solutionStream(int numba) {
        return IntStream.range(1, numba)
                .filter(r -> r % 3 == 0 || r % 5 == 0)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(solution(20));
        System.out.println(solutionStream(20));
    }
}
