package com.smartbear.soapui.template.handler.def;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapResponseHandler;

/**
 * Response handler that extracts the SOAP response content as a plain text string.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see SoapResponseHandler
 */
public class SoapPlaintextResponseHandler implements SoapResponseHandler<String> {

	/**
	 * {@inheritDoc}
	 *
	 * @return the response content as a plain text string
	 */
	@Override
	public String handleResponse(Response response, SoapVersion version) throws SoapUIException {
		return response.getContentAsString();
	}

}

 
