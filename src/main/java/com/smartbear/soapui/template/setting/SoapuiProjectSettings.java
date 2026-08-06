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

import java.util.Properties;

import com.eviware.soapui.impl.wsdl.WsdlProject.ProjectEncryptionStatus;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.model.testsuite.TestSuite.TestSuiteRunType;

/**
 * Project settings
 * 
 * @author [@Loong Wan](https://github.com/loong10k)
 */
public class SoapuiProjectSettings {

	public static enum ScriptLanguage {
		
		/** Groovy ScriptEngine. */
		GROOVY("Groovy"),
		/** Javascript ScriptEngine. */
		JAVASCRIPT("Javascript");
		
		private String name;
		
		private ScriptLanguage(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
	
	/**
	 * Whether Abort On Error
	 */
	private boolean abortOnError;
	
	/**
	 * Whether Cache Definitions
	 */
	private boolean cacheDefinitions;

	/**
	 * The Name of the project
	 */
	private String name = "default-project";
	/**
	 * The description of the project
	 */
	private String description;
	/**
	 * Encryption Status of the project
	 */
	private ProjectEncryptionStatus encryptionStatus = ProjectEncryptionStatus.NOT_ENCRYPTED;

	/**
	 * The properties of the project
	 */
	private Properties properties = new Properties();
	/**
	 * The resourceRoot of the project
	 */
	private String resourceRoot;
	/**
	 * The runType of the project
	 */
	private TestSuiteRunType runType = TestSuiteRunType.PARALLEL;
	/**
	 * The password of the project
	 */
	private String password;

	/**
	 * root folder of associated external project
	 */
	private String projectRoot;
	/**
	 */
	private String projectNature = Project.SOAPUI_NATURE_ID;
	/**
	 * password for shadowing project password
	 */
	private boolean shadowPassword = false;
	/**
	 * The Config Path of hermes
	 */
	private String hermesConfigPath;

	/**
	 * Sets the Default Script Language
	 */
	private ScriptLanguage scriptLanguage = ScriptLanguage.GROOVY;
	
	/**
	 * Sets the Script After Load
	 */
	private String scriptAfterLoad;

	/**
	 * Sets the Script After Run
	 */
	private String scriptAfterRun;

	/**
	 * Sets the Script Before Run
	 */
	private String scriptBeforeRun;

	/**
	 *  Sets the Script Before Save
	 */
	private String scriptBeforeSave;
	

	public boolean isAbortOnError() {
		return abortOnError;
	}

	public void setAbortOnError(boolean abortOnError) {
		this.abortOnError = abortOnError;
	}

	 
	public boolean isCacheDefinitions() {
		return cacheDefinitions;
	}

	public void setCacheDefinitions(boolean cacheDefinitions) {
		this.cacheDefinitions = cacheDefinitions;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectEncryptionStatus getEncryptionStatus() {
		return encryptionStatus;
	}

	public void setEncryptionStatus(ProjectEncryptionStatus encryptionStatus) {
		this.encryptionStatus = encryptionStatus;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getResourceRoot() {
		return resourceRoot;
	}

	public void setResourceRoot(String resourceRoot) {
		this.resourceRoot = resourceRoot;
	}

	public TestSuiteRunType getRunType() {
		return runType;
	}

	public void setRunType(TestSuiteRunType runType) {
		this.runType = runType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProjectRoot() {
		return projectRoot;
	}

	public void setProjectRoot(String projectRoot) {
		this.projectRoot = projectRoot;
	}

	public String getProjectNature() {
		return projectNature;
	}

	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature;
	}

	public boolean isShadowPassword() {
		return shadowPassword;
	}

	public void setShadowPassword(boolean shadowPassword) {
		this.shadowPassword = shadowPassword;
	}

	public String getHermesConfigPath() {
		return hermesConfigPath;
	}

	public void setHermesConfigPath(String hermesConfigPath) {
		this.hermesConfigPath = hermesConfigPath;
	}
	

	public ScriptLanguage getScriptLanguage() {
		return scriptLanguage;
	}

	public void setScriptLanguage(ScriptLanguage scriptLanguage) {
		this.scriptLanguage = scriptLanguage;
	}

	public String getScriptAfterLoad() {
		return scriptAfterLoad;
	}

	public void setScriptAfterLoad(String scriptAfterLoad) {
		this.scriptAfterLoad = scriptAfterLoad;
	}

	public String getScriptAfterRun() {
		return scriptAfterRun;
	}

	public void setScriptAfterRun(String scriptAfterRun) {
		this.scriptAfterRun = scriptAfterRun;
	}

	public String getScriptBeforeRun() {
		return scriptBeforeRun;
	}

	public void setScriptBeforeRun(String scriptBeforeRun) {
		this.scriptBeforeRun = scriptBeforeRun;
	}

	public String getScriptBeforeSave() {
		return scriptBeforeSave;
	}

	public void setScriptBeforeSave(String scriptBeforeSave) {
		this.scriptBeforeSave = scriptBeforeSave;
	}

}
