import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;
        int answer = 0;

        // 1보다 낮은 두 수를 곱하면 항상 최댓값
        for (; lt < rt; lt += 2) {
            if (arr[lt] < 1 && arr[lt + 1] < 1) {
                answer += (arr[lt] * arr[lt + 1]);
            } else {
                break;
            }
        }

        // 1보다 큰 두수를 곱하면 항상 최댓값
        for (; rt > 0; rt -= 2) {
            if (arr[rt] > 1 && arr[rt - 1] > 1) {
                answer += (arr[rt] * arr[rt - 1]);
            } else {
                break;
            }
        }

        // 남은 수를 더해줌
        for (; rt >= lt; rt--) {
            answer += arr[rt];
        }

        System.out.println(answer);
    }
}