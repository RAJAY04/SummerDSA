package LeetCodeContests.Weekly404;

public class MaxHeightOfATraiangle {
    public static void main(String[] args) {
        int red = 2;
        int blue = 1;
        System.out.println(maxHeightOfTriangle(red,blue));
    }
    public static int maxHeightOfTriangle(int red, int blue) {
        int i = 1;
        boolean isRed = red <= blue;

        while (true) {
            if (isRed) {
                if (red < i) {
                    break;
                }
                red -= i;
            } else {
                if (blue < i) {
                    break;
                }
                blue -= i;
            }
            isRed = !isRed;
            i++;
        }

        return i - 1;
    }

}
