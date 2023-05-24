class Solution {
    public int minimumAverageDifference(int[] nums) 
    {
        
        
        
        int l = nums.length;  
        int index = 0;
        long min = Integer.MAX_VALUE, sum = 0, leftsum = 0, rightsum = 0;
        for (int j = 0; j < l; j++) {
            sum = sum + nums[j];
        }
        for (int i = 0; i < l; i++) {
            leftsum += nums[i];
            rightsum = sum - leftsum;
            long diff = Math.abs(leftsum / (i + 1) - (l - i == 1 ? 0 : rightsum / (l - i - 1)));  // if number of rightsum values = 0
            if (diff < min) {
                min = diff;
                index = i;
            }
        }
        return index;
        
//         int n = nums.length;
//         System.out.println(n);
//         float a[] = new float[n]; // stores i+1 elements of nums average at ith index
//         float b[] = new float[n]; // stores n-i-1 elements of nums average at ith index
//         int min = Integer.MAX_VALUE;
//         int index = 0;
        
//         a[0] = nums[0];
//         b[n-1] = 0;
//         for(int i = 1; i < n; i++){
//             a[i] = (i * a[i-1] + nums[i])/(i + 1);
//             b[n-i-1] = ((i-1) * b[n-i] + nums[n-i])/(i);
//         }
        
        
//         for(int i = 0; i < n; i++)
//         {
//             int diff = (int)Math.abs(Math.floor(a[i]) - Math.floor(b[i]));
//             if(min > diff)
//             {
//                 min = diff;
//                 index = i;
//             }
//         }
        
//         return index;
    }
}