package com.smartbear.soapui.template.handler;

import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;

/**
 * Strategy interface for processing SOAP UI responses into application-specific types.
 *
 * @param <T> the type of the result produced by this handler
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see Response
 */
public interface SoapResponseHandler<T> {

    /**
     * Processes a {@link Response} and returns a value corresponding to that response.
     *
     * @param response the response to process
     * @param version  the SOAP version used in the response
     * @return a value determined by the response
     * @throws SoapUIException in case of a problem or the connection was aborted
     */
    T handleResponse(Response response, SoapVersion version) throws SoapUIException;

}
