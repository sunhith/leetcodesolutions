class Solution {
    public int minimumAverageDifference(int[] nums) 
    {     
        // Approach -1 
        long[] diff = new long[nums.length];
        long sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            diff[i]=sum;
        }
        Long ans = Long.MAX_VALUE;
        int idx =-1;
        for(int i=0;i<nums.length;i++){
            long num1= (long)((float)diff[i]/(i+1));
            long num2 =(long)((float)(sum-diff[i])/(nums.length-i-1));
            long min = Math.abs(num1 -num2);
            if(min<ans){
                ans =min;
                idx =i;
            }
        }
        return idx;
        
        // Approach -2
        
//         int l = nums.length;  
//         int index = 0;
//         long min = Integer.MAX_VALUE, sum = 0, leftsum = 0, rightsum = 0;
//         for (int j = 0; j < l; j++) 
//         {
//             sum = sum + nums[j] ;
//         }
        
//         for (int i = 0; i < l; i++) {
//             leftsum += nums[i];
//             rightsum = sum - leftsum;
//             long diff = Math.abs(leftsum / (i + 1) - (l - i == 1 ? 0 : rightsum / (l - i - 1)));  // if number of rightsum values = 0
//             if (diff < min) {
//                 min = diff;
//                 index = i;
//             }
//         }
//         return index;  
    }
}