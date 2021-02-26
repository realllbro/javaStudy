package http.http_server;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.SocketConfig;

/**
 * Example of embedded HTTP/1.1 file server using classic I/O.
 */
public class HttpServerSimple5 {
	
	public static void main( String[] args) throws Exception {
		// Document root directory
		String docRoot = "c:\\temp";
		int port = 8095;
		if (args.length >= 2) {
			port = Integer.parseInt(args[1]);
		}
		
		SocketConfig socketConfig = SocketConfig.custom()
				.setSoTimeout(15, TimeUnit.SECONDS)
				.setTcpNoDelay(true)
				.build();
		
		HttpServer server = ServerBootstrap.bootstrap()
				.setListenerPort(port)
				.setSocketConfig(socketConfig)
				.register("/fileservice/getFile", new FileHandler())				
				.register("/fileservice/list", new HandlerSimpleV5(docRoot))
				.register("fileservice/name", new HandlerForFileV5(docRoot))
				.create();
		System.out.println("시작전");		
		server.start();
		System.out.println("시작후");
		
	}
	
}
