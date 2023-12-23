import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int group;
    static int cnt;
    static ArrayList<Integer> countList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        group = 0;
        cnt = 0;
        countList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    countList.add(cnt);
                    group++;
                    cnt = 0;
                }
            }
        }

        System.out.println(group);
        Collections.sort(countList);
        for (int i = 0; i < countList.size(); i++) {
            System.out.println(countList.get(i));
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;

        int[] px = {-1, 0, 0, 1};
        int[] py = {0, -1, 1, 0};

        for (int i = 0; i < 4; i++) {
            int dx = x + px[i];
            int dy = y + py[i];
            if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
                continue;
            }

            if (!visited[dx][dy] && arr[dx][dy] == 1) {
                visited[dx][dy] = true;
                dfs(dx, dy);
            }
        }
    }
}
