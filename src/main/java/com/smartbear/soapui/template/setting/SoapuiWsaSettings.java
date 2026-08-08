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
 * WS-A Settings
 * 
 * @author [@Loong Wan](https://github.com/loong10k)
 */
/**
 * Provides SoapuiWsaSettings functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see SoapuiWsaSettings
 */
public class SoapuiWsaSettings {

	/**
	 * Soap action if present overrides wsa action
	 */
	public boolean soapActionOverridesWsaAction = false;
	/**
	 * Use default 'reply' for RelationshipType
	 */
	public boolean useDefaultRelationshipType = true;

	/**
	 * Use default 'unspecified' for RelatesTo
	 */
	public boolean useDefaultRelatesTo = true;
	/**
	 * Replaces existing WS-A headers (or skips them if unchecked)
	 */
	public boolean overrideExistingHeaders = false;
	/**
	 * Enables WS-Addressing for Addressing Optional='true'
	 */
	public boolean enableForOptional = false;

	public boolean isSoapActionOverridesWsaAction() {
		return soapActionOverridesWsaAction;
	}

	public void setSoapActionOverridesWsaAction(boolean soapActionOverridesWsaAction) {
		this.soapActionOverridesWsaAction = soapActionOverridesWsaAction;
	}

	public boolean isUseDefaultRelationshipType() {
		return useDefaultRelationshipType;
	}

	public void setUseDefaultRelationshipType(boolean useDefaultRelationshipType) {
		this.useDefaultRelationshipType = useDefaultRelationshipType;
	}

	public boolean isUseDefaultRelatesTo() {
		return useDefaultRelatesTo;
	}

	public void setUseDefaultRelatesTo(boolean useDefaultRelatesTo) {
		this.useDefaultRelatesTo = useDefaultRelatesTo;
	}

	public boolean isOverrideExistingHeaders() {
		return overrideExistingHeaders;
	}

	public void setOverrideExistingHeaders(boolean overrideExistingHeaders) {
		this.overrideExistingHeaders = overrideExistingHeaders;
	}

	public boolean isEnableForOptional() {
		return enableForOptional;
	}

	public void setEnableForOptional(boolean enableForOptional) {
		this.enableForOptional = enableForOptional;
	}

}
