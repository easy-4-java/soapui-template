/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
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

public class SoapuiResponse<T extends AbstractHttpRequestInterface<?>> {

	private final T request;
	private final Status status;
	private final Exception error;
	private final Response response;

	public SoapuiResponse(T request, Response response, Status status, Exception error) {
		super();
		this.request = request;
		this.response = response;
		this.status = status;
		this.error = error;
	}

	public T getRequest() {
		return request;
	}

	public Status getStatus() {
		return status;
	}

	public Exception getError() {
		return error;
	}

	public Response getResponse() {
		return response;
	}

}
