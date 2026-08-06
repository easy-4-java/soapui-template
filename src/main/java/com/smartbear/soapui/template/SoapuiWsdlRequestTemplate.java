/*
 * Copyright (c) 2018, Loong Wan (https://github.com/loong10k).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.smartbear.soapui.template;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.WsdlSubmit;
import com.eviware.soapui.impl.wsdl.WsdlSubmitContext;
import com.eviware.soapui.model.iface.Request.SubmitException;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapRequestHandler;
import com.smartbear.soapui.template.handler.def.SoapRequestArrayParamHandler;
import com.smartbear.soapui.template.handler.def.SoapRequestMapParamHandler;

/**
 * 
 * @author [@Loong Wan](https://github.com/loong10k)
 */
public class SoapuiWsdlRequestTemplate {

	private SoapuiWsdlTemplate wsdlTemplate;
	private SoapRequestArrayParamHandler arrayParamHandler = new SoapRequestArrayParamHandler();
	private SoapRequestMapParamHandler mapParamHandler = new SoapRequestMapParamHandler();

	public SoapuiWsdlRequestTemplate(SoapuiWsdlTemplate wsdlTemplate) {
		this.wsdlTemplate = wsdlTemplate;
	}

	public SoapuiResponse<WsdlRequest> invokeAt(String wsdlUrl, int index, Map<String, Object> params)
			throws SoapUIException, SubmitException {
		return this.invokeAt(wsdlUrl, index, false, params, null);
	}

	public SoapuiResponse<WsdlRequest> invokeAt(String wsdlUrl, int index, boolean async, Map<String, Object> params)
			throws SoapUIException, SubmitException {
		return this.invokeAt(wsdlUrl, index, async, params, null);
	}

	public SoapuiResponse<WsdlRequest> invokeAt(String wsdlUrl, int index, boolean async, Map<String, Object> params,
			SoapRequestHandler<Map<String, Object>> requestHandler) throws SoapUIException, SubmitException {

		// get desired operation
		WsdlOperation operationInst = wsdlTemplate.getOperationAt(wsdlUrl, index);

		// create a new empty request for that operation
		String requestName = "Request" + DigestUtils.md5Hex(wsdlUrl + "$operation-" + index);
		WsdlRequest request = operationInst.getRequestByName(requestName);
		if (null == request) {
			request = operationInst.addNewRequest(requestName);
		}

		// MessageExchange exchange = new WsdlResponseMessageExchange(request);
		// MessageExchange exchange = new RestResponseMessageExchange(request);
		// MessageExchange exchange = new HttpResponseMessageExchange(request);
		if (null != requestHandler) {
			requestHandler.handleRequest(operationInst, request, params);
		}

		// generate the request content from the schema
		String requestXML = mapParamHandler.handleRequest(operationInst, request, params);
		request.setRequestContent(requestXML);

		WsdlSubmitContext context = new WsdlSubmitContext(request);

		// submit the request
		WsdlSubmit<WsdlRequest> submit = request.submit(context, async);

		// wait for the response
		return new SoapuiResponse<WsdlRequest>(submit.getRequest(), submit.getResponse(),
				async ? submit.waitUntilFinished() : submit.getStatus(), submit.getError());

	}

	public SoapuiResponse<WsdlRequest> invokeAt(String wsdlUrl, int index, String[] params)
			throws SoapUIException, SubmitException {
		return this.invokeAt(wsdlUrl, index, false, params, null);
	}

	public SoapuiResponse<WsdlRequest> invokeAt(String wsdlUrl, int index, boolean async, String[] params)
			throws SoapUIException, SubmitException {
		return this.invokeAt(wsdlUrl, index, async, params, null);
	}

