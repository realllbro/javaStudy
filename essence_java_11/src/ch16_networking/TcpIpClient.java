package ch16_networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {
	public static void main(String args[]) {
		try {
			String serverIp = "127.0.0.1";
			
			System.out.println("������ �������Դϴ�. ����IP : "+serverIp);
			
			// ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp,7777);
			
			// ������ �Է½�Ʈ���� ��´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������� ���� ���� �����͸� ����Ѵ�.
			System.out.println("������ ���� ���� �޽��� : "+dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			// ������ ��� ��Ʈ���� ��´�.
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			// ���� ����(remote socket)�� �����͸� ������.
			dos.writeUTF("Client ���� �����͸� �����߽��ϴ�.");
			System.out.println("�����͸� �����߽��ϴ�.");		
			
			dos.close();
			
			// ��Ʈ���� ������ �ݴ´�.
			dis.close();
			socket.close();
			System.out.println("������ ���� �Ǿ����ϴ�.");
			
		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
