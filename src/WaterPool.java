public class WaterPool {
    public static int waterStorage(int[] height){
        if(height == null || height.length<=1)
            return 0;
        int storage = 0;
        int[] leftWaterLevel = new int[height.length];
        int[] rightWaterLevel = new int[height.length];
        leftWaterLevel[0] = height[0];
        rightWaterLevel[height.length - 1] = height[height.length-1];
        for(int i=1; i<height.length; i++){
            leftWaterLevel[i] = Integer.max(height[i], leftWaterLevel[i-1]);
        }

        for(int i=height.length-2; i>=0; i--){
            rightWaterLevel[i] = Integer.max(height[i], rightWaterLevel[i+1]);
        }

        for(int i=0; i<height.length-1; i++){
            int curStor = Integer.min(leftWaterLevel[i], rightWaterLevel[i]) - height[i];
            storage += curStor>0?curStor:0;
        }
        return storage;
    }

    public static void main(String[] args){
        System.out.println(waterStorage(new int[] {5,2,3,2,4}));
    }
}
