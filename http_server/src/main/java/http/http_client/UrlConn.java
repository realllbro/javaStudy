package http.http_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConn {
	public static void main(String agrs[]) {
		URL url = null;
		BufferedReader input = null;
		StringBuffer sb = new StringBuffer();
		String address = "http://localhost:8090/fileservice/getFile?";
		String line ="";
		
		try {
			url = new URL(address);
			URLConnection uc = url.openConnection();
			uc.setRequestProperty(address, line);
			
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
