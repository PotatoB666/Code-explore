class CalcVolumn{
    static final float Pi = 3.14159f;
    static float calcCircle(float r){
        return 2 * Pi * r;
    }
    static float calcSquare(float t){
        return t * t * t;
    }
}
class MyObject{
    static int instanceCounter = 0;
    MyObject(){
        instanceCounter ++ ;
    }
}
class FinalTest{
    static final int t = 1;
    final void FinalTestFunction(){
        System.out.println("这是final方法");
    }
}
class FinalTestExtends extends FinalTest{
//    void FinalTestFunction(){
//
//    }  final测试 这个方法定义之后会报错
}
final class FinalClass{

}
//final class FinalClassChild extends FinalClass{  这里继承之后会报错
//
//}
public class Experience3 {
    public static void main(String[] args) {
        System.out.println(CalcVolumn.calcCircle(2.5f));
        System.out.println(CalcVolumn.calcSquare(2.5f));

        MyObject m = new MyObject();
        MyObject m1 = new MyObject();
        MyObject m2 = new MyObject();

        System.out.println(MyObject.instanceCounter);
        // FinalTest.t = 12;   final测试 这个语句会报错


    }
}
