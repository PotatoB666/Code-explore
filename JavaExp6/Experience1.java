import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ��Ŀһ��д���ļ�
 * ��Ŀ�������ļ�����������
 * @author Administrator
 *
 */
public class Experience1 {
	public static void main(String[] args){
		//��Ŀһ��д���ļ�
		try{
			//��������������System.in����
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			File f = new File("exp1_test.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			String in = "";
			System.out.println("��������һ������:");
			while(!(in = br.readLine()).equals("bye")){
				bw.write(in+"\r\n");
				System.out.println("��������һ������:");
			}
			bw.close();
			fw.close();
			
			
			
			//��Ŀ�������ļ�����������
			System.out.println("������ҪѰ�ҵ��ַ���");
			String searchStr = br.readLine();
			BufferedReader br1 = new BufferedReader(new FileReader(f));
			String next = "";
			int countLine = 0;
			while((next = br1.readLine())!=null){
				int charIndex = -1;
				if((charIndex = next.indexOf(searchStr))!=-1){
					System.out.println("�ҵ��ˣ���"+(countLine+1)+"�е�"+(charIndex+1)+"���ַ�.");
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
