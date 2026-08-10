package com.smartbear.soapui.template.handler.def;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapResponseHandler;

/**
 * Response handler that returns the SOAP response content as an XML string.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see SoapResponseHandler
 */
public class SoapXMLResponseHandler implements SoapResponseHandler<String> {

	/**
	 * {@inheritDoc}
	 *
	 * @return the response content as an XML string
	 */
	@Override
	public String handleResponse(Response response, SoapVersion version) throws SoapUIException {
		// 响应内容
		return response.getContentAsXml();
	}
}

 
