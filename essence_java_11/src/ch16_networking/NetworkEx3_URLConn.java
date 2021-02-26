package ch16_networking;

import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx3_URLConn {
	/*
		void addRequestProperty (String key,String value)
			=> ������ Ű�� ���� RequestProperty�� �߰��Ѵ�. ������ ���� Ű�� �־ ���� ����� �ʴ´�.
		
		void connect()
			=> URL�� ������ �ڿ��� ���� ��ſ����� ����.
		
		boolean getAllowUserlnteraction()
			=> Userlnteraction�� ��뿩�θ� ��ȯ�Ѵ�.
		
		int getConnectTimeout()
			=> ��������ð��� õ���� ���ʷ� ��ȯ�Ѵ�.
		
		Object getContent()
			=> content��ü�� ��ȯ�Ѵ�.
		
		Object getContent (Class[ ] classes)
			=> content��ü�� ��ȯ�Ѵ�.
		
		String getContentEncoding()
			=> content�� ���ڵ��� ��ȯ�Ѵ�.
		
		int getContentLength()			
			=> content�� ũ�⸦ ��ȯ�Ѵ�.
		
		String getContentType()			
			=> content�� type�� ��ȯ�Ѵ�.	
		
		long getDate()			
			=> ��� (header)�� date�ʵ��� ���� ��ȯ�Ѵ�.

		boolean getDefaultAllowUserlnteraction()
			=> defaultAllowUserlnteraction�� ���� ��ȯ�Ѵ�.
			
		String getDefaultRequestProperty (String key)			
			=> RequestProperty���� ������ Ű�� ����Ʈ���� ��´�.
		
		boolean getDefaultUseCaches()
			=> useCache�� ����Ʈ ���� ��´�.
		
		boolean getDolnput()
			=> dolnput�ʵ尪�� ��´�.
		
		boolean getDoOutput()
			=> doOutput�ʵ尪�� ��´�.
		
		long getExpiration()
			=> �ڿ� (URL)�� �������ڸ� ��´�.(õ���� ���ʴ���)
		
		FileNameMap getFileNameMap()
			=> FileNameMap (mimetable)�� ��ȯ�Ѵ�.
		
		String getHeaderField (int n)
			=> ����� n��° �ʵ带 �о�´�.
		
		String getHeaderField (String name)
			=> ������� ������ �̸��� �ʵ带 �о�´�.
		
		long getHeaderFieldDate (String name,long Default)
			=> ������ �ʵ��� ���� ��¥������ ��ȯ�Ͽ� ��ȯ�Ѵ�. �ʵ尪�� ��ȿ���� ���� ��� Default���� ��ȯ�Ѵ�.
		
		int getHeaderFieldlnt (String name,int Default)
			=> ������ �ʵ��� ���� ���������� ��ȯ�Ͽ� ��ȯ�Ѵ�. �ʵ尪�� ��ȿ���� ���� ��� Default���� ��ȯ�Ѵ�.
		
		String getHeaderFieldKey (int n)
			=> ����� n��° �ʵ带 �о�´�.
		
		Map getHeaderFields()
			=> ����� ��� �ʵ�� ���� ����� Map�� ��ȯ�Ѵ�.
		
		long getlfModifiedSince()
			=> ifModifiedSince (���濩��)�ʵ��� ���� ��ȯ�Ѵ�.
		
		InputStream getinputStream()
			=> URLConnetion���� InputStream�� ��ȯ�Ѵ�.
		
		long getLastModified()
			=> LastModified (����������) �ʵ��� ���� ��ȯ�Ѵ�.
		
		OutputStream getOutputStream( )
			=> URLConnetion���� OutputStream�� ��ȯ�Ѵ�
		
		Permission getPermission()
			=> Permission (������)�� ��ȯ�Ѵ�.
		
		int getReadTimeout()
			=> �б����ѽð��� ���� ��ȯ�Ѵ�.(õ���� ����)
		
		Map getRequestProperties()
			=> RequestProperties�� ����� (Ű, ��)�� Map���� ��ȯ
		
		String getRequestProperty (String key)
			=> RequestProperty���� ������ Ű�� ���� ��ȯ�Ѵ�.
		
		URL getURL()
			=> URLConnection�� URL�� ��ȯ�Ѵ�.
		
		boolean getUseCaches()
			=> ĳ���� ��뿩�θ� ��ȯ�Ѵ�.
		
		String guessContentTypeFromName(String fname)
			=> ������ ���� (fname)�� content-type�� �����Ͽ� ��ȯ�Ѵ�.
		
		String guessContentTypeFromStream(InputStream is)
			=> ������ �Է½�Ʈ�� (is)�� content-type�� �����Ͽ� ��ȯ�Ѵ�.
		
		void setAllowUserinteraction(boolean allowuserinteraction)
			=> UserInteraction�� ��뿩�θ� �����Ѵ�.
		
		void setConnectTimeout (int timeout)
			=> ��������ð��� �����Ѵ�.
		
		void setContentHandlerFactory(ContentHandlerFactory fac)
			=> ContentHandlerFactory�� �����Ѵ�.
		
		void setDefaultAllowUserlnteraction(boolean defaultallowuserinteraction)
			=> Userinteraction��뿩���� �⺻���� �����Ѵ�.
		
		void setDefaultRequestProperty(String key, String value)
			=> RequestProperty�� �⺻ Ű�� (key-pair)�� �����Ѵ�.
		
		void setDefaultUseCaches (boolean defaultusecaches)
			=> ĳ�� ��뿩���� �⺻���� �����Ѵ�.
		
		void getDoInput (boolean doinput)
			=> Dolnput�ʵ��� ���� �����Ѵ�.
			   InputStream ���� POST �����͸� �Ѱ� �ְڴٴ� �ɼ�?
		
		void setDoOutput (boolean dooutput)
			=> DoOutput�ʵ��� ���� �����Ѵ�. BODY�� ������ �ѱ涧 �ɼ� false �� �Ȱ���.
			   OutputStream���� post �����͸� �Ѱ��ְڴٴ� �ɼ�?
		
		FileNameMap�� �����Ѵ�.
			=> void setFileNameMap (FileNameMap map)
		
		void setlfModifiedSince (long ifmodifiedsince)
			=> ModifiedSince�ʵ��� ���� �����Ѵ�.
		
		void setReadTimeout (int timeout)
			=> �б����ѽð��� �����Ѵ�. (õ���� ����)
		
		void setRequestProperty (String key,String value)
			=> setRequestProperty (key, value) �� �����Ѵ�.
		
		void setUseCaches (boolean usecaches)
			=> ĳ���� ��뿩�θ� �����Ѵ�.
	 */

	public static void main(String[] args) {
		URL url = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		address = "http://localhost:8090/fileservice/getFile?";			
		
		try {
			url = new URL(address);
			/*URL���� ��ſ����� ��Ÿ���� Ŭ������ �ֻ��� Ŭ���� ������ HttpURLConnection, JarURLConnection �� ������ 
			 URL ���������� http �������� �̶�� openConnection()�� Http URLConnection�� ��ȯ�Ѵ�*/
			URLConnection conn = url.openConnection();
			
			System.out.println("conn.toString() : "+ conn.toString());
			System.out.println("conn.getAllowUserInteraction() : "+ conn.getAllowUserInteraction());
			System.out.println("conn.getConnectTimeout() : "+ conn.getConnectTimeout());
			System.out.println("conn.getContent() : "+ conn.getContent());
			System.out.println("conn.getContentEncoding() : "+ conn.getContentEncoding());
			System.out.println("conn.getContentLength() : "+ conn.getContentLength());
			System.out.println("conn.getContentType() : "+ conn.getContentType());
			System.out.println("conn.getDate() : "+ conn.getDate());
			System.out.println("conn.getDefaultAllowUserInteraction() : "+ conn.getDefaultAllowUserInteraction());
			System.out.println("conn.getDefaultUseCaches() : "+ conn.getDefaultUseCaches());
			System.out.println("conn.getDoInput() : "+ conn.getDoInput());			
			System.out.println("conn.getDoOutput() : "+ conn.getDoOutput());
			System.out.println("conn.getExpiration() : "+ conn.getExpiration());
			System.out.println("conn.getHeaderFields() : "+ conn.getHeaderFields());
			System.out.println("conn.getIfModifiedSince() : "+ conn.getIfModifiedSince());
			System.out.println("conn.getLastModified() : "+ conn.getLastModified());
			System.out.println("conn.getReadTimeout() : "+ conn.getReadTimeout());
			System.out.println("conn.getURL() : "+ conn.getURL());
			System.out.println("conn.getUseCaches() : "+ conn.getUseCaches());
			
/*
	conn.toString() : sun.net.www.protocol.http.HttpURLConnection:http://localhost:8090/fileservice/getFile?
	conn.getAllowUserInteraction() : false
	conn.getConnectTimeout() : 0
	conn.getContent() : sun.net.www.content.text.PlainTextInputStream@50f8360d
	conn.getContentEncoding() : null
	conn.getContentLength() : 9246
	conn.getContentType() : text/plain; charset=ISO-8859-1
	conn.getDate() : 1613554752000
	conn.getDefaultAllowUserInteraction() : false
	conn.getDefaultUseCaches() : true
	conn.getDoInput() : true
	conn.getDoOutput() : false
	conn.getExpiration() : 0
	conn.getHeaderFields() : {null=[HTTP/1.1 200 OK], Server=[Apache-HttpCore/5.0.3 (Java/15.0.1)], Connection=[keep-alive], Content-Length=[9246], Date=[Wed, 17 Feb 2021 09:39:12 GMT], Content-Type=[text/plain; charset=ISO-8859-1]}
	conn.getIfModifiedSince() : 0
	conn.getLastModified() : 0
	conn.getReadTimeout() : 0
	conn.getURL() : http://localhost:8090/fileservice/getFile?
	conn.getUseCaches() : true			
 */
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

