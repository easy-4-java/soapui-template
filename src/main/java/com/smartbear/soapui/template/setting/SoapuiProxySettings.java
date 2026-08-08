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

/**
 * HTTP-Proxy settings
 * 
 * @author [@Loong Wan](https://github.com/loong10k)
 */
/**
 * Provides SoapuiProxySettings functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see SoapuiProxySettings
 */
public class SoapuiProxySettings {
	
	/**
	 * use automatic proxy detection
	 */
	private boolean autoProxy = false;
	/**
	 * enable using proxy
	 */
	private boolean enableProxy = false;
	/**
	 * proxy host to use
	 */
	private String host;
	/**
	 * proxy port to use
	 */
	private int port;
	/**
	 * proxy username to use
	 */
	private String username;
	/**
	 * proxy password to use
	 */
	private String password;
	/**
	 * Comma-seperated list of hosts to exclude
	 */
	private String excludes;

	public boolean isAutoProxy() {
		return autoProxy;
	}

	public void setAutoProxy(boolean autoProxy) {
		this.autoProxy = autoProxy;
	}

	public boolean isEnableProxy() {
		return enableProxy;
	}

	public void setEnableProxy(boolean enableProxy) {
		this.enableProxy = enableProxy;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}

}
