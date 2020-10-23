public class Frog extends Animal implements LandAnimal,WaterAnimal{
    public void sayHello(){
        System.out.println("青蛙"+this.mood+"地呱呱叫");
    }
    public void sayHello(String mood){
        System.out.println("青蛙"+mood+"地呱呱叫");
    }
    public void walk(){
        System.out.println("青蛙在地上爬");
    }
    public void swim(){
        System.out.println("青蛙在水中游");
    }
}