package ch13_thread;

/* �̱�/��Ƽ ������ ���� ThreadEx4, ThreadEx5, ThreadEx6, ThreadEx7 */
public class ThreadEx4 {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println("�ҿ�ð�1: " +(System.currentTimeMillis()-startTime));
		
		for(int i=0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println("�ҿ�ð�2: " +(System.currentTimeMillis()-startTime));
	}
}
