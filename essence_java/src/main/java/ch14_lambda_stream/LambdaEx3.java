package ch14_lambda_stream;

@FunctionalInterface
interface MyFunction3{
	void myMethod(); //public abstract void run();
}
/*
 * 외부 변수를 참조하는 람다식
 * 람다식도 익명 객체, 즉 익명 클래스의 인스턴스이므로 람다식에서 외부에 선언된 변수에 접근하는 규칙은 익명 클래스와 동일하다. 
 */

class Outer{
	int val = 10;
	
	class Inner{
		int val = 20;	//this.val
		
		void method(int i) {	// void method(final int i){
			int val = 30;		// final int val=30;
//			i = 10;				// 에러. 상수의 값을 변경할 수 없음.
			
			MyFunction3 f = () -> {
				System.out.println("			 i : "+ i);
				System.out.println("		   val : "+ val);
				System.out.println("	  this.val : "+ ++this.val);
				System.out.println("Outer.this.val : "+ ++Outer.this.val);
			};
			
			f.myMethod();
		}
	}	//Inner
}	//Outer

class LambdaEx3{
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}

/*
			 i : 100
		   val : 30
	  this.val : 21
Outer.this.val : 11
*/ 
