class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftptr = 0;
        int rightptr = n - 1;
        int leftmax = height[0];
        int rightmax = height[rightptr];
        int res = 0;
        while(leftptr < rightptr){
            if(rightmax > leftmax)
            {
                // Increment left pntr
                leftptr++;
                if(height[leftptr] > leftmax){
                    leftmax = height[leftptr];
                }
                else{
                    res += leftmax - height[leftptr];
                }
            }
            else{
                // decrement right pntr
                rightptr--;
                if(height[rightptr] > rightmax){
                    rightmax = height[rightptr];
                }
                else{
                    res += rightmax - height[rightptr];
                }
            }
        }

        return res;
    }
}