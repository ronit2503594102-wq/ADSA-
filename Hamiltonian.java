class Hamiltonian {
    static int n = 4;

    static int graph[][] = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };

    static int path[] = new int[n];

    static boolean Solve(int pos) {
        if (pos == n) {
            if (graph[path[n - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }

        for (int v = 1; v < n; v++) {
            if (graph[path[pos - 1]][v] == 1 && !used(v)) {
                path[pos] = v;

                if (Solve(pos + 1))
                    return true;

                path[pos] = -1;
            }
        }
        return false;
    }

    static boolean used(int v) {
        for (int i = 0; i < n; i++) {
            if (path[i] == v)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++)
            path[i] = -1;

        path[0] = 0;

        if (Solve(1)) {
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");
            System.out.println(path[0]);
        } else {
            System.out.println("No Hamiltonian Cycle");
        }
    }
}