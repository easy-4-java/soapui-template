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

import com.smartbear.soapui.template.property.EnvironmentProperty;
import com.smartbear.soapui.template.setting.SoapuiSettings;

/**
 * Provides SoapuiProperties functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see SoapuiProperties
 */
public class SoapuiProperties {
	
	public final static String DEFAULT_SETTINGS_FILE = "soapui-settings.xml";
    
	private String settingsFile = DEFAULT_SETTINGS_FILE;
	private SoapuiSettings settings = new SoapuiSettings();
	

	/**
	 * Whether Create Requests
	 */
	private boolean createRequests = true;
	/**
	 *  The timeout of the project, default 30s
	 */
	private long timeout = 30 * 1000;
	/**
	 *  The Maximum Cache Size of the project, default 100
	 */
	private long maximumCacheSize = 100;
	/**
	 *  The Cache Duration of the project, default 60 minutes
	 */
	private long cacheDuration = 60;
	
	private EnvironmentProperty env = new EnvironmentProperty();

	
	/**
	 * Returns whether requests should be automatically created.
	 *
	 * @return {@code true} if requests should be created, {@code false} otherwise
	 */
	public boolean isCreateRequests() {
		return createRequests;
	}

	/**
	 * Sets whether requests should be automatically created.
	 *
	 * @param createRequests {@code true} to enable automatic request creation
	 */
	public void setCreateRequests(boolean createRequests) {
		this.createRequests = createRequests;
	}

	/**
	 * Returns the project timeout in milliseconds.
	 *
	 * @return the timeout value in milliseconds
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * Sets the project timeout in milliseconds.
	 *
	 * @param timeout the timeout value in milliseconds
	 */
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	/**
	 * Returns the maximum cache size for WSDL interfaces.
	 *
	 * @return the maximum number of entries in the cache
	 */
	public long getMaximumCacheSize() {
		return maximumCacheSize;
	}

	/**
	 * Sets the maximum cache size for WSDL interfaces.
	 *
	 * @param maximumCacheSize the maximum number of entries in the cache
	 */
	public void setMaximumCacheSize(long maximumCacheSize) {
		this.maximumCacheSize = maximumCacheSize;
	}

	/**
	 * Returns the cache duration in minutes.
	 *
	 * @return the cache duration in minutes
	 */
	public long getCacheDuration() {
		return cacheDuration;
	}

	/**
	 * Sets the cache duration in minutes.
	 *
	 * @param cacheDuration the cache duration in minutes
	 */
	public void setCacheDuration(long cacheDuration) {
		this.cacheDuration = cacheDuration;
	}

	/**
	 * Returns the environment property configuration.
	 *
	 * @return the {@link EnvironmentProperty} instance
	 */
	public EnvironmentProperty getEnv() {
		return env;
	}

	/**
	 * Sets the environment property configuration.
	 *
	 * @param env the {@link EnvironmentProperty} instance
	 */
	public void setEnv(EnvironmentProperty env) {
		this.env = env;
	}

	/**
	 * Returns the path to the SoapUI settings file.
	 *
	 * @return the settings file path
	 */
	public String getSettingsFile() {
		return settingsFile;
	}

	/**
	 * Sets the path to the SoapUI settings file.
	 *
	 * @param settingsFile the settings file path
	 */
	public void setSettingsFile(String settingsFile) {
		this.settingsFile = settingsFile;
	}

	/**
	 * Returns the SoapUI settings configuration.
	 *
	 * @return the {@link SoapuiSettings} instance
	 */
	public SoapuiSettings getSettings() {
		return settings;
	}

	/**
	 * Sets the SoapUI settings configuration.
	 *
	 * @param settings the {@link SoapuiSettings} instance
	 */
	public void setSettings(SoapuiSettings settings) {
		this.settings = settings;
	}
	
}
