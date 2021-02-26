package http.http_server;

import java.io.IOException;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;

public class HandlerSimpleV5 implements HttpRequestHandler {

    private final String docRoot;

    public HandlerSimpleV5(final String docRoot) {
        super();
        this.docRoot = docRoot;
    }

    public void handle(
            ClassicHttpRequest request,
            ClassicHttpResponse response,
            HttpContext context) throws HttpException, IOException {

        final String method = request.getMethod();
        System.out.println(this+" method="+method);
        System.out.println(this+" path="+request.getPath());

        final String path = request.getPath();

        final HttpCoreContext coreContext = HttpCoreContext.adapt(context);
        final EndpointDetails endpoint = coreContext.getEndpointDetails();

        response.setCode(HttpStatus.SC_OK);
        final StringEntity body = new StringEntity("hello");
        response.setEntity(body);
    }

}

