public class Main{
    public static void main(String[] args) {
        Cat c = new Cat();
        c.mood = "高兴";
        c.sayHello();

        Dog d = new Dog();
        d.mood = "惊讶";
        d.sayHello();

        Frog f = new Frog();
        f.mood = "平静";
        f.sayHello();
    }
}