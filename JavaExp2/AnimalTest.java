//接口
interface LandAnimal{
	abstract int getNumberOfLegs();
}

interface WaterAnimal{
	abstract void getGillFlag();
	abstract void getLaysEggs();
}

//父类
class Animal{
	//属性
	String name;
	boolean mammal;
	boolean canivorious;
	int mood;
	
	//构造方法（两个）
	
	boolean isMammal( ){
		return mammal;
	}
	boolean isCarnivorous( ){
		return canivorious;
	}
	
	//以下方法构成重载
	// 一般情况下打招呼的方法
	void sayHello(){
		
	}
	//情绪打招呼的方法
	void sayHello(int moodval){
		this.mood = moodval;
	}
	
	void setMood(int value){
		this.mood = value;
	}
	
	int getMood(){
		return this.mood ;
	}
	
	//打印方法（可选）
	void printInfo(){
		if(this.mammal)
			System.out.println("这是哺乳类动物");
		if(this.canivorious)
			System.out.println("这是肉食动物");
		else
			System.out.println("这是食草类动物");
	}
}

//子类
class Dog extends Animal implements LandAnimal{
	//构造方法（两个）
	Dog(){
		this.mammal = true;
		this.canivorious = true;
	}
	Dog(int mood){
		this.mood = mood;
		this.mammal = true;
		this.canivorious = true;
	}
	//重写父类的打招呼的方法
	void sayHello(){
		System.out.println("狗在通常情况下，和人打招呼的方式为：摇尾巴");
	}
	@Override
	void sayHello(int moodval){
		super.sayHello(moodval);
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
	}
	Cat(int mood){
		this.mood = mood;
		this.mammal = true;
		this.canivorious = true;
	}
	//重写父类的打招呼的方法
	void sayHello(){
		System.out.println("猫通常情况下，和人打招呼的方式为：喵喵叫");
	}
	void sayHello(int moodval){
		super.sayHello(moodval);
		if(this.mood == 1)//开心
			System.out.println("猫被抚摸情绪好的情况下，打招呼的方式为：咕噜咕噜叫");
		else if(this.mood == 2)
			System.out.println("猫烦躁的时候，会：嘶嘶叫");
	}
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
	void sayHello(){
		System.out.println("青蛙在通常情况下，和人打招呼的方式为：呱呱叫");
	}
	void sayHello(int moodval){
		super.sayHello(moodval);
		if(this.mood == 1)//开心
			System.out.println("青蛙在情绪好的情况下，和人打招呼的方式为：呱呱叫");
		else if(this.mood == 2)
			System.out.println("青蛙烦躁的时候，会：扑通一声跳入水中");
	}
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
		Dog dog=new Dog(); //继续往下写
		dog.printInfo();
		dog.sayHello();
		dog.setMood(1);
		dog.sayHello(1);
		dog.setMood(2);
		dog.sayHello(2);
		System.out.println();
		
		Cat cat=new Cat();
		cat.printInfo();
		cat.sayHello();
		cat.setMood(1);
		cat.sayHello(1);
		cat.setMood(2);
		cat.sayHello(2);
		System.out.println();
		
		Frog frog=new Frog();
		frog.printInfo();
		frog.sayHello();
		frog.setMood(1);
		frog.sayHello(1);
		frog.setMood(2);
		frog.sayHello(2);
	}

}
