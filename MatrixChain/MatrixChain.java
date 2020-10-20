import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;

//recursion version
public class MatrixChain{
    private static int[][] s = null;
    private static ArrayList<Integer> array = new ArrayList<>();
    private static int M(int a,int b){
        if(a==b)
            return 0;
        
        int minI = a;
        int minT = M(a+1,b) + array.get(a) * array.get(a+1) * array.get(b+1);
        for(int i = a+1;i < b;i++){
            
            int t = M(a,i) + M(i+1,b) + array.get(a) * array.get(i+1) * array.get(b+1);
            if(t < minT){
                minI = i;
                minT = t;
            }
        }
        s[a][b] = minI;
        return minT;
    }
    private static void print(int a,int b){
        if(a>=b)
            System.out.print("A"+(a+1));
        else{
            System.out.print("(");
            print(a,s[a][b]);
            print(s[a][b]+1,b);
            System.out.print(")");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer i;
        while((i = scanner.nextInt()) != 0){
            array.add(i);
        }
        scanner.close();
        s = new int[array.size()-1][array.size()-1];
        int m = M(0,array.size()-2);
        System.out.println(m);
        print(0,array.size()-2);
    }
}