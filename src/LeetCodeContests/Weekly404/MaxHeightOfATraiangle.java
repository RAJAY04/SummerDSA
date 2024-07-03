package LeetCodeContests.Weekly404;

public class MaxHeightOfATraiangle {
    public static void main(String[] args) {
        int red = 9;
        int blue = 5;
        System.out.println(maxHeightOfTriangle(red,blue));
    }
    public static int maxHeightOfTriangle(int red, int blue) {
        return Math.max(helper(red,blue,true),helper(red,blue,false)) - 1;
    }
    public static int helper(int red, int blue,boolean useRed) {
        int row = 1;
        while(red > 0 || blue > 0){ //dont put && condition , else use while true until loop breaks explicitly
            if(useRed){
                if(red >= row){
                    red -= row;
                    useRed = false;
                }else break;
            }else{
                if(blue >= row){
                    blue -= row;
                    useRed = true;
                }else break;

            }
            row++;
        }
        return row;
    }

}
