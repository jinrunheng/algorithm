class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        if (l > r) return -1;

        int mid = l + ((r - l) >> 1);


        if (nums[mid] == target)
            return mid;
        else if (target > nums[mid])
            return search(nums, mid + 1, r, target);
        else
            return search(nums, l, mid - 1, target);
    }
}