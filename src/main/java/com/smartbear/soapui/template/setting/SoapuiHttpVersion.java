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

import com.eviware.soapui.settings.HttpSettings;

/**
 * Enumerates the supported HTTP protocol versions for SOAP UI requests.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see com.eviware.soapui.settings.HttpSettings
 */
public enum SoapuiHttpVersion {

	/** HTTP/0.9 */
	HTTP_VERSION_0_9(HttpSettings.HTTP_VERSION_0_9),
	/** HTTP/1.0 */
	HTTP_VERSION_1_0(HttpSettings.HTTP_VERSION_1_0),
	/** HTTP/1.1 */
	HTTP_VERSION_1_1(HttpSettings.HTTP_VERSION_1_1);

	private String version;

	private SoapuiHttpVersion(String version) {
		this.version = version;
	}

	/**
	 * Returns the HTTP version string identifier.
	 *
	 * @return the HTTP version string
	 */
	public String version() {
		return version;
	}

}