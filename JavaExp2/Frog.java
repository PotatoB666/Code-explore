public class Frog extends Animal{
    public void sayHello(){
        System.out.println("青蛙"+this.mood+"地呱呱叫");
    }
    public void sayHello(String mood){
        System.out.println("青蛙"+mood+"地呱呱叫");
    }
}