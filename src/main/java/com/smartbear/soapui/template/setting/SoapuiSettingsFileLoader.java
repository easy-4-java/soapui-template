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

import com.eviware.soapui.model.settings.Settings;

/**
 * Strategy interface for loading SOAP UI settings from a file.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see com.eviware.soapui.model.settings.Settings
 */
public interface SoapuiSettingsFileLoader {

	/**
	 * Loads settings from the specified file path.
	 *
	 * @param settingsFile the path to the settings file
	 * @return the loaded {@link Settings} instance
	 */
	Settings load(String settingsFile);

}
