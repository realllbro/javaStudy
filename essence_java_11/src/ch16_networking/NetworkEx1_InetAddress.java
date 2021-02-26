package ch16_networking;

import java.net.*;
import java.util.*;

public class NetworkEx1_InetAddress {
	
/*	
	IP �ּҸ� �ٷ�� ���� Ŭ���� InetAddress
	
	byte[] getAddress()	
		=> IP�ּҸ� byte�迭�� ��ȯ�Ѵ�.
		
	static InetAddress[] getAllByName(String host) 
		=> �����θ�(host)�� ������ ��� ȣ��Ʈ�� IP �ּҸ� �迭�� ��� ��ȯ�Ѵ�.
		
	static InetAddress getByAddress(byte[] addr) 
		=>  byte�迭�� ���� IP �ּҸ� ��´�.
		
	static InetAddress getByName(String host) 
		=>  �����θ�(host)�� ���� IP�ּҸ� ��´�.
		
	String getCanonicalHostName() 
		=>  FQDN(fully qualified domain name)�� ��ȯ�Ѵ�.
		
	String getHostAddress()	
		=> ȣ��Ʈ�� IP�ּҸ� ��ȯ�Ѵ�.
		
	String getHostName()	
		=> ȣ��Ʈ�� �̸��� ��ȯ�Ѵ�.
		
	static InetAddress getLocalHost()	
		=> ����ȣ��Ʈ�� IP�ּҸ� ��ȯ�Ѵ�.
		
	boolean isMulticastAddress()	
		=> IP�ּҰ� ��Ƽĳ��Ʈ �ּ����� �˷��ش�
		
	boolean isLoopbackAddress()	
		=> IP�ּҰ� loopback �ּ�(127.0.0.1)���� �˷��ش�.	
*/		
	
	public static void main(String[] args) {
		
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());			
			System.out.println("toString() : "+ip.toString());
			
			System.out.println("getCanonicalHostName() : "+ip.getCanonicalHostName());			
			
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() :"+Arrays.toString(ipAddr));
			
			// ?????? ����...
			String result = "";
			for(int i=0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ?  ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			
			System.out.println("getAddress() + 256 : "+result);
			System.out.println();
			
		/*
			getHostName() : www.naver.com
			getHostAddress() : 125.209.222.141
			toString() : www.naver.com/125.209.222.141
			getAddress() :[125, -47, -34, -115]
			getAddress()+256 : 125.209.222.141.
		 */			
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());
			System.out.println();
			
		/*
			getHostName() : SKCC16N01065
			getHostAddress() : 10.250.107.251
		 */
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			
			for(int i=0; i < ipArr.length; i++) {
				System.out.println("ipArr["+i+"] : "+ipArr[i]);
			}
			
		/*
			ipArr[0] : www.naver.com/125.209.222.141
			ipArr[1] : www.naver.com/223.130.195.95 
		 */
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
