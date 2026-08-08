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
package com.smartbear.soapui.template.setting;

import com.eviware.soapui.impl.wsdl.support.CompressionSupport;

/**
 * Enumerates the supported HTTP request compression algorithms for SOAP UI requests.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see com.eviware.soapui.impl.wsdl.support.CompressionSupport
 */
public enum SoapuiHttpRequestCompression {

	/** No compression. */
	ALG_NONE("None"),
	/** GZIP compression. */
	ALG_GZIP(CompressionSupport.ALG_GZIP),
	/** DEFLATE compression. */
	ALG_DEFLATE(CompressionSupport.ALG_DEFLATE);

	private String alg;

	private SoapuiHttpRequestCompression(String alg) {
		this.alg = alg;
	}

	/**
	 * Returns the algorithm identifier string.
	 *
	 * @return the compression algorithm name
	 */
	public String alg() {
		return alg;
	}

}