package task1;

/**
 * Created by Dina_Abdykasheva on 4/3/2017.
 */
public class MultipleMatrix {
    public static void main(String[] args)
    {
        int[][] matrixA = {
                {1, 17, 5},
                {26, -7, 44},
                {4, 5, 6}
        };
        int[][] matrixB = {
                {4, 26, 33},
                {-7, 19, 44},
                {6, 9, 11}
        };
        int m = matrixA.length;
        int n = matrixB[0].length;
        int p = matrixB.length;
        int[][] resMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < p; k++)
                {
                    resMatrix[i][j] += matrixA[i][k]*matrixB[k][j];
                }
            }
        }

        for (int i = 0; i < resMatrix.length; i++)
        {
            for (int j = 0; j < resMatrix[0].length; j++)
            {
                System.out.print(resMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
