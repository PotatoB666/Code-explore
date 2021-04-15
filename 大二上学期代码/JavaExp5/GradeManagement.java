import java.util.TreeMap;
import java.util.Vector;

/**
 * ѧ����
 * @author Administrator
 *
 */
class Student{
	String sno; //ѧ��ѧ��
	String name; //ѧ������
	Student() { }
	Student(String sno,String name){
		this.sno = sno;
		this.name = name;
	}
}
/**
 * �γ���
 * @author Administrator
 *
 */
class Course{
	String cno; //�γ̺�
	String name; //�γ���
	Course() { }
	Course(String cno,String name){
		this.cno = cno;
		this.name = name;
	}
}
/**
 * ѧ��ѡ�γɼ���
 * @author Administrator
 *
 */
class Grade{
	String sno; //ѧ��ѧ��
	String cno; //�γ̺�
	int score; //�ɼ�
	Grade() { }
	Grade(String sno,String cno,int score){
		this.sno = sno;
		this.cno = cno;
		this.score = score;
	}
}
public class GradeManagement {

	public static void main(String[] args) {
		Vector<Student> hStudent = new Vector<Student>(); //ѧ������
		Vector<Course> hCourse = new Vector<Course>();    //�γ̼���
		Vector<Grade> hGrade = new Vector<Grade>();       //ѡ�μ���
		//�½�ѧ��������ѧ������
		hStudent.add(new Student("S001","֣����"));
		hStudent.add(new Student("S002","������"));
		hStudent.add(new Student("S003","���Ľ�"));
		//�½��γ̲�����γ̼���
		hCourse.add(new Course("C001","Ƕ��ʽ���ԭ��"));
		hCourse.add(new Course("C002","�����רҵӢ��"));
		hCourse.add(new Course("C003","΢���ӿ��뼼��"));
		//�½�ѡ�β�����ѡ���б�
		hGrade.add(new Grade("S001","C001",76));
		hGrade.add(new Grade("S001","C002",90));
		hGrade.add(new Grade("S001","C003",67));
		hGrade.add(new Grade("S002","C001",82));
		hGrade.add(new Grade("S002","C002",73));
		hGrade.add(new Grade("S002","C003",85));
		hGrade.add(new Grade("S003","C001",92));
		hGrade.add(new Grade("S003","C002",81));
		hGrade.add(new Grade("S003","C003",83));
		
		//���ݳɼ����ͼ����е�ѧ�źͿγ̱�Ų�ѯѧ�����ϺͿγ̼�
		//�ϵõ�ѧ�������Ϳγ�����
		System.out.println("ѧ��\t����\t�γ̺�\t�γ���\t\t�ɼ�");
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

		//ͳ��ÿ�βμӿ��Ե��������ܷ�
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
		System.out.println("�γ�\t\t����\t�ܷ�");
		for(int i = 0;i<courseSum.length;i++){
			for(Course c:hCourse){
				if(c.cno.equals(hGrade.get(i).cno)){
					System.out.print(c.name+"\t");
				}
			}
			System.out.print(courseSumPeople[i]+"\t");
			System.out.println(courseSum[i]);
		}
		//ʵ����TreeMap�������ڱ���γ̱�ź�ƽ����
		TreeMap<String,Double> tm = new TreeMap<String,Double>();
		for(int i = 0;i<courseSum.length;i++){
			tm.put(hCourse.get(i).cno,(Double)( courseSum[i] / courseSumPeople[i]));
		}
		System.out.println("�γ̱��\tƽ����");
		for(String keyNode:tm.keySet()){
			System.out.println(keyNode+"\t"+tm.get(keyNode));
		}
	}

}
