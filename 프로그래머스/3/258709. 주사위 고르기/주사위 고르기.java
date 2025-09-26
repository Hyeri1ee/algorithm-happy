import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;

        List<int[]> combinations = new ArrayList<>();
        boolean[] visited = new boolean[n];

        // A가 고를 수 있는 모든 조합 생성
        generateCombinations(n, half, 0, 0, visited, combinations);

        int bestWin = -1;
        int[] bestChoice = null;

        for (int[] comb : combinations) {
            List<Integer> aDice = new ArrayList<>();
            List<Integer> bDice = new ArrayList<>();
            boolean[] used = new boolean[n];

            for (int idx : comb) {
                aDice.add(idx);
                used[idx] = true;
            }
            for (int i = 0; i < n; i++) {
                if (!used[i]) bDice.add(i);
            }

            // 각 경우의 모든 합 구하기
            List<Integer> aSums = getAllSums(aDice, dice);
            List<Integer> bSums = getAllSums(bDice, dice);

            Collections.sort(bSums);

            int win = 0;
            for (int sum : aSums) {
                // bSums 중 sum보다 작은 개수 세기
                int cnt = upperBound(bSums, sum - 1);
                win += cnt;
            }

            if (win > bestWin) {
                bestWin = win;
                bestChoice = comb;
            }
        }

        // 인덱스 +1 해서 정답 반환
        int[] answer = Arrays.stream(bestChoice).map(i -> i + 1).toArray();
        Arrays.sort(answer);
        return answer;
    }

    // 조합 생성
    private void generateCombinations(int n, int r, int start, int depth, boolean[] visited, List<int[]> result) {
        if (depth == r) {
            int[] comb = new int[r];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) comb[idx++] = i;
            }
            result.add(comb);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            generateCombinations(n, r, i + 1, depth + 1, visited, result);
            visited[i] = false;
        }
    }

    // 선택된 주사위로 만들 수 있는 모든 합 구하기
    private List<Integer> getAllSums(List<Integer> diceIdx, int[][] dice) {
        List<Integer> sums = new ArrayList<>();
        dfsDice(0, 0, diceIdx, dice, sums);
        return sums;
    }

    private void dfsDice(int depth, int sum, List<Integer> diceIdx, int[][] dice, List<Integer> sums) {
        if (depth == diceIdx.size()) {
            sums.add(sum);
            return;
        }
        int idx = diceIdx.get(depth);
        for (int val : dice[idx]) {
            dfsDice(depth + 1, sum + val, diceIdx, dice, sums);
        }
    }

    // upperBound: 정렬된 list에서 value 이하인 원소 개수
    private int upperBound(List<Integer> list, int value) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

