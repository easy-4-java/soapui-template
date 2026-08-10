package com.smartbear.soapui.template.handler.def;

import java.io.ByteArrayInputStream;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapResponseHandler;

/**
 * Response handler that returns the raw SOAP response data as a {@link ByteArrayInputStream}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see SoapResponseHandler
 */
public class SoapStreamResponseHandler implements SoapResponseHandler<ByteArrayInputStream> {

	/**
	 * {@inheritDoc}
	 *
	 * @return a {@link ByteArrayInputStream} containing the raw response data
	 */
	@Override
	public ByteArrayInputStream handleResponse(Response response, SoapVersion version) throws SoapUIException {
		// 响应内容
		return new ByteArrayInputStream(response.getRawResponseData());
	}

}
