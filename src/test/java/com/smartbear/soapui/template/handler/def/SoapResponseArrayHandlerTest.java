package com.smartbear.soapui.template.handler.def;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Attachment;
import com.eviware.soapui.model.iface.Request;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.support.types.StringToStringsMap;

public class SoapResponseArrayHandlerTest {

    @Test
    public void shouldParseResponseToArray() throws SoapUIException {
        String responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" +
                "  <soap:Body>\r\n" +
                "    <getWeatherbyCityNameResponse xmlns=\"http://WebXml.com.cn/\">\r\n" +
                "      <getWeatherbyCityNameResult>\r\n" +
                "        <string>Zhejiang</string>\r\n" +
                "        <string>Hangzhou</string>\r\n" +
                "      </getWeatherbyCityNameResult>\r\n" +
                "    </getWeatherbyCityNameResponse>\r\n" +
                "  </soap:Body>\r\n" +
                "</soap:Envelope>";

        Response response = new Response() {
            @Override public String getContentAsString() { return responseBody; }
            @Override public String getContentType() { return "text/xml"; }
            @Override public long getContentLength() { return responseBody.length(); }
            @Override public Request getRequest() { return null; }
            @Override public String getRequestContent() { return null; }
            @Override public long getTimeTaken() { return 0; }
            @Override public Attachment[] getAttachments() { return new Attachment[0]; }
            @Override public Attachment[] getAttachmentsForPart(String partName) { return new Attachment[0]; }
            @Override public StringToStringsMap getRequestHeaders() { return new StringToStringsMap(); }
            @Override public StringToStringsMap getResponseHeaders() { return new StringToStringsMap(); }
            @Override public long getTimestamp() { return 0; }
            @Override public byte[] getRawRequestData() { return new byte[0]; }
            @Override public byte[] getRawResponseData() { return new byte[0]; }
            @Override public String getContentAsXml() { return responseBody; }
            @Override public String getProperty(String name) { return null; }
            @Override public void setProperty(String name, String value) {}
            @Override public String[] getPropertyNames() { return new String[0]; }
        };

        SoapResponseArrayHandler handler = new SoapResponseArrayHandler();
        String[] result = handler.handleResponse(response, SoapVersion.Soap11);
        assertNotNull(result);
        assertTrue(result.length > 0);
    }
}
