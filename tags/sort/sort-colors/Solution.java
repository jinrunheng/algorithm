class Solution {
    public void sortColors(int[] nums) {
        // 0...0,1...1,2...2
        int less = -1;
        int more = nums.length;
        int cur = 0;
        while (cur < more) {
            if (nums[cur] == 0) {
                swap(nums, cur++, ++less);
            } else if (nums[cur] == 2) {
                swap(nums, cur, --more);
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}