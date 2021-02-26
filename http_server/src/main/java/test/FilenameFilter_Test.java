package test;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilenameFilter_Test {
	
	public static File[] fileNameList;
	
	public static void main(String[] args) throws Exception{
		
	    String fileRoot = "C:\\devbro\\study\\project\\sts_workspace\\http_server";
	    
	    //searchFile(fileRoot);
	    //addList(fileRoot);
	    
	    /*
	    File[] fileNameList = FilenameFilter_Test.addList(fileRoot);
        
        for(File curFile : fileNameList) { 
            System.out.println(curFile.getPath()); 
        }  
       */      
	    
	    //Files.find(null, 0, null, null)
	    
	    Path start = Paths.get(fileRoot);
	    
	    //path.getFileName().indexOf("H") > -1
	    

	    int maxDepth = 5; // Integer.MAX_VALUE로 하면 모든 파일을 가져올 수 있다
	    
	    //Files.find(start, maxDepth, (path, attr) -> path.getFileName().toString().indexOf("H") > -1).forEach(System.out::println);
	    //Stream<Path> stream1 = Files.find(start, Integer.MAX_VALUE, (path, attr) -> path.getFileName().toString().indexOf("H") > -1);
	    Stream<Path> stream1 = Files.find(start, Integer.MAX_VALUE,(path, attr)-> path.getFileName().toString().toUpperCase().indexOf("H") > -1);	    
	    //List<Path> list = stream1.collect(Collectors.toList());
	    
	    List<String> list1 = stream1.filter(path -> path.toFile().isFile()).map(Path::toString).map(s -> s.replaceAll("\\\\", "/")).sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
	    
	    
	    Stream<Path> stream2 = Files.find(start, Integer.MAX_VALUE,(path, attr)-> path.getFileName().toString().toUpperCase().indexOf("H") > -1);
	    Map list2 = stream2.filter(path -> path.toFile().isFile()).map(Path::getFileName).sorted().collect(Collectors.toMap(Path::getFileName,Path::getFileName));

	    System.out.println(list2.toString());	    
	    
	    
	    
	    for(String path:list1) {
	    	System.out.println("path : "+path);
	    	/*
	    	System.out.println("path.getFileSystem : "+path.getFileSystem());
	    	System.out.println("path.getRoot : "+path.getRoot());	    	
	    	System.out.println("path.getParent : "+path.getParent());	    	
	    	System.out.println("path.getFileName : "+path.getFileName());
	    	System.out.println("path.getName : "+path.getName(1));
	    	*/	    	
	    }
	    
	    int cnt = 1;
	    try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->
	    	path.getFileName().toString().indexOf("H") > -1)) {
	        String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining("\n"));
//	        System.out.println(cnt+" : "+joined);
	        cnt++;
	    }
	    String filelist = Files.find(start, maxDepth, (path, attr) -> path.getFileName().toString().indexOf("H") > -1).sorted().map(String::valueOf).collect(Collectors.joining("\n"));
	    
//	    System.out.println(filelist);
	    
	}
	public static void searchFile(String fileRoot) {
        File rootDir = new File(fileRoot); 
        File[] fileList= rootDir.listFiles();
        
        for(File file : fileList) {
        	if(file.isDirectory()) {
        		searchFile(file.getPath());
        	}
        	else {
        		if( file.getName().indexOf("H") > -1) {
        			System.out.println(file);	
        		}
        	}
        }
	}
	
	
	public static void addList(String fileRoot) {
        File rootDir = new File(fileRoot); 
        
        fileNameList = rootDir.listFiles(new FilenameFilter() { 
             public boolean accept(File dir, String name) { 
            	 if(dir.isDirectory()) {
            		 addList(dir.getPath());
            		 return false;            		 
            	 }
            	 else {
            		 System.out.println(dir);
            		 return true;
            	 }
             }
        });
	}
	
	
	
}
