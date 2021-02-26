package ch16_networking;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class NetworkEx5_URL_OutputFile {
	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		String address = "http://www.codechobo.com/book/src/javajungsuk3_src.zip";
		address = "https://github.com/castello/javajungsuk3/raw/master/java_jungsuk3e_src_20170601.zip";
				   
		int ch = 0;
		
		try {
			url = new URL(address);
			in = url.openStream();
			
			//���������͸� �о ���Ͽ� �����Ѵ�. output���� ������ ���ϼ���
			out = new FileOutputStream("javajungsuk3_src.zip");
					
			while((ch=in.read()) != -1) {
				System.out.println(ch);
				//FileOutputStream ���� write �Ѵ�.
				out.write(ch);
			}
			
			in.close();
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
