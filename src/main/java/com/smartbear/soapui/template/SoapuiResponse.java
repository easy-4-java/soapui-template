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

import com.eviware.soapui.impl.support.AbstractHttpRequestInterface;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.Submit.Status;

/**
 * Encapsulates the result of a SOAP UI request submission, holding the original
 * request, the response content, the submission status, and any error that occurred.
 *
 * @param <T> the type of the HTTP request, must extend {@link AbstractHttpRequestInterface}
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see AbstractHttpRequestInterface
 */
public class SoapuiResponse<T extends AbstractHttpRequestInterface<?>> {

	private final T request;
	private final Status status;
	private final Exception error;
	private final Response response;

	/**
	 * Constructs a new SoapuiResponse with the given request, response, status, and error.
	 *
	 * @param request  the original SOAP UI request
	 * @param response the response received from the service
	 * @param status   the submission status
	 * @param error    the exception thrown during submission, or {@code null} if successful
	 */
	public SoapuiResponse(T request, Response response, Status status, Exception error) {
		super();
		this.request = request;
		this.response = response;
		this.status = status;
		this.error = error;
	}

	/**
	 * Returns the original request that was submitted.
	 *
	 * @return the request object
	 */
	public T getRequest() {
		return request;
	}

	/**
	 * Returns the submission status.
	 *
	 * @return the {@link Status} of the submission
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Returns the exception that occurred during submission, if any.
	 *
	 * @return the exception, or {@code null} if no error occurred
	 */
	public Exception getError() {
		return error;
	}

	/**
	 * Returns the response received from the SOAP service.
	 *
	 * @return the {@link Response} object
	 */
	public Response getResponse() {
		return response;
	}

}
