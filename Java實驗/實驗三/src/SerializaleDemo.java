import java.io.*;
import java.util.*;

enum MovieType implements Serializable{ //��Ӱ����
	COMEDY("ϲ��Ƭ"),SCIENCE("�ƻ�Ƭ");
	String name = "";
	MovieType(String name)
	{
		this.name = name;
	}
}

class Movie implements Serializable{ //��Ӱ
	String name;
	Movie(String name){
		this.name = name;
	}
}

class MovieSchedule implements Serializable{//��Ӱʱ��
	int year;
	int month;
	int day;
	int hour;
	int minute;
	MovieSchedule(int year,int month,int day,
			int hour,int minute) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}
	String getTime(){
		return year+"��"+month+"��"+day+"�� "+
				hour+"ʱ"+minute+"��";
	}
}

class Ticket implements Serializable{
	Movie m;
	MovieType mt;
	MovieSchedule ms;
	String hall;  //��ӳ��
	String seat;  //��λ
	public void printTicket(){
		System.out.println(m.name);
		System.out.println("����:"+mt.name);
		System.out.println("��ӳ��:"+hall);
		System.out.println("ʱ��:"+ms.getTime());
		System.out.println("��λ:"+seat);
	}
	public Ticket(Movie m,MovieType mt,MovieSchedule ms,
			String hall,String seat){
		this.m = m;
		this.mt = mt;
		this.ms = ms;
		this.hall = hall;
		this.seat = seat;
	}
}

public class SerializaleDemo {
	public static void main(String[] args) {
		Movie m1 = new Movie("����ʯͷ");
		Movie m2 = new Movie("2012");
		
		MovieSchedule ms1 = new MovieSchedule(2010, 7, 12, 20, 20);
		MovieSchedule ms2 = new MovieSchedule(2010, 7, 14, 19, 40);
		
		Ticket t1 = new Ticket(m1, MovieType.COMEDY, ms1, "��ӳ��1", "10��12��");
		Ticket t2 = new Ticket(m1, MovieType.COMEDY, ms1, "��ӳ��1", "10��13��");		
		Ticket t3 = new Ticket(m2, MovieType.SCIENCE, ms2, "��ӳ��2", "8��8��");
		Ticket t4 = new Ticket(m2, MovieType.SCIENCE, ms2, "��ӳ��2", "8��9��");
		
		t1.printTicket();
		System.out.println("=========================");
		t2.printTicket();
		System.out.println("=========================");
		t3.printTicket();
		System.out.println("=========================");
		t4.printTicket();
	}
}
