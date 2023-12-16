import java.util.ArrayList;
import java.util.Scanner;

public class PracticalNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter N: ");

        int n = input.nextInt();

        System.out.println("practical(" + n + ") => " + practicalNum(n));
    }

    /**
     * this function finds all divisors of a positive integer, n
     * @param n a positive integer
     * @return an ArrayList containing all divisors of n
     */
    public static ArrayList<Integer> divisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        divisors.add(1);
        // find distinct divisors of N
        if (n % 2 == 0) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0)
                    divisors.add(i);
            }
        } else {
            for (int i = 3; i <= n; i += 2) {
                if (n % i == 0)
                    divisors.add(i);
            }
        }
        return divisors;
    }

    public static Boolean practicalNum(int n) {
        ArrayList<Integer> divisors = divisors(n);
        Boolean isPractical = true;
        for (int i = 1; i <= n; i++) {
            int sum = i;
            for (int j = divisors.size() - 1; j > -1; j--) {
                if ((sum - divisors.get(j)) >= 0) {
                    sum -= divisors.get(j);
                }
            }
            if (sum != 0)
                isPractical = false;
        }
        return isPractical;
    }
}