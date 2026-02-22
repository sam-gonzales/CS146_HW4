public class Rainwater {
    
    public static int trap(int [] height){
        int n = height.length;
        
        // storing max height to the l&r of each index
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];
        
        // fill l&r arrays
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // calculating rainwater trapped at each index
        int waterTrapped = 0;
        for(int i = 0; i < n; i++){
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return waterTrapped;
        
    }
    
}
