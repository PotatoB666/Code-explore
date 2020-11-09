//接口
//陆生动物
interface LandAnimal{
	int getNumberOfLegs();
}
//水生动物
interface WaterAnimal{
	void getGillFlag();
	void getLaysEggs();
}

//父类
abstract class Animal{
	//属性
	String name;//动物的名字
	boolean mammal;//是否是哺乳动物
	boolean canivorious;//是否是肉食动物
	int mood;
	//初始化块
	{
		this.mammal = false;
		this.canivorious = false;
		this.mood = 1;
	}
	
	//构造方法（两个）
	Animal(){
		this.mood = 1;
	}
	Animal(boolean mammal,boolean canivorious,int mood){
		this.mammal = mammal;
		this.canivorious = canivorious;
		this.mood = mood;
	}
	
	boolean isMammal( ){
		return mammal;
	}
	boolean isCarnivorous( ){
		return canivorious;
	}
	
	//以下方法构成重载
	// 一般情况下打招呼的方法
	abstract void sayHello();
	//情绪打招呼的方法
	abstract void sayHello(int moodval);
	
	void setMood(int value){
		this.mood = value;
	}
	
	int getMood(){
		return this.mood ;
	}
	
	//打印方法（可选）
	abstract void printInfo();
}

//子类:动物
class Dog extends Animal implements LandAnimal{
	//构造方法（两个）
	Dog(){
		this.mammal = true;
		this.canivorious = true;
		this.mood = 1;
	}
	Dog(int mood){
		this.mood = mood;
		this.mammal = true;
		this.canivorious = true;
	}
	//重写父类的打招呼的方法
	@Override
	void sayHello(){
		System.out.println("狗在通常情况下，和人打招呼的方式为：摇尾巴");
	}
	@Override
	void sayHello(int moodval){
		if(moodval==1)//开心
			System.out.println("狗狗在情绪好的情况下，打招呼的方式为：汪汪叫");
		else if(moodval==2)
			System.out.println("狗在烦躁的时候，会：呜呜叫");
	}
	@Override
	void printInfo(){
		System.out.println("狗是哺乳动物");
		System.out.println("狗是肉食动物");
	}
	@Override
	public int getNumberOfLegs() {
		return 4;
	}
}
//子类：猫
class Cat extends Animal implements LandAnimal{
	//构造方法（两个）
	Cat(){
		this.mammal = true;
		this.canivorious = true;
		this.mood = 1;
	}
	Cat(int mood){
		this.mood = mood;
		this.mammal = true;
		this.canivorious = true;
	}
	//重写父类的打招呼的方法
	@Override
	void sayHello(){
		System.out.println("猫通常情况下，和人打招呼的方式为：喵喵叫");
	}
	@Override
	void sayHello(int moodval){
		if(this.mood == 1)//开心
			System.out.println("猫被抚摸情绪好的情况下，打招呼的方式为：咕噜咕噜叫");
		else if(this.mood == 2)
			System.out.println("猫烦躁的时候，会：嘶嘶叫");
	}
	@Override
	void printInfo(){
		System.out.println("猫是哺乳动物");
		System.out.println("猫是肉食动物");
	}
	@Override
	public int getNumberOfLegs() {
		return 4;
	}
}
//子类：青蛙
class Frog extends Animal implements WaterAnimal,LandAnimal{
	//构造方法（两个）
	Frog(){
		this.mammal = false;
		this.canivorious = false;
	}
	Frog(int mood){
		this.mammal = false;
		this.canivorious = false;
		this.mood = mood;
	}
	//重写父类的打招呼的方法
	@Override
	void sayHello(){
		System.out.println("青蛙在通常情况下，和人打招呼的方式为：呱呱叫");
	}
	@Override
	void sayHello(int moodval){
		if(this.mood == 1)//开心
			System.out.println("青蛙在情绪好的情况下，和人打招呼的方式为：呱呱叫");
		else if(this.mood == 2)
			System.out.println("青蛙烦躁的时候，会：扑通一声跳入水中");
	}
	@Override
	void printInfo(){
		System.out.println("青蛙不是哺乳动物");
		System.out.println("青蛙不是肉食动物");
	}
	@Override
	public int getNumberOfLegs() {
		return 2;
	}
	@Override
	public void getGillFlag() {
		System.out.println("青蛙有腮");
	}
	@Override
	public void getLaysEggs() {
		System.out.println("青蛙有卵");
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.printInfo();//打印狗的基本信息
		dog.sayHello();//狗一般情况的打招呼
		dog.setMood(1);//狗开心的打招呼
		dog.sayHello(1);
		dog.setMood(2);//狗烦躁的打招呼
		dog.sayHello(2);
		System.out.println();//空行
		
		Cat cat=new Cat();
		cat.printInfo();//打印猫的基本信息
		cat.sayHello();//猫一般的打招呼
		cat.setMood(1);//猫开心的打招呼
		cat.sayHello(1);
		cat.setMood(2);//猫烦躁的打招呼
		cat.sayHello(2);
		System.out.println();//空行
		
		Frog frog=new Frog();
		frog.printInfo();//打印青蛙的基本信息
		frog.sayHello();//青蛙一般的打招呼
		frog.setMood(1);//青蛙开心的打招呼
		frog.sayHello(1);
		frog.setMood(2);//青蛙烦躁的打招呼
		frog.sayHello(2);
	}

}
