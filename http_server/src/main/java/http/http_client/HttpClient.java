package http.http_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public class HttpClient {
	
	HttpURLConnection httpURLConn;
	URL url;
	
	private String execute(String reqUrl, String httpMethod, String requestBody, Map<String, String> reqProperty)throws Exception{
		
		try {
			openConnection(reqUrl,httpMethod,requestBody, reqProperty);
			
			if(null != requestBody) {
				sendRequestBody(requestBody);	
			}
			return receiveResponseBody();
			
		}catch(Exception e)	{
			throw e;
		}finally {
			closeConnection();
		}
	}
	
	private void openConnection(String reqUrl, String httpMethod, String requestBody, Map<String, String> reqProperty) throws MalformedURLException, IOException, ProtocolException, Exception {
		//URL address
		url = new URL(reqUrl);
		
		//HttpURLConnection
		httpURLConn = (HttpURLConnection)url.openConnection();
		httpURLConn.setDoOutput(true);
		
		//Header 세팅
		httpURLConn.setRequestMethod(httpMethod);
		// 클라이언트가 처리 가능한 미디어 타입
		httpURLConn.setRequestProperty("Accept", "application/json");	
		// 본문의 미디어 타입(MIME) ex) application/json, text/html
		httpURLConn.setRequestProperty("Content-Type", "application/json");
		
		// 파라메터로 넘어온게 있으면 요청값으로 set
		if(null != reqProperty) {
			for(String key : reqProperty.keySet()) {
				httpURLConn.setRequestProperty(key, reqProperty.get(key));	
			}
		}
		
	}	
	
	private void sendRequestBody(String i_strBody)throws Exception{
		
		OutputStream os = httpURLConn.getOutputStream();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
		
		try {
			writer.write(i_strBody);
			writer.flush();
			
		}catch(Exception e)	{
			throw e;			
		}finally {
			writer.close();
			os.close();
		}
	}	
	
	private String receiveResponseBody()throws UnsupportedEncodingException, IOException{
		
		int resCode = httpURLConn.getResponseCode();
		
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		StringBuffer sb = new StringBuffer();
		
		System.out.println(resCode);
		
		//성공
		if(resCode >= 200 && resCode < 300) {
			inputStream = httpURLConn.getInputStream();
		}
		//오류 
		else {
			inputStream = httpURLConn.getErrorStream();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		
		String line = "";
		
		while((line=br.readLine())!=null) {
			sb.append(line);
		}			
		return sb.toString();
	}	
	
	private void closeConnection() {
		try {
			httpURLConn.disconnect();
		}catch(Exception e) {}
	}

	public static void main(String[] args) {
		
//		port 다를때 java.net.ConnectException: Connection refused: connect		

		try {
			String address = "http://localhost:8090/fileservice/getFile?";
			HttpClient httpClient = new HttpClient();
			System.out.println(httpClient.execute(address,"GET","",null));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	
}
