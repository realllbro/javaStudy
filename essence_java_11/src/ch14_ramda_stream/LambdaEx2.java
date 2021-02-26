package ch14_ramda_stream;

class LambdaEx2{
	public static void main(String[] args) {
		MyFunction f = () -> {}; 				//MyFunction f = (MyFunction)(()->{});
		Object obj = (MyFunction)(()->{});		//Object Ÿ������ ����ȯ�� ������
		String str = ((Object)(MyFunction)(()->{})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(()->{});		����. ���ٽ��� ObjectŸ������ ����ȭ �ȵ�
		System.out.println((MyFunction)(()->{}));
//		System.out.println((MyFunction)()->{}).toString());	// ����
		System.out.println(((Object)(MyFunction)(()->{})).toString());		
	}
}
