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

public class SoapuiSettings {

	private SoapuiProjectSettings project = new SoapuiProjectSettings();
	private SoapuiHttpSettings http = new SoapuiHttpSettings();
	private SoapuiProxySettings proxy = new SoapuiProxySettings();
	private SoapuiSSLSettings ssl = new SoapuiSSLSettings();
	private SoapuiWsaSettings wsa = new SoapuiWsaSettings();
	private SoapuiWsdlSettings wsdl = new SoapuiWsdlSettings();
	private SoapuiWSISettings wsi = new SoapuiWSISettings();

	public SoapuiProjectSettings getProject() {
		return project;
	}

	public void setProject(SoapuiProjectSettings project) {
		this.project = project;
	}

	public SoapuiHttpSettings getHttp() {
		return http;
	}

	public void setHttp(SoapuiHttpSettings http) {
		this.http = http;
	}

	public SoapuiProxySettings getProxy() {
		return proxy;
	}

	public void setProxy(SoapuiProxySettings proxy) {
		this.proxy = proxy;
	}

	public SoapuiSSLSettings getSsl() {
		return ssl;
	}

	public void setSsl(SoapuiSSLSettings ssl) {
		this.ssl = ssl;
	}

	public SoapuiWsaSettings getWsa() {
		return wsa;
	}

	public void setWsa(SoapuiWsaSettings wsa) {
		this.wsa = wsa;
	}

	public SoapuiWsdlSettings getWsdl() {
		return wsdl;
	}

	public void setWsdl(SoapuiWsdlSettings wsdl) {
		this.wsdl = wsdl;
	}

	public SoapuiWSISettings getWsi() {
		return wsi;
	}

	public void setWsi(SoapuiWSISettings wsi) {
		this.wsi = wsi;
	}

}
