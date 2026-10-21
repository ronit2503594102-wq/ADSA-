class NQueen {
    static int N = 4;
    static int board[] = new int[N + 1];

    static boolean safe(int row, int col) {
        for (int i = 1; i < row; i++) {
            if (board[i] == col ||
                Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }

    static void solve(int row) {
        if (row > N) {
            for (int i = 1; i <= N; i++)
                System.out.print(board[i] + " ");
            System.out.println();
            return;
        }

        for (int col = 1; col <= N; col++) {
            if (safe(row, col)) {
                board[row] = col;
                solve(row + 1);
                board[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        solve(1);
    }
}