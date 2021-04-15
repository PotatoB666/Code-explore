class Animal{
    String name;
    int weigth;
    void run(){
        System.out.println("跑");
    }
    void jump() {
        System.out.println("跳");
    }
    void walk(){
        System.out.println("走");
    }
}
class Rectangle{
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int length;
    private int width;
    int calcArea(){
        return length * width;
    }
    int calcRound() {
        return 2 * (width + length);
    }
}
class MyDate{
    int year;
    int month;
    int day;
    MyDate(int y,int m,int d){
        year = y;
        month = m;
        day = d;
    }
    @Override
    public String toString(){
        return year+"年"+month+"月"+day+"日";
    }
}
class Employee{
    String name;
    float cash;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public MyDate getEmployTime() {
        return employTime;
    }

    public void setEmployTime(MyDate employTime) {
        this.employTime = employTime;
    }

    public String getStatus(){
        return "姓名:"+name+" 工资:"+cash+" 受雇时间:"+employTime.toString();
    }

    MyDate employTime;
}

public class Experience1 {
    public static void main(String[] args) {
        Animal dog = new Animal();
        dog.name = "旺财";
        dog.weigth = 10;
        dog.jump();
        dog.run();
        dog.walk();

        Rectangle r = new Rectangle();
        r.setLength(10);
        r.setWidth(5);
        System.out.println(r.calcArea());
        System.out.println(r.calcRound());

        Employee ee = new Employee();
        MyDate md = new MyDate(1,4,2);
        ee.setName("张三");
        ee.setCash(10000);
        ee.setEmployTime(md);
    }
}
