package http.http_server;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

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

public class HandlerForFileV5 implements HttpRequestHandler {

    private String docRoot;

    public HandlerForFileV5(String docRoot) {
        super();
        this.docRoot = docRoot;
    }

    public void handle(
            ClassicHttpRequest request,
            ClassicHttpResponse response,
            HttpContext context) throws HttpException, IOException {

        String method = request.getMethod();
        System.out.println("method="+method);
        System.out.println("path="+request.getPath());

        if (!Method.GET.isSame(method) && !Method.HEAD.isSame(method) && !Method.POST.isSame(method)) {
            throw new MethodNotSupportedException(method + " method not supported");
        }
        String path = request.getPath();

        HttpEntity incomingEntity = request.getEntity();
        if (incomingEntity != null) {
            byte[] entityContent = EntityUtils.toByteArray(incomingEntity);
            System.out.println("Incoming incomingEntity content (bytes): " + entityContent.length);
        }

        File file = new File(this.docRoot, URLDecoder.decode(path, "UTF-8"));
        if (!file.exists()) {

            response.setCode(HttpStatus.SC_NOT_FOUND);
            String msg = "File " + file.getPath() + " not found";
            StringEntity outgoingEntity = new StringEntity(
                    "<html><body><h1>" + msg + "</h1></body></html>",
                    ContentType.create("text/html", "UTF-8"));
            response.setEntity(outgoingEntity);
            System.out.println(msg);

        } else if (!file.canRead() || file.isDirectory()) {

            response.setCode(HttpStatus.SC_FORBIDDEN);
            String msg = "Cannot read file " + file.getPath();
            StringEntity outgoingEntity = new StringEntity(
                    "<html><body><h1>" + msg + "</h1></body></html>",
                    ContentType.create("text/html", "UTF-8"));
            response.setEntity(outgoingEntity);
            System.out.println(msg);

        } else {
            HttpCoreContext coreContext = HttpCoreContext.adapt(context);
            EndpointDetails endpoint = coreContext.getEndpointDetails();
            response.setCode(HttpStatus.SC_OK);
            FileEntity body = new FileEntity(file, ContentType.create("text/html", (Charset) null));
            response.setEntity(body);
            System.out.println(endpoint + ": serving file " + file.getPath());
        }
    }

}

