package GFGcontests;

public class BobsImpression {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1,2,2};
        System.out.println(classArrangement(n,arr));
    }
    public static boolean classArrangement(int n, int[] arr) {
        int first = -1, second = -1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                if (first == -1) {
                    first = i;
                } else {
                    second = i + 1;
                }
            }
        }

        if (first == -1) {
            return false;
        }

        if (second == -1) {
            second = first + 1;
        }

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
