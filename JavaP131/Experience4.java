interface Eatable{
    void howToEat();
}
/*第一组******************************************/
class Animal1{
    @Override
    public String toString(){
        return "Animal1";
    }
}
class Tiger extends Animal1{
    @Override
    public String toString(){
        return "Tiger";
    }
}
class Chicken extends Animal1 implements Eatable{

    @Override
    public void howToEat() {
        System.out.println("炖着吃");
    }
    @Override
    public String toString(){
        return "Chicken";
    }
}
class Pig extends Animal1{
    @Override
    public String toString(){
        return "Pig";
    }
}
/************************************************/
/*第二组******************************************/
abstract class Fruit implements Eatable{
    @Override
    public String toString(){
        return "Fruit";
    }
}
class Apple extends Fruit{

    @Override
    public void howToEat() {
        System.out.println("直接吃");
    }
    @Override
    public String toString(){
        return "Apple";
    }
}
class Orange extends Fruit{

    @Override
    public void howToEat() {
        System.out.println("榨汁吃");
    }
    @Override
    public String toString(){
        return "Orange";
    }
}
/************************************************/

public class Experience4 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Chicken chicken = new Chicken();
        Apple apple = new Apple();
        Orange orange = new Orange();

        showObject(tiger);
        showObject(chicken);
        showObject(apple);
        showObject(orange);
    }
    public static void showObject(Object object){
        System.out.println(object);
        if(object instanceof Eatable){
            ((Eatable) object).howToEat();
        }
    }
}