	public SoapuiResponse<WsdlRequest> invokeAt(String wsdlUrl, int index, boolean async, String[] params,
			SoapRequestHandler<String[]> requestHandler) throws SoapUIException, SubmitException {

		// get desired operation
		WsdlOperation operationInst = wsdlTemplate.getOperationAt(wsdlUrl, index);
		// create a new empty request for that operation
		String requestName = "Request" + DigestUtils.md5Hex(wsdlUrl + "$operation-" + index);
		WsdlRequest request = operationInst.getRequestByName(requestName);
		if (null == request) {
			request = operationInst.addNewRequest(requestName);
		}
		if (null != requestHandler) {
			requestHandler.handleRequest(operationInst, request, params);
		}
		// MessageExchange exchange = new WsdlResponseMessageExchange(request);
		// MessageExchange exchange = new RestResponseMessageExchange(request);
		// MessageExchange exchange = new HttpResponseMessageExchange(request);

		// generate the request content from the schema
		String requestXML = arrayParamHandler.handleRequest(operationInst, request, params);
		request.setRequestContent(requestXML);

		WsdlSubmitContext context = new WsdlSubmitContext(request);

		// submit the request
		WsdlSubmit<WsdlRequest> submit = request.submit(context, async);

		// wait for the response
		return new SoapuiResponse<WsdlRequest>(submit.getRequest(), submit.getResponse(),
				async ? submit.waitUntilFinished() : submit.getStatus(), submit.getError());

	}

	public SoapuiResponse<WsdlRequest> invokeByName(String wsdlUrl, String operationName, Map<String, Object> params)
			throws SoapUIException, SubmitException {
		return this.invokeByName(wsdlUrl, operationName, false, params, null);
	}
	
	public SoapuiResponse<WsdlRequest> invokeByName(String wsdlUrl, String operationName, boolean async,
			Map<String, Object> params) throws SoapUIException, SubmitException {
		return this.invokeByName(wsdlUrl, operationName, async, params, null);
	}

	public SoapuiResponse<WsdlRequest> invokeByName(String wsdlUrl, String operationName, boolean async,
			Map<String, Object> params, SoapRequestHandler<Map<String, Object>> requestHandler)
			throws SoapUIException, SubmitException {

		// get desired operation
		WsdlOperation operationInst = wsdlTemplate.getOperationByName(wsdlUrl, operationName);

		// create a new empty request for that operation
		String requestName = "Request" + DigestUtils.md5Hex(wsdlUrl + "$" + operationName);
		WsdlRequest request = operationInst.getRequestByName(requestName);
		if (null == request) {
			request = operationInst.addNewRequest(requestName);
		}
		if (null != requestHandler) {
			requestHandler.handleRequest(operationInst, request, params);
		}
		// generate the request content from the schema
		String requestXML = mapParamHandler.handleRequest(operationInst, request, params);
		request.setRequestContent(requestXML);

		WsdlSubmitContext context = new WsdlSubmitContext(request);

		// submit the request
		WsdlSubmit<WsdlRequest> submit = request.submit(context, async);
		
		// wait for the response
		return new SoapuiResponse<WsdlRequest>(submit.getRequest(), submit.getResponse(),
				async ? submit.waitUntilFinished() : submit.getStatus(), submit.getError());

	}

	public SoapuiResponse<WsdlRequest> invokeByName(String wsdlUrl, String operationName, String[] params)
			throws SoapUIException, SubmitException {
		return this.invokeByName(wsdlUrl, operationName, false, params, null);
	}
	
	public SoapuiResponse<WsdlRequest> invokeByName(String wsdlUrl, String operationName, boolean async,
			String[] params) throws SoapUIException, SubmitException {
		return this.invokeByName(wsdlUrl, operationName, async, params, null);
	}
	
	public SoapuiResponse<WsdlRequest> invokeByName(String wsdlUrl, String operationName, boolean async,
			String[] params, SoapRequestHandler<String[]> requestHandler) throws SoapUIException, SubmitException {

		// get desired operation
		WsdlOperation operationInst = wsdlTemplate.getOperationByName(wsdlUrl, operationName);

		// create a new empty request for that operation
		String requestName = "Request" + DigestUtils.md5Hex(wsdlUrl + "$" + operationName);
		WsdlRequest request = operationInst.getRequestByName(requestName);
		if (null == request) {
			request = operationInst.addNewRequest(requestName);
		}
		if (null != requestHandler) {
			requestHandler.handleRequest(operationInst, request, params);
		}
		// generate the request content from the schema
		String requestXML = arrayParamHandler.handleRequest(operationInst, request, params);
		request.setRequestContent(requestXML);

		// WsdlRequestConfig config = new WsdlRequestConfigImpl(null);
		// request.setConfig(config);

		WsdlSubmitContext context = new WsdlSubmitContext(request);

		// submit the request
		WsdlSubmit<WsdlRequest> submit = request.submit(context, async);

		// wait for the response
		return new SoapuiResponse<WsdlRequest>(submit.getRequest(), submit.getResponse(),
				async ? submit.waitUntilFinished() : submit.getStatus(), submit.getError());

	}

}
