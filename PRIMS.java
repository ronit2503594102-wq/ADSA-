import java.util.*;

class Prim {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];

        visited[0] = true;

        System.out.println("Edge  Weight");

        for (int k = 0; k < n - 1; k++) {

            int min = Integer.MAX_VALUE;
            int x = -1, y = -1;

            for (int i = 0; i < n; i++) {

                if (visited[i]) {

                    for (int j = 0; j < n; j++) {

                        if (!visited[j] &&
                            graph[i][j] != 0 &&
                            graph[i][j] < min) {

                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + "    " + min);

            visited[y] = true;
        }

        sc.close();
    }
}
