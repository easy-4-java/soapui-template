package com.smartbear.soapui.template.handler;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.protocol.HttpClientContext;

/**
 * Abstract base class for HTTP response handlers that provides common context
 * and charset configuration.
 *
 * @param <T> the type of the response object produced by this handler
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see ResponseHandler
 */
public abstract class AbstractResponseHandler<T> implements ResponseHandler<T> {

	protected HttpClientContext context;
	protected String charsetStr;

	/**
	 * Constructs a new AbstractResponseHandler with the given context and charset.
	 *
	 * @param context the HTTP client context
	 * @param charset the character set name used for response decoding
	 */
	public AbstractResponseHandler(HttpClientContext context, String charset) {
		this.context = context;
		this.charsetStr = charset;
	}

	/**
	 * Returns the HTTP client context.
	 *
	 * @return the {@link HttpClientContext}
	 */
	public HttpClientContext getContext() {

		return context;
	}

	/**
	 * Sets the HTTP client context.
	 *
	 * @param context the {@link HttpClientContext} to use
	 */
	public void setContext(HttpClientContext context) {

		this.context = context;
	}

	/**
	 * Returns the charset used for response decoding.
	 *
	 * @return the charset name
	 */
	public String getCharset() {

		return charsetStr;
	}

	/**
	 * Sets the charset used for response decoding.
	 *
	 * @param charset the charset name
	 */
	public void setCharset(String charset) {

		this.charsetStr = charset;
	}

}
