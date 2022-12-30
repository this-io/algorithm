package implementation.medium;

import java.util.Stack;

public class BombEnemy {
    public static void main(String[] args) {
        BombEnemy b = new BombEnemy();
        char[][] ip = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(b.maxKilledEnemies(ip));
        char[][] ip1 = {{'W','W','W'},{'0','0','0'},{'E','E','E'}};
        System.out.println(b.maxKilledEnemies(ip1));
        char[][] ip2 = {{'0'},{'0'},{'0'}};
        System.out.println(b.maxKilledEnemies(ip2));
        char[][] ip3 = {{'0','E','E','E','E','E','E','E','E','E','E','W'}};
        System.out.println(b.maxKilledEnemies(ip3));


    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int ROW = grid.length;
        int COL = grid[0].length;
        int maxEnemies = 0;
        Stack<Pair> theStack = new Stack<>();
        theStack.push(new Pair(0, 0));
        boolean[][] visited = new boolean[ROW][COL];

        while (!theStack.isEmpty()) {
            int killedEnemiesFromCurrentPosition = 0;
            Pair curr = theStack.pop();

            //This is a valid position in grid
            if (!isValidCell(visited, curr.row, curr.col, ROW, COL)) {
                continue;
            }

            visited[curr.row][curr.col] = true;
            System.out.println(curr.row+","+curr.col + " : "+ grid[curr.row][curr.col]);

            theStack.push(new Pair(curr.row, curr.col + 1));
            theStack.push(new Pair(curr.row, curr.col - 1));
            theStack.push(new Pair(curr.row + 1, curr.col));
            theStack.push(new Pair(curr.row - 1, curr.col));

            //This position in not occupied.
            if (grid[curr.row][curr.col] == 'E' || grid[curr.row][curr.col] == 'W') {
                continue;
            }

            int currColLeft = curr.col;
            int currColRight = curr.col+1;
            boolean currColLeftWallDetected = false;
            boolean currColRightWallDetected = false;
            //Go through row
            for(int i=0; i<COL; i++) {
                if(currColLeft >= 0 && !currColLeftWallDetected) {
                    if(grid[curr.row][currColLeft] == 'E') {
                        killedEnemiesFromCurrentPosition++;
                    }
                    if(grid[curr.row][currColLeft] == 'W') {
                        currColLeftWallDetected = true;
                    }
                }
                currColLeft--;

                if(currColRight < COL && !currColRightWallDetected) {
                    if(grid[curr.row][currColRight] == 'E') {
                        killedEnemiesFromCurrentPosition++;
                    }
                    if(grid[curr.row][currColRight] == 'W') {
                        currColRightWallDetected = true;
                    }
                }
                currColRight++;
            }

            int currRowUp = curr.row;
            int currRowBottom = curr.row+1;
            boolean currUpWallDetected = false;
            boolean currDownWallDetected = false;
            for(int i=0; i<ROW; i++) {
                if(currRowUp >= 0 && !currUpWallDetected) {
                    if(grid[currRowUp][curr.col] == 'E') {
                        killedEnemiesFromCurrentPosition++;
                    }
                    if(grid[currRowUp][curr.col] == 'W') {
                        currUpWallDetected = true;
                    }
                }
                currRowUp--;
                //System.out.println(currRowBottom);
                if(currRowBottom < ROW && !currDownWallDetected) {
                    if(grid[currRowBottom][curr.col] == 'E') {
                        killedEnemiesFromCurrentPosition++;
                    }
                    if(grid[currRowBottom][curr.col] == 'W') {
                        currDownWallDetected = true;
                    }
                }
                currRowBottom++;
            }

            maxEnemies = Math.max(killedEnemiesFromCurrentPosition, maxEnemies);
        }

        return maxEnemies;
    }

    private boolean isValidCell(boolean[][] visited, int row, int col, int rowLen, int colLen) {
        if (row < 0 || col < 0 || row >= rowLen || col >= colLen) {
            return false;
        }
        if(visited[row][col]) {
            return false;
        }
        return true;
    }

    class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
