package MyPackage;
import java.io.*;
import java.util.*;

public class Exp1 {

	public static void main(String[] args) {
		//练习一：使用反射机制周期性读取文件 
		Timer timer=new Timer();

		Calendar now=Calendar.getInstance();
		Date runDate=now.getTime();

		MyTask task2=new MyTask();

		timer.scheduleAtFixedRate(task2, runDate, 5000);

	}
}

class A{
	public void f1() {
		System.out.println("hello java");
		try {
			FileInputStream fis = new FileInputStream("conf.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			StringBuffer sb = new StringBuffer();
			String cache = "";
			while((cache=br.readLine())!=null)
			{
				sb.append(cache);
			}
			br.close();
			fis.close();
		}catch(IOException ex) {
			ex.printStackTrace();
			
		}
	}
}
