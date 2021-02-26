package ch16_networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		
		try {
			// ���� ������ �����Ͽ� 7777�� ��Ʈ�� ����(bind)��Ų��.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"������ �غ�Ǿ����ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime()+"���� ��û�� ��ٸ��ϴ�.");
				
				// ���� ������ Ŭ���̾�Ʈ�� ���� ��û�� �� �� ���� ������ ���߰� ��� ��ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�� ���� �����û�� ���Խ��ϴ�.");
				
				// ������ ��� ��Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime()+"�����͸� �����߽��ϴ�.");
				
				// ������ �Է½�Ʈ���� ��´�.
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				
				// �������� ���� ���� �����͸� ����Ѵ�.
				System.out.println("������ ���� ���� �޽��� : "+dis.readUTF());
				System.out.println("������ �����մϴ�.");				
				
				dis.close();				
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ���� �ð��� ���ڿ��� ��ȯ�ϴ� �Լ�
	public static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}	
}
