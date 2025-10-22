import java.util.Scanner;

public class Que4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = 0;
        int temp = n;

        while (temp != 0) {
            int digit = temp % 10; 
            sum += digit;          
            temp /= 10;            
        }

        System.out.println("Sum of digits of " + n + " is: " + sum);

        sc.close();

	}

}
