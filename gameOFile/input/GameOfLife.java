//package gameOFile.input;

import java.io.*;

class GameOfLife {

    public static void main(String[] args) {
       boolean[][] petriDish = readFile();
       printBoard(petriDish);

    }

    public static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }

    public static boolean[][] readFile() {
        boolean [][] board = null;
        int i = 0, size;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = "";

            while((line = br.readLine()) != null) {
                if (i == 0) {
                    size = line.length();
                    board = new boolean[size][size];   
                }
                readline(board, i, line);
                i++;
            }
        

        }
        catch(IOException e) {
            // sad
        }
        return board;
    }

    private static void readline(boolean[][] board, int row, String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '*') {
                board[row][i] = true;
            }
            else {
                board[row][i] = false;
            }

        }
    }

    // public static boolean[][] playGame(boolean[][] old) {
    //     // boolean[][] noob = new boolean[old.length][old.length];
    //     // for (int row = 1; row < old.length - 1; row++) {
    //     //     for (int col = 1; col < old[row].length - 1; col++) {
    //     //         int neighbors = countNeighbors(old, row, col);
    //     //         if (old[row][col]) {
    //     //             noob[row][col] = (neighbors == 2 || neighbors == 3);
    //     //         }
    //     //         else {
    //     //             noob[row][col] = (neighbors == 3);
    //     //         }
    //     //     }
    //     // }
    //     return noob;
    // }
}