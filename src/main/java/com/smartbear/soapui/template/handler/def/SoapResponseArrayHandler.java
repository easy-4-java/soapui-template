package com.smartbear.soapui.template.handler.def;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.support.soap.SoapUtils;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapResponseHandler;
import com.smartbear.soapui.template.utils.SoapuiResponseUtils;

/**
 * Response handler that parses a SOAP response into a string array of result values.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see SoapResponseHandler
 */
public class SoapResponseArrayHandler implements SoapResponseHandler<String[]> {

	/**
	 * {@inheritDoc}
	 *
	 * @return a string array of parsed response values
	 */
	@Override
	public String[] handleResponse(Response response, SoapVersion version) throws SoapUIException {
		// 响应内容
		String responseContent = response.getContentAsString();
		try {
			if(SoapUtils.isSoapFault(responseContent)) {
				
			}
		} catch (XmlException e) {
			e.printStackTrace();
		}
		
		return SoapuiResponseUtils.parseResponseToArray(responseContent, version);
	}
	
}

 
