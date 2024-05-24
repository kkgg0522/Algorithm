import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 컴퓨터의 수
        int n = scanner.nextInt();
        // 연결된 컴퓨터 쌍의 수
        int m = scanner.nextInt();

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결 정보 입력 받기
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 바이러스에 감염된 컴퓨터 수를 세는 함수 호출
        int infectedCount = countInfectedComputers(graph, n);
        System.out.println(infectedCount);

        scanner.close();
    }

    private static int countInfectedComputers(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1]; // 방문 여부 확인
        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // 1번 컴퓨터를 제외한 감염된 컴퓨터 수

        // 1번 컴퓨터부터 시작
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 컴퓨터와 연결된 컴퓨터들을 탐색
            for (int connected : graph.get(current)) {
                if (!visited[connected]) {
                    visited[connected] = true;
                    queue.add(connected);
                    count++; // 감염된 컴퓨터 수 증가
                }
            }
        }

        return count;
    }
}
