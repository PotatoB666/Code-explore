import java.util.TreeMap;
import java.util.Vector;

/**
 * 学生类
 * @author Administrator
 *
 */
class Student{
	String sno; //学生学号
	String name; //学生姓名
	Student() { }
	Student(String sno,String name){
		this.sno = sno;
		this.name = name;
	}
}
/**
 * 课程类
 * @author Administrator
 *
 */
class Course{
	String cno; //课程号
	String name; //课程名
	Course() { }
	Course(String cno,String name){
		this.cno = cno;
		this.name = name;
	}
}
/**
 * 学生选课成绩类
 * @author Administrator
 *
 */
class Grade{
	String sno; //学生学号
	String cno; //课程号
	int score; //成绩
	Grade() { }
	Grade(String sno,String cno,int score){
		this.sno = sno;
		this.cno = cno;
		this.score = score;
	}
}
public class GradeManagement {

	public static void main(String[] args) {
		Vector<Student> hStudent = new Vector<Student>(); //学生集合
		Vector<Course> hCourse = new Vector<Course>();    //课程集合
		Vector<Grade> hGrade = new Vector<Grade>();       //选课集合
		//新建学生并加入学生集合
		hStudent.add(new Student("S001","郑东红"));
		hStudent.add(new Student("S002","陈明丽"));
		hStudent.add(new Student("S003","黄文杰"));
		//新建课程并加入课程集合
		hCourse.add(new Course("C001","嵌入式编程原理"));
		hCourse.add(new Course("C002","计算机专业英语"));
		hCourse.add(new Course("C003","微机接口与技术"));
		//新建选课并加入选课列表
		hGrade.add(new Grade("S001","C001",76));
		hGrade.add(new Grade("S001","C002",90));
		hGrade.add(new Grade("S001","C003",67));
		hGrade.add(new Grade("S002","C001",82));
		hGrade.add(new Grade("S002","C002",73));
		hGrade.add(new Grade("S002","C003",85));
		hGrade.add(new Grade("S003","C001",92));
		hGrade.add(new Grade("S003","C002",81));
		hGrade.add(new Grade("S003","C003",83));
		
		//根据成绩泛型集合中的学号和课程编号查询学生集合和课程集
		//合得到学生姓名和课程名称
		System.out.println("学号\t姓名\t课程号\t课程名\t\t成绩");
		for(Grade g:hGrade){
			System.out.print(g.sno+"\t");
			for(Student s1:hStudent){
				if(s1.sno.equals(g.sno)){
					System.out.print(s1.name+"\t");
				}
			}
			System.out.print(g.cno+"\t");
			for(Course s:hCourse){
				if(s.cno.equals(g.cno)){
					System.out.print(s.name+"\t");
				}
			}
			System.out.println(g.score);
		}

		//统计每课参加考试的人数和总分
		int[] courseSum = new int[hCourse.size()];
		int[] courseSumPeople = new int[hCourse.size()];
		for(int i = 0;i < hCourse.size();i++){
			int sum = 0;
			int sumPeople = 0;
			for(int j = 0;j < hGrade.size();j++){
				if(hGrade.get(j).cno.equals(hCourse.get(i).cno)){
					sum += hGrade.get(j).score;
					sumPeople ++ ;
				}
			}
			courseSum[i] = sum;
			courseSumPeople[i] = sumPeople;
		}
		System.out.println("***************************");
		System.out.println("课程\t\t人数\t总分");
		for(int i = 0;i<courseSum.length;i++){
			for(Course c:hCourse){
				if(c.cno.equals(hGrade.get(i).cno)){
					System.out.print(c.name+"\t");
				}
			}
			System.out.print(courseSumPeople[i]+"\t");
			System.out.println(courseSum[i]);
		}
		//实例化TreeMap集合用于保存课程编号和平均分
		TreeMap<String,Double> tm = new TreeMap<String,Double>();
		for(int i = 0;i<courseSum.length;i++){
			tm.put(hCourse.get(i).cno,(Double)( courseSum[i] / courseSumPeople[i]));
		}
		System.out.println("课程编号\t平均分");
		for(String keyNode:tm.keySet()){
			System.out.println(keyNode+"\t"+tm.get(keyNode));
		}
	}

}
