class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i,j,k,l;
        for(i = 0; i <= n-4; i++ )
        {
            if (i > 0 && nums[i] == nums[i - 1])
                        continue;
            for(j = i+1; j <= n-3; j++){
                
                if (j > i+1 && nums[j] == nums[j - 1])
                        continue;
                k = j+1;
                l = n-1;
                while(k < l)
                {
                    long sum = (long)nums[i]+ nums[j]+nums[k]+nums[l];

                    if(sum < target){
                        k++;
                    }
                    else if(sum > target){
                        l--;
                    }
                    else
                    {                    
                        list.add(Arrays.asList(nums[i], nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        while(k < n && nums[k] == nums[k - 1])
                        {
                            k++;
                        }
                        while(k < l && nums[l] == nums[l + 1])
                        {
                            l--;
                        }
                    }
                }
            }
        }
        return list;
    }
}