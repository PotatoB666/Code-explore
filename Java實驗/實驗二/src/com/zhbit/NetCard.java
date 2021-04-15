package com.zhbit;

import MyPackage.PCI;

public class NetCard implements PCI{
	@Override
	public void open()
	{
		System.out.println("网卡已打开");
	}
	@Override
	public void close()
	{
		System.out.println("网卡已关闭");
	}
}
