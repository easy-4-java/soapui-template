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
package com.smartbear.soapui.template.property;

import java.util.Properties;

/**
 * Provides EnvironmentProperty functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see EnvironmentProperty
 */
public class EnvironmentProperty {

	/**
	 * Environment Name
	 */
	private String name;
	/**
	 * Environment Settings
	 */
	private Properties settings = new Properties();

	/**
	 * Returns the environment name.
	 *
	 * @return the environment name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the environment name.
	 *
	 * @param name the environment name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the environment settings as a {@link Properties} object.
	 *
	 * @return the environment settings
	 */
	public Properties getSettings() {
		return settings;
	}

	/**
	 * Sets the environment settings.
	 *
	 * @param settings the environment settings as a {@link Properties} object
	 */
	public void setSettings(Properties settings) {
		this.settings = settings;
	}

}
