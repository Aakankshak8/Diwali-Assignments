import java.util.*;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the number of rotations (k): ");
        int k = sc.nextInt();

        rotate(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(nums));

        sc.close();
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 

        int[] result = new int[n];

        for (int i = 0; i < k; i++) {
            result[i] = nums[n - k + i];
        }

        for (int i = 0; i < n - k; i++) {
            result[k + i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}
