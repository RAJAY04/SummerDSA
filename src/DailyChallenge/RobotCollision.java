package DailyChallenge;

import java.util.*;

public class RobotCollision {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RRLL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] index = new int[n][2];
        for (int i = 0; i < n; i++) {
            index[i][0] = positions[i];
            index[i][1] = i;
        }

        Arrays.sort(index, (a, b) -> a[0] - b[0]);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int idx = index[i][1];
            if (directions.charAt(idx) == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty() && healths[idx] > 0) {//while condition is very necessary
                    if (healths[idx] > healths[stack.peek()]) {
                        healths[stack.peek()] = 0;
                        stack.pop();
                        healths[idx]--;//if a L is there it never goes into the stack, it should either distroy
                        // itself or elements inside ths stack to proceed to next index
                    } else if (healths[idx] < healths[stack.peek()]) {
                        healths[idx] = 0;
                        healths[stack.peek()]--;
                    } else {
                        healths[idx] = 0;
                        healths[stack.pop()] = 0;
                    }
                }

            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : healths) {
            if (num > 0)
                res.add(num);
        }
        return res;
    }
}
