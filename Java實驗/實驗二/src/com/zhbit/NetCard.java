package com.zhbit;

import MyPackage.PCI;

public class NetCard implements PCI{
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
