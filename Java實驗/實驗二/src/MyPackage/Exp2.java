package MyPackage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Exp2 {

	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		mb.run();
		
		try 
		{
			FileInputStream fis = new FileInputStream("pci.properties");
			Properties prop = new Properties();
			prop.load(fis);
			int n = prop.size();
			
			//开始读取pci.properties的内容并找到对应的类
			for(Object key:prop.keySet())
			{
				String pci_name = (String)key;
				try 
				{
					Class pci_class = Class.forName((String)prop.get(key));
					PCI p = (PCI) pci_class.newInstance();
					mb.usePCI(p);
				}
				catch(ClassNotFoundException ex)
				{
					System.out.println(pci_name+"对应的类没有找到");
					ex.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
