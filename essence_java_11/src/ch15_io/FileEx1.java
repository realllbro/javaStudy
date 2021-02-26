package ch15_io;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

public class FileEx1 {
	
	/*
	 File(String fileName)
	 	=> 주어진 문자열(fileName)을 이름으로 갖는 파일을 위한 File인스턴스를 생성한다. 
	 	   파일 뿐만 아니라 디렉토리도 같은 방법으로 다룬다.
	 	   여기서 fileName은 주로 경로(path)를 포함해서 지정해 주지만, 
	 	   파일 이름만 사용해도 되는 데 이 경우 프로그램이 실행되는 위차가 경로(path)로 간주된다
	  
	  File(String pathName, String fileNmae) 
	  File(File pathName, String fileNmae) 	  
	  	=> 파일의 경로와 이름을 따로 분리해서 지정할 수 있도록 한 생성자.
	  	   이 중 두번째 것은 경로를 문자열이 아닌 File 인스턴스인 경우를 위해서 제공된 것이다
	  	   
	  File(URI uri)
	  	=> 지정된 uri로 파일을 생성
	  	
	  String getName()
	  	=> 파일이름을 String으로 반환
	  	
	  String getPath()
	  	=> 파일의 경로(path)를 String으로 반환
	  	
	  String getAbsolutePath()
	  	=> 파일의 절대경로를 String으로 반환
	  	
	  File etAbsoluteFile()
	  	=> 파일의 절대경로를 File로 반환
	  	
	  String getParent()	  	
	  	=> 파일의 조상 디렉토리를 String으로 반환
	  	
	  File getParentFile()
	  	=> 파일의 조상 디텍토리를 File로 반환
	  	
	  String getCanonicalPath()
	  	=> 파일의 정규경로를 String으로 반환
	  	
	  File getCanonicalFile()
	  	=> 파일의 정규경로를 File으로 반환	  	
	  	
	  static String pathSeparator
	  	=> OS에서 사용하는 경로(path) 구분자. 윈도우";", 유닉스":"

	  static char pathSeparatorChar
	  	=> OS에서 사용하는 경로(path) 구분자. 윈도우";", 유닉스":"	  
	  	
	  static String separator
	  	=> OS에서 사용하는 경로(path) 구분자. 윈도우"\", 유닉스"/"

	  static char separatorChar
	  	=> OS에서 사용하는 경로(path) 구분자. 윈도우"\", 유닉스"/"	  	  	
	  
	  ※ 참고 : 파일의 경로(path)와 디렉토리나 파일의 이름을 구분하는 데 사용 되는 구분자가 OS마다 다를 수 있기 때문에,
	  OS독립적으로 프로그램을 작성하기 위해서는 반드시 위의 멤버변수들을 이용해야 한다. 만일 윈도우에서 사용하는 구분자를
	  코드에 직접 적어 놓았다면, 이 코드는 다른 OS에서는 오류를 일으킬 수 있다.
	 */

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io/FileEx1.java");
		
		String fileNmae = f.getName();
		int pos = fileNmae.lastIndexOf(".");
		
		System.out.println(" 경로를 제외한 파일이름"+ f.getName());
		System.out.println(" 확장자를 제외한 파일이름"+ fileNmae.substring(0,pos));		
		System.out.println(" 확장자 - "+ fileNmae.substring(pos+1));
		
		System.out.println(" 경로를 포함한 파일이름"+ f.getPath());
		
		//파일시스템의 루트(root)로부터 시작하는 파일의 전체 경로(OS에 따라서 둘이상의 절대 경로가 존재 할 수 있다 현재 디렉토리를 의미하는 '.'와 같은 기호나 링크 등을 포함하는 경우)
		System.out.println(" 파일의 절대경로"+ f.getAbsolutePath());
		
		//기호나 링크를 포함하지 않는 유일한 경로 
		System.out.println(" 파일의 정규경로"+ f.getCanonicalPath());		
		System.out.println(" 파일의 속해 있는 디렉토리"+ f.getParent());		
		System.out.println();
		System.out.println(" File.pathSeparator - "+ File.pathSeparator);
		System.out.println(" File.pathSeparatorChar - "+ File.pathSeparatorChar);		
		System.out.println(" File.separator - "+ File.separator);						
		System.out.println(" File.separatorChar - "+ File.separatorChar);				
		System.out.println();
		
		//현재 프로그램이 실행중인 디렉토리
		System.out.println(" user.dir = "+ System.getProperty("user.dir"));	
		//classpath
		System.out.println(" sun.boot.class.path = "+ System.getProperty(" sun.boot.class.path"));
		
		
	/* 
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io","FileEx1.java");
		또는
		File dir = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io");
		File f = new File(dir, "FileEx1.java");
		
		File 인스턴스를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다.
		파일명이나 디렉토리명으로 지정된 문자열이 유효하지 않더라도 컴파일 에러나 예외를 발생시키지 않는다.
		새로운 파일을 생성하기 위해서는 File 인스턴스를 생성한 다음, 출력스트림을 생성하거나 createNewFile()을 호출해야 한다.
		
		1. 이미 존재하는 파일을 참조할 때 : 
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io","FileEx1.java");
		
		2. 기존에 없는 파일을 새로 생성할 때: 
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io","NewFile.java");
		f.createNewFile();	//새로운 파일이 생성된다.
	*/		
		
	}
}
