package MyPackage;

public class MainBoard {
	public void run()
	{
		System.out.println("main borad run...");
	}
	
	public void usePCI(PCI p)
	{
		if(p!=null)
		{
			p.open();
			p.close();
		}
	}
}
