package http.http_server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.MethodNotSupportedException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FileHandler implements HttpRequestHandler {

    private String fileRoot = "C:/devbro/original src/src/main/java/com/kbstar/sqc/base/controller/AdminSqlRunnerController.java";
    
    public FileHandler(){}

    public void handle(
            ClassicHttpRequest request,
            ClassicHttpResponse response,
            HttpContext context) throws HttpException, IOException {

    	try {
    		String uriQuery = request.getUri().getQuery();
    		System.out.println("uri.getQuery() : "+uriQuery);
    		
    		HashMap<String, String> paramMap = new HashMap<String, String>();
    		
    		for(String and : uriQuery.split("&")) {
    			String[] param = and.split("=");
    			
    			if(param[1] != null) {
    				paramMap.put(param[0], param[1]);
    				
    			}else {
    				paramMap.put(param[0], "");
    			}
    		}
    		
	        String method = request.getMethod();
	        System.out.println("method="+method);
	        System.out.println("path="+request.getPath());
	
	        if (!Method.GET.isSame(method) && !Method.HEAD.isSame(method) && !Method.POST.isSame(method)) {
	            throw new MethodNotSupportedException(method + " method not supported");
	        }
	        String path = request.getPath();
	
	        HttpEntity incomingEntity = request.getEntity();
	        
	        System.out.println("incomingEntity > "+incomingEntity);
	        
	        if (incomingEntity != null) {
	            byte[] entityContent = EntityUtils.toByteArray(incomingEntity);
	            System.out.println("Incoming incomingEntity content (bytes): " + entityContent.length);
	        }
	
	        //File file = new File(this.fileRoot, URLDecoder.decode(path, "UTF-8"));
	        //File file = new File(paramMap.get("path")+"/"+paramMap.get("filename"));
	        File file = new File(paramMap.get("fileFullPath"));	        
	      
	        if (!file.exists()) {
	
	            response.setCode(HttpStatus.SC_NOT_FOUND);
	            String msg = "File " + file.getPath() + " not found";
	            StringEntity outgoingEntity = new StringEntity(
	                    "<html><body><h1>" + msg + "</h1></body></html>",
	                    ContentType.create("text/html", "UTF-8"));
	            response.setEntity(outgoingEntity);
	            System.out.println(msg);
	
	        }else if (!file.canRead() || file.isDirectory()) {
	
	            response.setCode(HttpStatus.SC_FORBIDDEN);
	            String msg = "Cannot read file " + file.getPath();
	            StringEntity outgoingEntity = new StringEntity(
	                    "<html><body><h1>" + msg + "</h1></body></html>",
	                    ContentType.create("text/html", "UTF-8"));
	            response.setEntity(outgoingEntity);
	            System.out.println(msg);
	
	        }else {
	            HttpCoreContext coreContext = HttpCoreContext.adapt(context);
	            EndpointDetails endpoint = coreContext.getEndpointDetails();
	            response.setCode(HttpStatus.SC_OK);
	            FileEntity body = new FileEntity(file, ContentType.create("text/html", (Charset) null));
	            
	            //구현
	    		HashMap<String, String> rtnMap = new HashMap();
	    		
	            FileInputStream fis = new FileInputStream(file);
	            //InputStreamReader isr = new InputStreamReader(fis,serverCharset);
	            InputStreamReader isr = new InputStreamReader(fis);            
	            BufferedReader br = new BufferedReader(isr);
				
				StringBuffer sb = new StringBuffer();
				
				int i = 1;
				
				while(br.ready()){
					// <,> 처리 및 브라우저에서 탭이 8자리로 표현되는 현상이 있어서 화이트스페이스4개로 치환
					String lineStr = br.readLine();
					if(lineStr != null){ 
						lineStr = lineStr.replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\t","    ");
					}
					sb.append("\n"+i+"\t"+lineStr);
					i++;
				}
				sb.deleteCharAt(0);
				
				SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				simpleDate.format(file.lastModified());
				
				String hostName = "";//
				
				//오류
				rtnMap.put("error","success");
				
				//파일최종변경시간
				rtnMap.put("fileMdTime",simpleDate.format(file.lastModified()));
				
				//호스트명
				rtnMap.put("fileHostNmae",hostName);
				
				//파일명
				//rtnMap.put("fileNm",fileNm);
				
				//파일내용
				rtnMap.put("fileContents",sb.toString());            
	            
				ObjectMapper objectMapper = new ObjectMapper();
				//org.apache.hc.core5.http.io.entity.StringEntity  strEntity = rtnMap.toString();
	
				StringEntity strEntity = new StringEntity(objectMapper.writeValueAsString(rtnMap),ContentType.APPLICATION_JSON);
	            response.setEntity(strEntity);
	            System.out.println(endpoint + ": serving file " + strEntity);
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}	        
    }

}

