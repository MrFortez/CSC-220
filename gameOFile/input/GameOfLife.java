//package gameOFile.input;

import java.io.*;

class GameOfLife {

    public static void main(String[] args) {
        boolean[][] petriDish = readFile();

        printBoard(petriDish, 0);

        for (int gen = 1; gen < 20; gen++) {
            petriDish = playGame(petriDish);
            
            printBoard(petriDish, gen);

            mySleep(1000);
        }
    }


    public static void mySleep(int duration) {
        try {
            Thread.sleep(duration);
        } 
        catch(Exception e) {

        }
    }

    

    public static void printBoard(boolean[][] board, int gen) {
        System.out.println("\033[h\033[2J");
        System.out.flush();
        System.out.println("Generation: " + gen);
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++) {
                System.out.print((board[row][col] ? "*" : " "));
                // System.out.print(col + ", ");
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

    public static boolean[][] playGame(boolean[][] old) {
        boolean[][] noob = new boolean[old.length][old.length];
        for (int row = 1; row < old.length - 1; row++) {
            for (int col = 1; col < old[row].length - 1; col++) {
                int neighbors = countNeighboors(old, row, col);
                if (old[row][col]) {
                    noob[row][col] = (neighbors == 2 || neighbors == 3);
                }
                else {
                    noob[row][col] = (neighbors == 3);
                }
            }
        }
        return noob;
    }

    // A function to count the number of neighboors around a specific 
    // row and column in the 2D array og 
    public static int countNeighboors(boolean[][] og, int row, int col) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (og[row + i][col + j] && !((i == 0) && (j == 0))) {
                    count++;
                }
            }
        }
        return count;
    }
}