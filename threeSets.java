/* PROBLEM STATEMENT
Accept two positive integers start and end as input. Construct the following sets:
1. A is the set of positive integers from start to end (endpoints inclusive) divisible by 3.
2. B is the set of positive integers from start to end (endpoints inclusive) divisible by 5.
Find the set of all integers that are:
● divisible by 3 or 5, and store it in the variable o1
● divisible by both 3 and 5, and store it in the variable o2
● divisible by 3 but not divisible by 5, and store it in the variable o3
● divisible by 5 but not divisible by 3, and store it in the variable o4
Note that each bullet corresponds to a separate set. You have to accept start and end as input
and create these four sets. You do not have to print the output to the console.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import  java.util.SortedSet;
import java.util.TreeSet;

public class threeSets {
    public static void main(String[] args) throws IOException{
        SortedSet setA = new TreeSet();
        SortedSet setB = new TreeSet();
        SortedSet o1 = new TreeSet();
        SortedSet o2= new TreeSet();
        SortedSet o3 = new TreeSet();
        SortedSet o4 = new TreeSet();
        //Creation of File Reader object
        FileReader fr = new FileReader("nums.txt");
        //Creation of BufferedReader object
        BufferedReader br = new BufferedReader(fr);
        int start = 0;
        int end  = 0;
        int c = br.read(); 
        boolean curstart = true; 
       while( c != -1){
           System.out.println(""+(char)c);

           if((char) c == ','){
               curstart = false;  c = br.read(); continue;}
           if(curstart)
               start = (c -'0')+ 10 * start;
           else
               end = (c-'0')+ 10 * end;

           c = br.read();
       }
        
        System.out.println(start+" , "+end);
        // Find Set A(div by 3) and Set B(dib by 5)
        for(int i = start ; i<= end ;i++){
            if(i%3 == 0)
                setA.add(i);
            if(i%5 ==0)
                setB.add(i);
        }

       // Find o1- div by 3 or 5
        for(int i = start ; i<= end ;i++)
               if(i%3 ==0 || i%5 == 0)
                   o1.add(i);

        // Find o1- div by 3 and 5
        for(int i = start ; i< end ;i++)
            if(i%3 ==0 && i%5 == 0)
                o2.add(i);

        // Find o1- div by 3 alone, not by 5
        for(int i = start ; i< end ;i++)
            if(i%3 ==0 || i%5 != 0)
                o3.add(i);


        // Find o4- div by 5 alone, not by 3
        for(int i = start ; i< end ;i++)
            if(i%3 != 0 || i%5 == 0)
                o4.add(i);


        // Find o1- div by 3 or 5
        System.out.print(o1);
        System.out.println();
        System.out.print(o2);
        System.out.println();
        System.out.print(o3);
        System.out.println();
        System.out.print(o4);
        System.out.println();
    }
}
