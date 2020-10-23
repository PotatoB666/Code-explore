public class Cat extends Animal implements LandAnimal{
    public void sayHello(){
        System.out.println("猫"+this.mood+"地喵喵叫了");
    }
    public void walk(){
        System.out.println("猫在地上走路");
    }
}