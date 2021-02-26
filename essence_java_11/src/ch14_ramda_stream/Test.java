package ch14_ramda_stream;

public class Test {
	
	public static void main(String args[]) {
	}
	
/*	
	반환값이 있는 메서드의 경우, return 문 대신 '식(expression)'으로 대신 할 수 있다. 
	식의 연산결과가 자동적으로 반환값이 된다. 이때는 '문장(statement)'이 아닌 '식' 이므로 끝에
	';'를 붙이지 않는다.
	
	int max(int a, int b) {
		return a > b ? a : b;	 =>   (int a, int b) -> a > b ? a:b
	}
	
	람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있는데, 대부분의 경우에
	생략가능하다. 람다식에 반환타입이 없는 이유도 항상 추론이 가능하기 때문이다.
	
	int max(int a, int b) {
		return a > b ? a : b;	 =>   (a, b) -> a > b ? a:b
	}	
	
	선언된 매개변수가 하나뿐인 경우에는 괄호()를 생략할 수 있다. 
	단, 매개변수의 타입이 있으면 괄호()를 생략 할 수 없다.
	
	(a) -> a * a	=>		a -> a * a
	(int a) -> a * a	=>	(int a) -> a * a
	
	마찬가지로 메서드의 바디 괄호{} 안의 문장이 하나일 때는 괄호{}를 생략할 수 있다. 
	이 때 문장의 끝에 ';'을 붙이지 않아야 한다는 것에 주의하자.
	
	(String name, int i) -> {							(String name, int i) -> 
		System.out.println(name+"="+i);		=>				System.out.println(name+"="+i);
	}	
	
	그러나 괄호{} 안의 문장이 return문일 경우 괄호{}를 생략할 수 없다.
	(int a, int b) -> {return a > b ? a : b;}
	
	
예제.1
	int max(int a, int b) {
		return a > b ? a : b;
	}
=> 람다식으로 변환
	(int a, int b) -> {return a > b ? a:b;}
	(int a, int b) -> a > b ? a:b	
	(a,b) -> a > b ? a:b	
	
예제.2
	void printVar(String name, int i) {
		System.out.println(name+"="+i);
	}
=> 람다식으로 변환	
	(String name, int i) -> {System.out.println(name+"="+i);}
	(name, i) -> System.out.println(name+"="+i)
	
	
예제.3
	int square(int x) {
		return x * x;
	}
=> 람다식으로 변환	
	(int x) -> {return x * x;}
	(x) -> x * x
	x -> x * x
	 
예제.4
	int roll() {
		return (int)(Math.random()*6);
	}
=> 람다식으로 변환	
	() -> {return (int)(Math.random()*6);}
	() -> (int)(Math.random()*6)	
	
예제.5
	int sumArr(int[] arr) {
		int sum = 0;
		for(int i : arr)
			sum += i;
		return sum;
	}
=> 람다식으로 변환 	
	(int[] arr) -> {
						int sum = 0;
						for(int i : arr)
							sum += i;
						return sum;
					}
					
					
					
1.3 함수형 인터페이스(Functional Interface)
					
*/					
}
/*
interface MyFunction {
	public abstract int max(int a, int b);
}

//익명클래스
MyFunction f = new MyFunction() {
					public int max(int a, int b) {
						return a > b ? a : b;
					}
}

int big = f.max(5, 3);

//람다식으로 대체
MyFunction f = (int a, int b) -> a > b ? a : b;

int big = f.max(5, 3);
*/
