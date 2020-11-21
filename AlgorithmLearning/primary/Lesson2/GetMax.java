package primary.Lesson2;

public class GetMax {

    public static int getMax(int[] arr) {
        return getMax(arr, 0, arr.length - 1);
    }

    private static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int mid = l + ((r - l) >> 1);
        int leftMax = getMax(arr, l, mid);
        int rightMax = getMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 6, 8, 10, 7};
        System.out.println(getMax(arr));
    }
}
