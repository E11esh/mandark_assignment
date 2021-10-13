/* // PROBLEM STATEMENT ///
An Internet Protocol address (IP address) is a numerical label assigned to each device
        connected to a computer network that uses the Internet Protocol for communication.
Classification of IPv4
CLASS From To
A 0.0.0.0 127.255.255.255
B 128.0.0.0 191.255.255.255
C 192.0.0.0 223.255.255.255
D 224.0.0.0 239.255.255.255
E 240.0.0.0 255.255.255.255

Write a program to read all IP addresses (binary format) before termination line END from
ipaddress.txt file and after converting into decimal format , print the output in following format.

Output
A = count of ip that belongs to class A
B = count of ip that belongs to class B
C = count of ip that belongs to class C
D = count of ip that belongs to class D
E = count of ip that belongs to class E

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class fourIPV4NetworkClassification {
    public static void main(String[] args) throws IOException {
        int A =0;
        int B =0;
        int C =0;
        int D =0;
        int E =0;
        try (BufferedReader br = new BufferedReader(new FileReader("ipaddress.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                System.out.println(line);
                if( line.equals("END") )
                     break;
                if( line.compareTo("11110000.00000000.00000000.00000000") >= 0 ){
                    System.out.println("11110000.00000000.00000000.00000000"+" E");
                    E++; continue;};
                if( line.compareTo("11100000.00000000.00000000.00000000") >= 0 ){
                    System.out.println("11100000.00000000.00000000.00000000"+" D");
                    D++; continue;};
                if( line.compareTo("11000000.00000000.00000000.00000000") >= 0 ){
                    System.out.println("11000000.00000000.00000000.00000000"+" C");
                    C++; continue;};
                if( line.compareTo("1000000.00000000.00000000.00000000") >= 0 ){
                    System.out.println("10000000.00000000.00000000.00000000"+" B");
                    B++; continue;};
                if( line.compareTo("0000000.00000000.00000000.00000000") >= 0 ){
                    System.out.println("00000000.00000000.00000000.00000000"+" A");
                    A++; continue;};
            }

            System.out.println("A = "+A );
            System.out.println("B = "+ B);
            System.out.println("C = "+ C);
            System.out.println("D = "+ D);
            System.out.println("E = "+ E);
        }
    }
}
