class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int leftptr = 0;
        int rightptr = n - 1;
        int maxArea = 0;
        while(leftptr < rightptr){
            int area = 0;
            if(height[rightptr] > height[leftptr])
            {
                area = (rightptr - leftptr) * height[leftptr];
                // increment left ptr
                leftptr++;
            }
            else
            {
                area = (rightptr - leftptr) * height[rightptr];
                // decrement left ptr
                rightptr--;
            }
            if(maxArea < area) maxArea = area;
        }
        return maxArea;
    }
}