package ch16_networking;

import java.net.URL;

public class NetworkEx2_URL {
	
/*	
	URL (String spec)
		=> ������ ���ڿ� ������ URL��ü�� �����Ѵ�.
		
	URL (String protocol, String host, String file)
		=> ������ ������ ������ URL��ü�� �����Ѵ�.
		
	URL (String protocol, String host, int port, String file)
		=> 	������ ������ ������ URL��ü�� �����Ѵ�.
		
	String getAuthority()
		=> ȣ��Ʈ��� ��Ʈ�� ���ڿ��� ��ȯ�Ѵ�.
		
	Object getContent()
		=> URL�� Content��ü�� ��ȯ�Ѵ�.
		
	Object getContent (Class[ ] classes)
		=> URL�� Content��ü�� ��ȯ�Ѵ�.
		
	int getDefaultPort()
		=> URL�� �⺻ ��Ʈ�� ��ȯ�Ѵ�.(http�� 80)
		
	String getFile( )
		=> ���ϸ��� ��ȯ�Ѵ�.
		
	String getHost( )
		=> ȣ��Ʈ���� ��ȯ�Ѵ�.
		
	String getPath()
		=> ��θ��� ��ȯ�Ѵ�.
		
	int getPort()
		=> ��Ʈ�� ��ȯ�Ѵ�.
		
	String getProtocol()
		=> ���������� ��ȯ�Ѵ�.
		
	String getQuery()
		=> ������ ��ȯ�Ѵ�.
		
	String getRef( )
		=> ����(anchor)�� ��ȯ�Ѵ�.
		
	String getUserinfo(()
		=> ����������� ��ȯ�Ѵ�.
		
	URLConnection openConnection()
		=> URL�� ����� URLConnection�� ��´�.
		
	URLConnection openConnection(Proxy proxy)
		=> URL�� ����� URLConnection�� ��´�.
		
	InputStream openStream()	
		=> URL�� ����� URLConnection�� InputStream �� ��´�. 
		
	boolean sameFile(URL other)
		=> �� URL�� ���� ���� ������ �˷��ش�.
		
	void set(String protocol, String host, int port, String file, String ref)
		=> URL��ü�� �Ӽ��� ������ ������ �����Ѵ�.
		
	void set(String protocol, String host,int port, String authority, String userlnfo,String path, String query, String ref)
		=> URL��ü�� �Ӽ��� ������ ������ �����Ѵ�.
		
	String toExternalForm()
		=> URL�� ���ڿ��� ��ȯ�Ͽ� ��ȯ�Ѵ�.
		
	URI toURI()
		=> 	URL�� URI�� ��ȯ�Ͽ� ��ȯ�Ѵ�.
*/	
	
	public static void main(String[] args) {
		try {
			//URL url = new URL("http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1");
			URL url = new URL("http://localhost:8090/fileservice/getFile?");			
			
			System.out.println("url.getAuthority() : "+url.getAuthority());
			System.out.println("url.getContent() : "+url.getContent());
			System.out.println("url.getDefaultPort() : "+url.getDefaultPort());
			System.out.println("url.getPort() : "+url.getPort());
			System.out.println("url.getFile() : "+url.getFile());
			System.out.println("url.getHost() : "+url.getHost());
			System.out.println("url.getPath() : "+url.getPath());
			System.out.println("url.getProtocol() : "+url.getProtocol());
			System.out.println("url.getQuery() : "+url.getQuery());
			System.out.println("url.getRef() : "+url.getRef());
			System.out.println("url.getUserInfo() : "+url.getUserInfo());
			System.out.println("url.toExternalForm() : "+url.toExternalForm());
			System.out.println("url.toURI() : "+url.toURI());
			
/*
	url.getAuthority() : localhost:8090
	url.getContent() : sun.net.www.content.text.PlainTextInputStream@50f8360d
	url.getDefaultPort() : 80
	url.getPort() : 8090
	url.getFile() : /fileservice/getFile?
	url.getHost() : localhost
	url.getPath() : /fileservice/getFile
	url.getProtocol() : http
	url.getQuery() : 
	url.getRef() : null
	url.getUserInfo() : null
	url.toExternalForm() : http://localhost:8090/fileservice/getFile?
	url.toURI() : http://localhost:8090/fileservice/getFile?
 */
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
