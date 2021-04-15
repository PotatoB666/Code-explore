package MyPackage;
import java.util.TimerTask;

public class MyTask extends TimerTask{
	@Override
	public void run() {
		try {
			Class c_a = Class.forName("A");
			A a_ins = (A)c_a.newInstance();
			a_ins.f1();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}
	}
}
