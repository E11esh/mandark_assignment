
/*  /// PROBLEM STATEMENT////
 * This problem is about reversing a square matrix along row or column:
 * Matrix Reverse along row Reverse along column
 * 1,2             3,4                 2,1
 * 3,4             1,2                 4,3
 * The first line of the input will be an integer n, which denotes the dimension of the square matrix.
 * Each of the next n lines in the input will have a sequence of n comma-separated integers, you
 * can assume that there will not be any space after comma. The last line in the input will be one of
 * these two words: row or column. If it is “row”, then reverse the matrix along the row, else,
 * reverse it along the column.
 * Print the reversed matrix as output: each line should contain one row of the matrix as a
 * sequence of comma-separated integers.
 * Test Case:
 * 1. Input Expected Output
 * 2 3,4
 * 1,2 1,2
 * 3,4
 * row
 * 2. Input Expected Output
 * 2 2,1
 * 1,2 4,3
 * 3,4
 * column
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class twoReverseaMtrix {
    public static void main(String[] args) throws IOException {
        //Creation of File Reader object
        FileReader fr = new FileReader("matrix_input.txt");
        //Creation of BufferedReader object
        BufferedReader br = new BufferedReader(fr);

        int c = 0 ;
        int T = ( br.read() - '0' );
        for(int t = 1; t <= T ; t++){
            // System.out.println("Test case  : "+t);
            // Below to N after skipping spaces
            int buf = ( c = br.read());
            while( buf == 10 || buf == 13){
                buf = br.read();
            };
            int N = buf - '0';
            // System.out.println("Matrix Size : "+N+"x"+N);
            int matrix[][] = new int[N][N];
            int i = 0;
            int j = 0;
            //// Buffer for reversal request- row / column( Default )
            boolean along_row = false;

            //////     Read File char by Char  /////
            while ((c = br.read()) != -1) {

                //Converting integer to char
                char character = (char) c;
                //System.out.println(c + " = " + character);

                // Unicode   44(','), 13 and 10 were being not considered for updating matrix
                // Because these values are not of matrix
                if (i < N && j < N && (c != 10 && c != 13 && c != 44)) {
                    matrix[i][j++] = c - '0';
                    //System.out.println("Read  =" + character);

                    // If end of row occurred, go to beginning of next row
                    if (j == N) {
                        j = 0;
                        i++;
                    }
                }

                // Find reversal request- row / column( Default )
                if (character == 'r' || character == 'R' ) {
                    along_row = true;
                    break;
                }
                if (character == 'c' || character == 'C' ) {
                    along_row = false;
                    break;
                }

            }

            // Along row reverse
            if(along_row) {
                System.out.println("Expected Output - Row reverse ");
                for (i = 0; i < N; i++) {
                    for (j = 0; j < N; j++) {
                        int a = N - 1 - i;
                        int b = N - 1 - j;
                        System.out.print(matrix[a][b]);

                        // comma to separates elements with in a row
                        if (j >= 0 && j < N - 1)
                            System.out.print(",");
                    }

                    // New line separates rows
                    System.out.print("\n");
                }
                // Reads next o and w of row
                c = br.read();
                // System.out.println("Ends with "+(char)c);
                c = br.read();
                //System.out.println("Ends with "+(char)c);
                c = br.read();
                // System.out.println("Ends with "+(char)c);

            } else {  // Along Column Reverse
                System.out.println("Expected Output - Column reverse");
                for (i = 0; i < N; i++) {
                    for (j = 0; j < N; j++) {

                        // Index update for reversal along column
                        int a = i;
                        int b = N - 1 - j;
                        System.out.print(matrix[a][b] + "");

                        // comma to separates elements with in a row
                        if (j >= 0 && j < N - 1)
                            System.out.print(",");
                    }

                    // New line separates rows
                    System.out.print("\n");

                }
                // Reads next o, l, u, m ans n of column
                c = br.read();
                // System.out.println("Ends with "+(char)c);
                c = br.read();
                //System.out.println("Ends with "+(char)c);
                c = br.read();
                // System.out.println("Ends with "+(char)c);
                c = br.read();
                //System.out.println("Ends with "+(char)c);
                c = br.read();
                //System.out.println("Ends with "+(char)c);
            }
        }
    }

}

