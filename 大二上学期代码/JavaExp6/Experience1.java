import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 题目一：写入文件
 * 题目二：从文件中搜索内容
 * @author Administrator
 *
 */
public class Experience1 {
	public static void main(String[] args){
		//题目一：写入文件
		try{
			//创建输入流，从System.in读入
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			File f = new File("exp1_test.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			String in = "";
			System.out.println("请输入下一行文字:");
			while(!(in = br.readLine()).equals("bye")){
				bw.write(in+"\r\n");
				System.out.println("请输入下一行文字:");
			}
			bw.close();
			fw.close();
			
			
			
			//题目二：从文件中搜索内容
			System.out.println("请输入要寻找的字符串");
			String searchStr = br.readLine();
			BufferedReader br1 = new BufferedReader(new FileReader(f));
			String next = "";
			int countLine = 0;
			while((next = br1.readLine())!=null){
				int charIndex = -1;
				if((charIndex = next.indexOf(searchStr))!=-1){
					System.out.println("找到了，在"+(countLine+1)+"行第"+(charIndex+1)+"个字符.");
					break;
				}
				countLine ++;
			}
			br.close();
			isr.close();
			br1.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}
}
