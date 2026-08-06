 package com.smartbear.soapui.template.handler.def;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.support.soap.SoapUtils;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapResponseHandler;
import com.smartbear.soapui.template.utils.SoapuiResponseUtils;

/**
 * 请求响应处理：返回String对象
 * @author [@Loong Wan](https://github.com/loong10k)
 */
public class SoapResponseArrayHandler implements SoapResponseHandler<String[]> {
 
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

 
