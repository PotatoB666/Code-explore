public class Dog extends Animal{
    public void sayHello(){
        System.out.println("狗"+this.mood+"地汪汪叫了");
    }
    public void sayHello(String mood){
        System.out.println("狗"+mood+"地汪汪叫了");
    }
}