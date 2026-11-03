/*
 * Copyright 2004-2014 SmartBear Software
 *
 * Licensed under the EUPL, Version 1.1 or - as soon as they will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the Licence for the specific language governing permissions and limitations
 * under the Licence.
*/

package com.smartbear.soapui.template.wsdl;

import static org.junit.Assert.assertNotNull;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import com.sun.net.httpserver.HttpServer;

import org.junit.Before;
import org.junit.Test;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.WsdlSubmit;
import com.eviware.soapui.impl.wsdl.WsdlSubmitContext;
import com.eviware.soapui.model.iface.Response;

/**
 * SoapUI 官方示例
 */
public class WsdlRequestTestCaseTest {

	private WsdlProject project;
	
	@Before
	public void setup() throws Exception {
		// create new project
       project = new WsdlProject();
       project.setCacheDefinitions(true);
	}
	
    @Test
    public void testRequest() throws Exception {
        runRequest();
        setup();
        runRequest();
    }

    private void runRequest() throws Exception {

        // import amazon wsdl
        WsdlInterface[] ifaces = WsdlInterfaceFactory.importWsdl(project, WsdlRequestTestCaseTest.class.getResource("/wsdls/test1/TestService.wsdl").toExternalForm(),
                true);

        HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        server.createContext("/soap", exchange -> {
            byte[] body = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body/></soap:Envelope>".getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/xml; charset=UTF-8");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(body);
            } finally {
                exchange.close();
            }
        });
        server.start();
        try {
        for (WsdlInterface iface : ifaces) {
		
	        // get "Help" operation
	        WsdlOperation operation = (WsdlOperation) iface.getOperationByName("Ping");
	
	        // create a new empty request for that operation
	        WsdlRequest request = operation.addNewRequest("My request");
	
	        // generate the request content from the schema
	        request.setRequestContent(operation.createRequest(true));
	
	        // submit the request
	        request.setEndpoint("http://127.0.0.1:" + server.getAddress().getPort() + "/soap");
        WsdlSubmit submit = (WsdlSubmit) request.submit(new WsdlSubmitContext(request), false);
	
	        // wait for the response
	        Response response = submit.getResponse();
	
	        // print the response
	        String content = response.getContentAsString();
	        //System.out.println( content );
	        assertNotNull(content);
	        
	        System.err.println("=============================================================");
        }
        } finally {
            server.stop(0);
        }
    }
}