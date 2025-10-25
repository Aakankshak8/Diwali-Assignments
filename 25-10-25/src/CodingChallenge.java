import java.util.Scanner;
public class CodingChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter a string: ");
		        String str = sc.nextLine();

		        if (str.matches("[a-zA-Z0-9]+")) {
		            System.out.println("The string contains only alphanumeric characters.");
		        } else {
		            System.out.println("The string contains special characters.");
		        }

		        sc.close();
		    

	}

}
