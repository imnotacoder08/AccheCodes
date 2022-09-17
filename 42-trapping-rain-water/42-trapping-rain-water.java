class Solution {
    public int trap(int[] height) {
        int [] minL = new int[height.length];
        int [] maxR = new int[height.length];
        minL[0] =  height[0];
        maxR[height.length-1] =  height[height.length-1];
        for(int i = 1; i < height.length; i++){
            minL[i] = Math.max(height[i],minL[i-1]);
        }
        for(int i = height.length-2; i >=0; i--){
            maxR[i] = Math.max(height[i],maxR[i+1]);
        }
        int sum = 0;
        for(int i = 0; i < height.length; i++){
            sum+= Math.min(minL[i],maxR[i]) - height[i];
            
            }
        
            return sum;
    }
}