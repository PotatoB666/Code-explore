abstract class Animal{
    protected String breed;
    protected String sex;
    int age;
    public static int count = 0;
    public static final double PI = 3.14;

    Animal(){
        Animal.count ++ ;
    }
    Animal(String b,String s,int a){
        this.breed = b;
        this.sex = s;
        this.age = a;
        Animal.count ++ ;
    }
    abstract void move();
    public String toString(){
        return super.toString();
    }
    abstract String getName();
    abstract setName(String name);
    String getSex() { return this.sex ;}
    void setSex(String sex) { this.sex = sex;}
    int getAge() { return this.age ;}
    void setAge(int age) { this.age = age;}

    int add() { return 0; }
    int add(int a) { return a; }
    int add(int a,int b){ return a+b; }
    String add(String a,int b) { return a+b; }

    abstract void sayHello();

    public static void area(int r){
        double s = PI * r * r;
        System.out.println("圆的面积是:"+s);
    }
}

class Cat extends Animal{
    private int feetNum;
    Cat(){}
    Cat(String b,String s,int a){ super(b,s,a); }
    Cat(String b,String s,int a,int f){
        super(b,s,a);
        this.feetNum = f;
    }
    @Override
    void move(){
        System.out.println("猫移动了");
    }
    void clumb(){
        System.out.println("猫爬树");
    }
    @Override
    public String toString(){
        String n = super.toString()+"\n";
        String n1 = "猫的性别是:"+this.sex+",年龄是:"+this.age+",有"+this.feetNum+"只脚";
        return n+n1;
    }
    @Override
    void sayHello(){
        System.out.println("猫打招呼");
    }
}

class Bird extends Animal{
    private int wingNum;
    Bird(){ }
    Bird(String b,String s,int a){ super(b,s,a); }
    Bird(String b,String s,int a,int w){
        super(b,s,a);
        this.wingNum = w;
    }
    @Override
    void move(){
        System.out.println("鸟移动了");
    }
    @Override
    public String toString(){
        String n = super.toString()+"\n";
        String n1 = "鸟的性别是:"+this.sex+",年龄是:"+this.age+",有"+this.wingNum+"个翅膀";
        return n+n1;
    }
    @Override
    void sayHello(){
        System.out.println("鸟打招呼");
    }
}

public class XFAnimalTest{
    public static void main(String[] args) {
        //测试
        Cat c = new Cat("哺乳","雌",6,4);
        c.move();
        c.clumb();
        String cToStr = c.toString();
        int rc1 = c.add();
        int rc2 = c.add(1);
        int rc3 = c.add(1,2);
        String rc4 = c.add("1", 2);
        System.out.println("b.toString() = "+cToStr);
        System.out.println("b.add() = "+rc1);
        System.out.println("b.add(int) = "+rc2);
        System.out.println("b.add(int,int) = "+rc3);
        System.out.println("b.add(String,int) = "+rc4);
        c.sayHello();

        Bird b = new Bird("卵生","雄",4,2);
        b.move();
        String bToStr = b.toString();
        int rb1 = b.add();
        int rb2 = b.add(3);
        int rb3 = b.add(3,5);
        String rb4 = b.add("3",5);
        System.out.println("b.toString() = "+bToStr);
        System.out.println("b.add() = "+rb1);
        System.out.println("b.add(int) = "+rb2);
        System.out.println("b.add(int,int) = "+rb3);
        System.out.println("b.add(String,int) = "+rb4);
        b.sayHello();

        Cat c2 = new Cat();
        Cat c3 = new Cat();
        Bird b2 = new Bird();
        Bird b3 = new Bird();
        System.out.println("总共的对象数是:"+Animal.count);

        Animal.area(10);
    }
}