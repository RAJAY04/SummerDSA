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
        List<Integer> ind = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            ind.add(i);
        }
        ind.sort((a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : ind) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
            } else {

                while (!stack.isEmpty() && healths[i] > 0) {
                    int topIndex = stack.peek();

                    if (healths[i] < healths[topIndex]) {
                        healths[topIndex]--;
                        healths[i] = 0;
                    } else if (healths[i] > healths[topIndex]) {
                        healths[i]--;
                        healths[stack.pop()] = 0;
                    } else {

                        healths[stack.pop()] = 0;
                        healths[i] = 0;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) {
                ans.add(h);
            }
        }

        return ans;
    }
}
