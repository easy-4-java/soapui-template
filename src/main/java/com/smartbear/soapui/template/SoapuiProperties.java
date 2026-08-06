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

	
	public boolean isCreateRequests() {
		return createRequests;
	}

	public void setCreateRequests(boolean createRequests) {
		this.createRequests = createRequests;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public long getMaximumCacheSize() {
		return maximumCacheSize;
	}

	public void setMaximumCacheSize(long maximumCacheSize) {
		this.maximumCacheSize = maximumCacheSize;
	}

	public long getCacheDuration() {
		return cacheDuration;
	}

	public void setCacheDuration(long cacheDuration) {
		this.cacheDuration = cacheDuration;
	}

	public EnvironmentProperty getEnv() {
		return env;
	}

	public void setEnv(EnvironmentProperty env) {
		this.env = env;
	}
	
	public String getSettingsFile() {
		return settingsFile;
	}

	public void setSettingsFile(String settingsFile) {
		this.settingsFile = settingsFile;
	}

	public SoapuiSettings getSettings() {
		return settings;
	}

	public void setSettings(SoapuiSettings settings) {
		this.settings = settings;
	}
	
}
