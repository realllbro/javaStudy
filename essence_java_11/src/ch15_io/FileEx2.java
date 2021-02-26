package ch15_io;

import java.io.File;

public class FileEx2 {
	
	/*
		boolean canRead()
		    => 읽을 수 있는 파일인지 검사한다.
		    
		boolean canWrite()
		    => 쓸 수 있는 파일인지 검사한다.
		    
		boolean canExecute()
			=> 실행할 수 있는 파일인지 검사한다.
			
		int compareTo(File pathname)
			=> 주어진 파일 또는 디렉토리를 비교한다. 같으면 0을 반환하며, 다르면 1또는 -1을 반환한다.
			  (Unix 시스템에서는 대소문자를 구별하며, Windows에서는 구별하지 않는다.)
		
		boolean exists()
			=> 파일이 존재하는지 검사한다.
			
		boolean isAbsolute() 
			=> 파일 또는 디렉토리가 절대경로명으로 지정되었는지 확인한다.
			
		boolean isDirectory()
		 	=> 디렉토리인지 확인하다.
		 	
		boolean isFile()
		 	=> 파일인지 확인하다. 	
		 	
		boolean isHidden()
		 	=> 파일의 속성이 숨김(Hidden)인지 확인한다. 또한 파일이 존재하지 않으면 false를 반환한다. 	 	
		 	
		boolean createNewFile()
		 	=> 아무런 내용이 없는 새로운 파일을 생성한다.(단, 생성하려는 파일이 이미 존재하면 생성되지 않는다.)
		 	
		static File createTempFile(String prefix, String suffix)
			=> 임시파일을 시스템의 임시 디렉토리에 생성한다.
			System.out.println(File.createTempFile("work",".tmp"))
			결과 c:\ .....
			
		static File createTempFile(String prefix, String suffix, File directory)
			=> 임시 파일을 시스템의 지정된 디렉토리에 생성한다.
		
		boolean delete()
			=> 파일을 삭제한다.
			
		void deleteOnExit() 
			=> 응용 프로그램 종료시 파일을 삭제한다. 주로 실행 시 작업에 사용된 임시파일을 삭제하는데 사용된다.
			
		boolean equals(Object obj)
			=> 주어진 객체(주로 File인스턴스)가 같은 파일인지 비교한다.
			  (UNIX 시스템에서는 대소문자를 구별하며, Windows에서는 구별하지 않는다.)
			
		long lastModified()
			=> 파일의 마지막으로 수정된 시간을 지정된 시간을 반환
			
		long length()
			=> 파일의 크기를 반환한다.
			
		String[] list()
			=> 디렉토리의 파일목록(디렉토리 포함)을 String 배열로 반환한다.
			
		String[] list(FilenameFilter filter)
			=> FilenameFilter 인스턴스에 구현된 조건에 맞는 파일을 String배열 로 반환한다.
		
		File[] list(FilenameFilter filter)
			=> FilenameFilter 인스턴스에 구현된 조건에 맞는 파일을 File배열 로 반환한다.	
			
		File[] listFiles()	
			=> 디렉토리의 파일목록(디렉토리 포함)을 File 배열로 반환
			
		File[] listFiles(FileFilter filter)	
			=> 디렉토리의 파일목록(디렉토리 포함)을 filter의 조건과 일치하는 파일만 File 배열로 반환
			
		File[] listFiles(FilenameFilter f)	
			=> 디렉토리의 파일목록(디렉토리 포함)을 filter의 조건과 일치하는 파일만 File 배열로 반환
		
		static File[] listRoots() 
			=> 컴퓨터의 파일시스템의 root의 목록(floppy, CD-ROM, HDD drive)을 반환(예:A:\, C:\, D:\)
			
		long getFreeSpace()	
			=> File이 root 일때, 비어있는 공간을 바이트 단위로 반환
			
		long getTotalSpace()
			=> File이 root 일때, 전체 공간을 바이트 단위로 반환
			
		long getUsableSpace()
			=> File이 root 일때, 사용가능한 공간을 바이트 단위로 반환
			
		boolean mkdir()
			=> 파일에 지정된 경로로 디렉토리(폴더)를 생성, 성공하면 true
			
		boolean mkdirs() 
			=> 파일에 지정된 경로로 디렉토리(폴더)를 생성, 성공하면 true 
			   필요하면 부모 디렉토리까지 생성
			
		boolean renameTo(File dest)
			=> 지정된 파일(dest)로 이름을 변경
			
		boolean setExecutable(boolean executable)
		boolean setExecutable(boolean executable, boolean ownerOnly)
		boolean setReadable(boolean readable)
		boolean setReadable(boolean readable, boolean ownerOnly)
		boolean setReadOnly()
		boolean setWritable(boolean writable)
		boolean setWritable(boolean writable, boolean ownerOnly)
			=> 파일의 속성을 변경한다. ownerOnly가 true면, 파일의 소유자만 해당 속성을 변경할 수 있다.
		
		boolean setLastModified(long f)
			=> 파일의 마지막으로 수정된 시간을 지정된(t)으로 변경
			
		Path toPath()
			=> 파일을 Path로 변환해서 반환
			
		URI toURI()
			=> 파일을 URI로 변환해서 반환
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx2 DIRECTORY");
			System.exit(0);
		}
		
		File f = new File(args[0]);
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);			
		}
		
		File[] files = f.listFiles();
		
		for(int i=0; i < files.length; i++) {
			String fileName = files[i].getName();
			System.out.println(files[i].isDirectory() ? "["+fileName+"]" : fileName);
		}
		
		String[] strFiles = f.list();	
		for(int i=0; i < strFiles.length; i++) {
			System.out.println(strFiles[i]);			
		}		
	}
}
