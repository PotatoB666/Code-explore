public class DemoTest {
    public static void main(String[] args) {
        Object p1 = new Person();
        Object p2 = new Person("张三丰",'男',90);
        Object mp1 = new MarPerson();
        Object mp2 = new MarPerson("尤达大师",'公',100);

        //toString()测试
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(mp1.toString());
        System.out.println(mp2.toString());

        //测试接口的多态性
        Walkable w1 = new Person();
        Walkable w2 = new MarPerson();
        ((SmartBeing)w1).talk();
        ((Person)w1).talk();
        ((Talkable)p1).talk();

        //组队对战测试
        Person[] t1 = new Person[5];//地球人组
        MarPerson[] t2 = new MarPerson[5];//火星人组

        String[] personName = new String[] {"张三","李四","王五","赵六","孙七"};//地球人姓名
        char[] personSex = new char[] {'男','女','男','女','男'};//地球人性别
        int[] personHp = new int[] {100,90,85,95,88}; //地球人体力值

        String[] marName = new String[] {"火星人1","火星人2","火星人3","火星人4","火星人5"};//火星人名字
        char[] marSex = new char[] {'公','母','母','公','母'};//火星人性别
        int[] marHp = new int[] {98,91,87,100,80};//火星人体力值

        //分别给地球人和火星人组赋初值
        for(int i = 0;i<t1.length;i++){
            t1[i] = new Person(personName[i],personSex[i],personHp[i]);
            t2[i] = new MarPerson(marName[i],marSex[i],marHp[i]);
        }

        //开始PK
        int count = 0; //地球人胜场
        for(int i = 0;i<t1.length;i++){
            System.out.print("第"+(i+1)+"场对决:"+t1[i].getBeingName()+"vs"+t2[i].getBeingName());
            if(t1[i].getHp() > t2[i].getHp()){
                count ++ ;
                System.out.println("  胜");
            }else{
                System.out.println("  败");
            }
        }
        if(count >= 3)
            System.out.println("地球人胜利了！");
        else
            System.out.println("火星人胜利了！");
    }
}
