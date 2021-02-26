package ch16_networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx4_URL_InputStream {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		address = "http://localhost:8090/fileservice/getFile?";		
		String line = "";
		
		try {
			
			url = new URL(address);
			/* openStream()�� openConnection()�� ȣ���ؼ� URLConnection�� ���� ���� ���⿡ �ٽ� getInputStream()�� ȣ���� �Ͱ� ����
			 * inputStream in = url.openStream() => 	URLConnection conn = url.openConnection();
			 * 											InputStream in = conn.getInputStream();    �� ���� ���̰� ����..
			 * */
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line=input.readLine())!=null) {
				System.out.println(line);
			}
			input.close();
			
		}catch(MalformedURLException ue) {			
			/*URL �� ��ȿ���� ������ */
			ue.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
