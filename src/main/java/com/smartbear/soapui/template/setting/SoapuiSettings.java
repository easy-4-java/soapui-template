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
 * Aggregates all SOAP UI settings including project, HTTP, proxy, SSL, WSA, WSDL,
 * and WS-I configuration into a single configuration object.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see SoapuiProjectSettings
 * @see SoapuiHttpSettings
 * @see SoapuiProxySettings
 * @see SoapuiSSLSettings
 * @see SoapuiWsaSettings
 * @see SoapuiWsdlSettings
 * @see SoapuiWSISettings
 */
public class SoapuiSettings {

	private SoapuiProjectSettings project = new SoapuiProjectSettings();
	private SoapuiHttpSettings http = new SoapuiHttpSettings();
	private SoapuiProxySettings proxy = new SoapuiProxySettings();
	private SoapuiSSLSettings ssl = new SoapuiSSLSettings();
	private SoapuiWsaSettings wsa = new SoapuiWsaSettings();
	private SoapuiWsdlSettings wsdl = new SoapuiWsdlSettings();
	private SoapuiWSISettings wsi = new SoapuiWSISettings();

	/**
	 * Returns the project settings.
	 *
	 * @return the {@link SoapuiProjectSettings}
	 */
	public SoapuiProjectSettings getProject() {
		return project;
	}

	/**
	 * Sets the project settings.
	 *
	 * @param project the {@link SoapuiProjectSettings}
	 */
	public void setProject(SoapuiProjectSettings project) {
		this.project = project;
	}

	/**
	 * Returns the HTTP settings.
	 *
	 * @return the {@link SoapuiHttpSettings}
	 */
	public SoapuiHttpSettings getHttp() {
		return http;
	}

	/**
	 * Sets the HTTP settings.
	 *
	 * @param http the {@link SoapuiHttpSettings}
	 */
	public void setHttp(SoapuiHttpSettings http) {
		this.http = http;
	}

	/**
	 * Returns the proxy settings.
	 *
	 * @return the {@link SoapuiProxySettings}
	 */
	public SoapuiProxySettings getProxy() {
		return proxy;
	}

	/**
	 * Sets the proxy settings.
	 *
	 * @param proxy the {@link SoapuiProxySettings}
	 */
	public void setProxy(SoapuiProxySettings proxy) {
		this.proxy = proxy;
	}

	/**
	 * Returns the SSL settings.
	 *
	 * @return the {@link SoapuiSSLSettings}
	 */
	public SoapuiSSLSettings getSsl() {
		return ssl;
	}

	/**
	 * Sets the SSL settings.
	 *
	 * @param ssl the {@link SoapuiSSLSettings}
	 */
	public void setSsl(SoapuiSSLSettings ssl) {
		this.ssl = ssl;
	}

	/**
	 * Returns the WS-Addressing settings.
	 *
	 * @return the {@link SoapuiWsaSettings}
	 */
	public SoapuiWsaSettings getWsa() {
		return wsa;
	}

	/**
	 * Sets the WS-Addressing settings.
	 *
	 * @param wsa the {@link SoapuiWsaSettings}
	 */
	public void setWsa(SoapuiWsaSettings wsa) {
		this.wsa = wsa;
	}

	/**
	 * Returns the WSDL settings.
	 *
	 * @return the {@link SoapuiWsdlSettings}
	 */
	public SoapuiWsdlSettings getWsdl() {
		return wsdl;
	}

	/**
	 * Sets the WSDL settings.
	 *
	 * @param wsdl the {@link SoapuiWsdlSettings}
	 */
	public void setWsdl(SoapuiWsdlSettings wsdl) {
		this.wsdl = wsdl;
	}

	/**
	 * Returns the WS-I settings.
	 *
	 * @return the {@link SoapuiWSISettings}
	 */
	public SoapuiWSISettings getWsi() {
		return wsi;
	}

	/**
	 * Sets the WS-I settings.
	 *
	 * @param wsi the {@link SoapuiWSISettings}
	 */
	public void setWsi(SoapuiWSISettings wsi) {
		this.wsi = wsi;
	}

}
