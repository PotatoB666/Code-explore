public class Person implements SmartBeing{
    public void setBeingName(String beingName) {
        this.beingName = beingName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private String beingName = "无名氏";//地球人的名字
    private char sex = '男';
    private int hp = 100;

    //构造方法
    public Person() { }
    public Person(String name,char sex,int hp){
        this.beingName = name;
        this.sex = sex;
        this.hp = hp;
    }
    @Override
    public void talk() {
        System.out.println(beingName+"正在交谈地球语言");
    }

    @Override
    public void walk() {
        System.out.println(beingName+"作为地球人在走路");
    }

    @Override
    public String getBeingName(){
        return this.beingName;
    }

    @Override
    public String toString(){
        return "地球人:"+beingName+"，性别:"+sex+"，体力值:"+hp;
    }
}
