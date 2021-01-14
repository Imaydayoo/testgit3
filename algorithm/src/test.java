import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class test {


        public static  boolean exist(char[][] board, String word) {
            int l1 = board.length;
            int l2 = board[0].length;
            //boolean [][]visited = new boolean [l1][l2];

            int maxS = 0;

            for(int i = 0; i < l1; i++)
            {
                for(int j = 0; j < l2; j++)
                {
                    boolean [][]visited = new boolean [l1][l2];
                    int temp = dfs(visited, board, word, i, j, 0);
                    if(temp ==  word.length()-1)//剪枝可以
                        return true;
                }
            }
            return false;
        }

        public static int dfs(boolean[][] visited, char [][] board, String word, int begini, int beginj , int sj)
        {

            int l1 = board.length;
            int l2 = board[0].length;
            int w = 0, a = 0, s = 0, d = 0;
            if(sj == word.length())
                return sj - 1;
            if(begini == 3)
                System.out.println("begini = " );

            if(begini < l1 && beginj < l2 && board[begini][beginj] == word.charAt(sj))
            {
                visited[begini][beginj] = true;
                if(sj == word.length()-1)
                    return sj;

                if(beginj - 1 >= 0 && !visited[begini][beginj - 1])
                {
                    w = dfs(visited, board, word, begini, beginj-1, sj+1);
                }
                if(beginj + 1 < l2 && !visited[begini][beginj + 1])
                {
                    s = dfs(visited, board, word, begini, beginj+1, sj+1);
                }
                if(begini - 1 >= 0 && !visited[begini - 1][beginj])
                {
                    a = dfs(visited, board, word, begini-1, beginj, sj+1);
                }
                if(begini + 1 < l1  && !visited[begini + 1][beginj])
                {
                    d = dfs(visited, board, word, begini+1, beginj, sj+1);
                }
                int maxall = w;
                maxall = Math.max(maxall, s);
                maxall = Math.max(maxall, a);
                maxall = Math.max(maxall, d);
                visited[begini][beginj] = false;
                return maxall;
            }
            else
            {
                return sj - 1;
            }
        }


    public static void main(String[] args) {


       char [][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
       String s = "ABCESEEEFS";
       if(exist(board, s) )
           System.out.println("YES");
       else
           System.out.println("NO");





    }
    }


