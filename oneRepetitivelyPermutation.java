import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class oneRepetitivelyPermutation {

        static void permutation(char[] input, int size , int N){

        if(size == 1) {
            for(int i =0; i< N; i++)
                System.out.print(input[i]);
            System.out.print("\n");
        }

        for(int i =0; i <= size-1;i++){
            permutation(input, size-1, N);

            char t;
            // if odd size wap first and last in arr of length size
            if(size%2 == 1){
                t = input[0];
            input[0] = input[size-1];
            input[size-1] = t;
            }
            // if even size swap current with last element in arr of length size
            else{
                t = input[i];
                input[i] = input[size-1];
                input[size-1] = t;
            }


    }
        }


    public static void main(String[] args) throws IOException {

                System.out.print("Input ( String of length three, ex:abc)");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String data = reader.readLine();
                reader.close();
            //System.out.println(input);
            int N = 3;
            char[] input = new char[3];
            for(int i =0; i< N; i++)
                input[i] =  (char)data.charAt(i);
            // one char repeated thrice
             for(int i =0 ; i< N; i++) {
                 for (int j = 0; j < N; j++)
                     System.out.print( input[i]);
                 System.out.print( "  \n" );
             }


        // one char repeated twice
        System.out.println( input[0]+""+input[1]+""+input[1] );
        System.out.println( input[0]+""+input[2]+""+input[2] );

        System.out.println( input[1]+""+input[0]+""+input[0] );
        System.out.println( input[1]+""+input[2]+""+input[2] );

        System.out.println( input[2]+""+input[0]+""+input[0] );
        System.out.println( input[2]+""+input[1]+""+input[1] );

        // No repetition
        permutation(input,
                N,
                N);
    }
}
