package ch13_thread;

import javax.swing.JOptionPane;

/* �̱�/��Ƽ ������ ���� ThreadEx4, ThreadEx5, ThreadEx6, ThreadEx7 */
public class ThreadEx7 {

	public static void main(String[] args) {
		
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
	}
}

class ThreadEx7_1 extends Thread{
	
	@Override
	public void run() {
		for(int i=10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);	// 1�ʰ� �ð��� �����Ѵ�.
			} catch(Exception e) {}
		}		
	}
}
