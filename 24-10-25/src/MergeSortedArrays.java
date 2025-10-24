import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {2,4,6,8};
        int[] nums2 = {9,10,11,21};

        int[] merged = mergeSortedArrays(nums1, nums2);

        System.out.println("Merged Array: " + Arrays.toString(merged));
    }

    public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < n) {
            merged[k++] = nums1[i++];
        }

        while (j < m) {
            merged[k++] = nums2[j++];
        }

        return merged;
    }
}
