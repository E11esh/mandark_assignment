///// PROBLEM STATEMENT ///
/*
The below image represents a grid having 11x11 nodes numbered from 0 to 10.
● Distance between one node to the next connected node is 1 unit.
● One can go in any direction, each letter counts as 1 unit in each direction.
● N North
● S South
● E East
● W West

The below graph shows the path of “NNNNEEENE” starting from (0,0)
(i, j) can go in all four direction provided i+1 < N , j+1< N or  ( i+1 < N and  j+1< N )
Write a program to take a string as input from the user and print the total distance travelled.

Test Case:
1. Input Expected Output
NNNNEEENE 9
2. Input Expected Output
NEWS 4
*/

import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class fiveDistance {
    public static void main(String[] args) throws IOException{

        int N = 11;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        System.out.println(data);
        int x = 0;
        int y = 0;
        int index = 0;
        int distance = 0;
        while( x < N && y < N && index < data.length()){
            // One can not go beyond y = N-1 along North
            if(data.charAt(index) == 'N' && y < 10){       y++; distance++;}
            // One can not go beyond x = N-1 along North
            else if(data.charAt(index) == 'E' && x < 10) { x++;  distance++;}
            // One can not go beyond x = 0 along West
            else if(data.charAt(index) == 'W' && x > 0) { x--; distance++;}
            // One can not go beyond y = 0 along South
            else if(data.charAt(index) == 'S' && y > 0) { y--;  distance++;}

            index++;
        }
        System.out.println(""+distance);
    }
}
