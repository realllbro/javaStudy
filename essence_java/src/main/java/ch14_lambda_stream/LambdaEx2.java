package ch14_lambda_stream;

@FunctionalInterface
interface MyFunction2{
	void run(); //public abstract void run();
}

/*
 * 람다식의 타입과 형변환
 * 함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 함수형 인터페이스의 타입과 일치하는 것은 아니다.
 * 람다식은 익명 객체이고 익명 객체는 타입이 없다. 정확히는 타입은 있지만 컴파일러가 임의로 이름을 정하기 때문에 알 수 없는 것이다.
 * 
 */
public class LambdaEx2{
	public static void main(String[] args) {
		MyFunction2 f = () -> {}; 				//MyFunction f = (MyFunction)(()->{});
		Object obj = (MyFunction2)(()->{});		//Object 타입으로 형변환이 생략됨
		String str = ((Object)(MyFunction2)(()->{})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(()->{});		에러. 람다식은 Object타입으로 형변환 안됨
		System.out.println((MyFunction2)(()->{}));
//		System.out.println((MyFunction)()->{}).toString());	// 에러
		System.out.println(((Object)(MyFunction2)(()->{})).toString());		
	}
}

/*
ch14_lambda_stream.LambdaEx2$$Lambda$1/531885035@6ce253f1
ch14_lambda_stream.LambdaEx2$$Lambda$2/135721597@53d8d10a
ch14_lambda_stream.LambdaEx2$$Lambda$3/142257191@3e3abc88
ch14_lambda_stream.LambdaEx2$$Lambda$4/245257410@65ab7765
ch14_lambda_stream.LambdaEx2$$Lambda$5/455659002@eed1f14
*/