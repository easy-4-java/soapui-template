package com.smartbear.soapui.template.handler;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;

public class AbstractResponseHandlerTest {

    private static class TestResponseHandler extends AbstractResponseHandler<String> {
        public TestResponseHandler(HttpClientContext context, String charset) {
            super(context, charset);
        }

        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            return "test";
        }
    }

    @Test
    public void shouldSetAndGetContext() {
        HttpClientContext context = HttpClientContext.create();
        TestResponseHandler handler = new TestResponseHandler(context, "UTF-8");
        assertSame(context, handler.getContext());

        HttpClientContext newContext = HttpClientContext.create();
        handler.setContext(newContext);
        assertSame(newContext, handler.getContext());
    }

    @Test
    public void shouldSetAndGetCharset() {
        HttpClientContext context = HttpClientContext.create();
        TestResponseHandler handler = new TestResponseHandler(context, "UTF-8");
        assertEquals("UTF-8", handler.getCharset());

        handler.setCharset("GBK");
        assertEquals("GBK", handler.getCharset());
    }

    @Test
    public void shouldHandleResponse() throws Exception {
        HttpClientContext context = HttpClientContext.create();
        TestResponseHandler handler = new TestResponseHandler(context, "UTF-8");
        String result = handler.handleResponse(null);
        assertEquals("test", result);
    }

    @Test
    public void shouldImplementResponseHandlerInterface() {
        HttpClientContext context = HttpClientContext.create();
        TestResponseHandler handler = new TestResponseHandler(context, "UTF-8");
        assertTrue(handler instanceof ResponseHandler);
    }
}
