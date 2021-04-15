package com.zhbit;
import MyPackage.*;

public class SoundCard implements PCI{
	@Override
	public void open()
	{
		System.out.println("�����Ѵ�");
	}
	@Override
	public void close()
	{
		System.out.println("�����ѹر�");
	}
}
