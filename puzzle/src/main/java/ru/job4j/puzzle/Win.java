package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        if (diagonal1(board) || diagonal2(board)) {
            return true;
        }
        int[] temp = extractDiagonal(board);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1 && (monoVertical(board, i) || monoHorizontal(board, i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean rsl = true;
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean monoVertical(int[][] board, int column) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean diagonal1(int[][] board) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean diagonal2(int[][] board) {
        boolean rsl = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - 1 - i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int i = 0; i < rsl.length; i++) {
            rsl[i] = board[i][i];
        }
        return rsl;
    }
}
