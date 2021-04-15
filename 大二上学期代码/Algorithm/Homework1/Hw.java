public class Hw {
    private static int sum = 0;
    private static void T(int n){
        if(n==1){
            sum++;
            return;
        }

        for(int i = 2;i<=n;i++){
            if(n%i==0){
                T(n/i);
            }
        }
    }
    public static void main(String[] args) {
        Hw.T(12);
        System.out.println(Hw.sum);
    }   
}
