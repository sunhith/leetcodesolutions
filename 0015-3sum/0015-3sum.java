import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        //List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int i,j,k;
        for ( i= 0; i < n; i++)
        {
            j = i+1;
            k = n-1;
            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else
                {
                    List<Integer> triplet = new ArrayList(3);
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    set.add(triplet);
                    j++;
                    k--;
                    while(j < n && nums[j] == nums[j - 1])
                    {
                        j++;
                    }
                    while(k < n-1 && nums[k] == nums[k + 1])
                    {
                        k++;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}