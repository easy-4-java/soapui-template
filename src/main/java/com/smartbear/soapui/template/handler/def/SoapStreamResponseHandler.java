package com.smartbear.soapui.template.handler.def;

import java.io.ByteArrayInputStream;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import com.smartbear.soapui.template.handler.SoapResponseHandler;

/**
 * 请求响应处理：返回ByteArrayInputStream对象
 * @author 		： <a href="https://github.com/easy-4-java">hiwepy</a>
 */
public class SoapStreamResponseHandler implements SoapResponseHandler<ByteArrayInputStream> {

	@Override
	public ByteArrayInputStream handleResponse(Response response, SoapVersion version) throws SoapUIException {
		// 响应内容
		return new ByteArrayInputStream(response.getRawResponseData());
	}

}
