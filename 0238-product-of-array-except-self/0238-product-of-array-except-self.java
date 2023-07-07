class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = nums[0];
        for(int i = 1; i < n - 1; i++){
            ans[i] = ans[i-1]*nums[i]; // stores left product prefix
        }
        
        int rightprod = nums[n-1];
        ans[n-1] = ans[n-2];
        for(int i = n-2; i > 0; i--)
        {
            ans[i] = ans[i-1] * rightprod;
            rightprod *= nums[i]; 
        }
        ans[0] = rightprod;
        return ans;
    }
}