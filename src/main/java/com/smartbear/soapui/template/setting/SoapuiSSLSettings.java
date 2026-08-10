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
 * Provides SoapuiSSLSettings functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see SoapuiSSLSettings
 */
public class SoapuiSSLSettings {

	/**
	 * KeyStore Url to use
	 */
	public String keyStore;
	/**
	 * keyStore password
	 */
	public String keyStorePassword;
	/**
	 * enable SSL for Mock Services
	 */
	public boolean enableMockSSL;
	/**
	 * local port to use for SSL mock services
	 */
	public int mockPort;
	/**
	 * KeyStore Url to use for mock services
	 */
	public String mockKeyStore;
	/**
	 * password for mock services
	 */
	public String mockPassword;
	/**
	 * password for mock keyStore
	 */
	public String mockKeyStorePassword;
	/**
	 * mock trustStore to use
	 */
	public String mockTrustStore;
	/**
	 * mock trustStore password
	 */
	public String mockTrustStorePassword;
	/**
	 * requires client authentication
	 */
	public boolean needClientAuthentication;

	public String getKeyStore() {
		return keyStore;
	}

	public void setKeyStore(String keyStore) {
		this.keyStore = keyStore;
	}

	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public boolean isEnableMockSSL() {
		return enableMockSSL;
	}

	public void setEnableMockSSL(boolean enableMockSSL) {
		this.enableMockSSL = enableMockSSL;
	}

	public int getMockPort() {
		return mockPort;
	}

	public void setMockPort(int mockPort) {
		this.mockPort = mockPort;
	}

	public String getMockKeyStore() {
		return mockKeyStore;
	}

	public void setMockKeyStore(String mockKeyStore) {
		this.mockKeyStore = mockKeyStore;
	}

	public String getMockPassword() {
		return mockPassword;
	}

	public void setMockPassword(String mockPassword) {
		this.mockPassword = mockPassword;
	}

	public String getMockKeyStorePassword() {
		return mockKeyStorePassword;
	}

	public void setMockKeyStorePassword(String mockKeyStorePassword) {
		this.mockKeyStorePassword = mockKeyStorePassword;
	}

	public String getMockTrustStore() {
		return mockTrustStore;
	}

	public void setMockTrustStore(String mockTrustStore) {
		this.mockTrustStore = mockTrustStore;
	}

	public String getMockTrustStorePassword() {
		return mockTrustStorePassword;
	}

	public void setMockTrustStorePassword(String mockTrustStorePassword) {
		this.mockTrustStorePassword = mockTrustStorePassword;
	}

	public boolean isNeedClientAuthentication() {
		return needClientAuthentication;
	}

	public void setNeedClientAuthentication(boolean needClientAuthentication) {
		this.needClientAuthentication = needClientAuthentication;
	}

}
