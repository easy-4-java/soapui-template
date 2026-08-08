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

import com.eviware.soapui.settings.WSISettings;

/**
 * WS-I Testing-Tools related settings
 */
/**
 * Provides SoapuiWSISettings functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see SoapuiWSISettings
 */
public class SoapuiWSISettings {

	public enum SoapuiProfileType {

		BASIC_PROFILE_10_TAD(WSISettings.BASIC_PROFILE_10_TAD), 
		BASICf_PROFILE_11_TAD(WSISettings.BASICf_PROFILE_11_TAD);

		private String value;

		private SoapuiProfileType(String value) {
			this.value = value;
		}

		public String value() {
			return value;
		}

	}

	public enum SoapuiCorrelationType {

		ENDPOINT(WSISettings.ENDPOINT_LOG_FILE_CORRELATION_TYPE), 
		NAMESPACE(WSISettings.NAMESPACE_LOG_FILE_CORRELATION_TYPE), 
		OPERATION(WSISettings.OPERATION_LOG_FILE_CORRELATION_TYPE);

		private String value;

		private SoapuiCorrelationType(String value) {
			this.value = value;
		}

		public String value() {
			return value;
		}

	}

	/**
	 * Verbose output of WSI tools
	 */
	public boolean verbose;
	/**
	 * Specify the type of profile
	 */
	public SoapuiProfileType profileType = SoapuiProfileType.BASIC_PROFILE_10_TAD;
	/**
	 * Specify the log file correlation type
	 */
	public SoapuiCorrelationType correlationType = SoapuiCorrelationType.ENDPOINT;
	/**
	 * Message entries should be included in the report
	 */
	public boolean messageEntry;
	/**
	 * Failure message defined for each test assertion should be included in the
	 * report
	 */
	public boolean failureMessage;
	/**
	 * Description of each test assertion should be included in the report
	 */
	public boolean assertionDescription;
	/**
	 * Specifies the root folder of the wsi-test-tools installation
	 */
	public String location;
	/**
	 * Show console-log for ws-i analyzer
	 */
	public boolean showLog;
	/**
	 * Specifies the output folder for reports generated from commandline
	 */
	public String outputFolder;

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	public SoapuiProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(SoapuiProfileType profileType) {
		this.profileType = profileType;
	}

	public SoapuiCorrelationType getCorrelationType() {
		return correlationType;
	}

	public void setCorrelationType(SoapuiCorrelationType correlationType) {
		this.correlationType = correlationType;
	}

	public boolean isMessageEntry() {
		return messageEntry;
	}

	public void setMessageEntry(boolean messageEntry) {
		this.messageEntry = messageEntry;
	}

	public boolean isFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(boolean failureMessage) {
		this.failureMessage = failureMessage;
	}

	public boolean isAssertionDescription() {
		return assertionDescription;
	}

	public void setAssertionDescription(boolean assertionDescription) {
		this.assertionDescription = assertionDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isShowLog() {
		return showLog;
	}

	public void setShowLog(boolean showLog) {
		this.showLog = showLog;
	}

	public String getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(String outputFolder) {
		this.outputFolder = outputFolder;
	}

}
