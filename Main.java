import java.util.Scanner;

public class Main {

    public static int[][] solveMaze(int[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] mark = new int[rows][cols];

        MazePath(maze, visited, 0, 0, mark);
        return mark;
    }

    private static boolean MazePath(int[][] maze, boolean[][] visited, int x, int y, int[][] mark) {
        int rows = maze.length;
        int cols = maze[0].length;

        if (x == rows - 1 && y == cols - 1) {
            mark[x][y] = 1;
            return true;
        }

        if (x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 0 && !visited[x][y]) {
            visited[x][y] = true;
            mark[x][y] = 1;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;

                    int newX = x + i;
                    int newY = y + j;

                    if (MazePath(maze, visited, newX, newY, mark)) {
                        return true;
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ابعاد مارپیچ را وارد کنید (تعداد سطر و ستون):");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] maze = new int[rows][cols];
        System.out.println("هر ردیف مارپیچ را وارد کنید (اعداد 0 یا 1، سپس اینتر بزنید):");
        for (int i = 0; i < rows; i++) {
            String[] line = scanner.next().split("");
            for (int j = 0; j < cols; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] mark = solveMaze(maze);

        System.out.println("ماتریس مسیر نهایی:");
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[0].length; j++) {
                System.out.print(mark[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
