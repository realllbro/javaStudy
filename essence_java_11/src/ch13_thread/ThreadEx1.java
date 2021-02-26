package ch13_thread;

public class ThreadEx1 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1("extends");
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r,"implements");		//������ Thread(Runnable target)
		
		/* ���ٷ� ǥ��
		Thread t2 = new Thread(new ThreadEx1_2());
		*/		
		
		t1.start();
		t2.start();
		
		/*
		�������� �̸��� �����ڳ� �޼��带 ���ؼ� ���� �Ǵ� ���� �� �� �ִ�.
		Thread(Runnable target, String name)
		Thread(String name)
		void setName(String name)
		*/		
	}
}

//Thread �� ��ӹ޾Ƽ� ��� 
class ThreadEx1_1 extends Thread{
	
	public ThreadEx1_1(){}
	
	public ThreadEx1_1(String threadNm) {
		super.setName(threadNm);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName());	// ������ Thread�� getName()�� ȣ��
		}
	}
}

//Runnable �������̽��� ���� 
class ThreadEx1_2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			// Thread.currentThread() - ���� �������� Thread�� ��ȯ�Ѵ�.
			/*
			 Thread t = Thread.currentThread();
			 String name = t.getName();
			 System.out.println(name);
			 */
			
			
			System.out.println(Thread.currentThread().getName());
		}			
	}
	
}
