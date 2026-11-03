package com.smartbear.soapui.template;

import com.sun.net.httpserver.HttpServer;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/** Serves real test WSDL imports and a SOAP response without a public service. */
final class LocalWsdlServer implements AutoCloseable {
    private final HttpServer server;

    LocalWsdlServer() throws Exception {
        server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        server.createContext("/wsdls/", exchange -> {
            String path = exchange.getRequestURI().getPath();
            try (InputStream resource = LocalWsdlServer.class.getResourceAsStream(path)) {
                if (resource == null) {
                    exchange.sendResponseHeaders(404, -1);
                    return;
                }
                byte[] body = resource.readAllBytes();
                if (path.endsWith("/TestService.wsdl")) {
                    String wsdl = new String(body, StandardCharsets.UTF_8);
                    body = wsdl.replace("http://www.eviware.com/webservices/TestService", endpoint())
                            .getBytes(StandardCharsets.UTF_8);
                }
                exchange.getResponseHeaders().set("Content-Type", "application/xml; charset=UTF-8");
                exchange.sendResponseHeaders(200, body.length);
                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(body);
                }
            } finally {
                exchange.close();
            }
        });
        server.createContext("/soap", exchange -> {
            byte[] body = ("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                    + "<soap:Body><PingResponse xmlns=\"http://schemas.eviware.com/TestService/v1/\">"
                    + "<PingResult>true</PingResult></PingResponse></soap:Body></soap:Envelope>")
                    .getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/xml; charset=UTF-8");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(body);
            } finally {
                exchange.close();
            }
        });
        server.start();
    }

    String wsdlUrl() {
        return "http://127.0.0.1:" + server.getAddress().getPort() + "/wsdls/test1/TestService.wsdl";
    }

    private String endpoint() {
        return "http://127.0.0.1:" + server.getAddress().getPort() + "/soap";
    }

    @Override
    public void close() {
        server.stop(0);
    }
}
