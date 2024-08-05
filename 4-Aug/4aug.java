// Brute Force Solution
        class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = nums.length;
        int size = len * (len + 1) / 2;
        int MOD = 1000000007;
        int[] res = new int[size];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = (sum + nums[j]) % MOD;
                res[index] = sum;
                index++;
            }
        }

        Arrays.sort(res);
        int ans = 0;

        left = left - 1;
        right = right - 1;

        for (int i = left; i <= right; i++) {
            ans = (ans + res[i]) % MOD;
        }

        return ans;
    }
}
        //Space and Time Complexity
        //Brute Force Solution: Time Complexity - O(n^2 log n), Space Complexity - O(n^2)
