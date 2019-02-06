import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LargestAreaInMatrixRecursion {

    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < matrix.length; i++) {
            String[] strI = in.readLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(strI[j]);
            }
        }

        int current;
        int max = 0;

        for (int rows = 0; rows < matrix.length;rows++){
            for(int cols = 0; cols < matrix[rows].length;cols++){

                if (!visited[rows][cols]){
                    current = dfs(matrix,rows,cols,matrix[rows][cols]);
                    if(current > max){
                        max = current;
                    }

                }
            }
        }
        System.out.println(max);
    }
    static int dfs(int[][] matrix,int x, int y, int value){

        if(visited[x][y]){
            return 0;
        } else {
            visited[x][y] = true;
            int best = 0;

            for(int i = 0; i < 4;i++){

                int modX = dx[i] + x;
                int modY = dy[i] + y;
                if( modX == -1 || modX >= matrix.length || modY == -1 || modY >=
                        matrix[0].length){
                    continue;
                }
                if(matrix[modX][modY] == value){
                    int v = dfs(matrix,modX,modY,value);
                    best += v;
                }
            }
            return best + 1;
        }
    }
}