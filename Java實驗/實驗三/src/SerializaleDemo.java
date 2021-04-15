import java.io.*;
import java.util.*;

enum MovieType implements Serializable{ //电影类型
	COMEDY("喜剧片"),SCIENCE("科幻片");
	String name = "";
	MovieType(String name)
	{
		this.name = name;
	}
}

class Movie implements Serializable{ //电影
	String name;
	Movie(String name){
		this.name = name;
	}
}

class MovieSchedule implements Serializable{//电影时间
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
		return year+"年"+month+"月"+day+"日 "+
				hour+"时"+minute+"分";
	}
}

class Ticket implements Serializable{
	Movie m;
	MovieType mt;
	MovieSchedule ms;
	String hall;  //放映厅
	String seat;  //座位
	public void printTicket(){
		System.out.println(m.name);
		System.out.println("类型:"+mt.name);
		System.out.println("放映厅:"+hall);
		System.out.println("时间:"+ms.getTime());
		System.out.println("座位:"+seat);
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
		Movie m1 = new Movie("疯狂的石头");
		Movie m2 = new Movie("2012");
		
		MovieSchedule ms1 = new MovieSchedule(2010, 7, 12, 20, 20);
		MovieSchedule ms2 = new MovieSchedule(2010, 7, 14, 19, 40);
		
		Ticket t1 = new Ticket(m1, MovieType.COMEDY, ms1, "放映厅1", "10排12座");
		Ticket t2 = new Ticket(m1, MovieType.COMEDY, ms1, "放映厅1", "10排13座");		
		Ticket t3 = new Ticket(m2, MovieType.SCIENCE, ms2, "放映厅2", "8排8座");
		Ticket t4 = new Ticket(m2, MovieType.SCIENCE, ms2, "放映厅2", "8排9座");
		
		t1.printTicket();
		System.out.println("=========================");
		t2.printTicket();
		System.out.println("=========================");
		t3.printTicket();
		System.out.println("=========================");
		t4.printTicket();
	}
}
