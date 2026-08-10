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

import com.eviware.soapui.support.types.StringList;

/**
 * Provides SoapuiWsdlSettings functionality for SOAP UI template processing.
 * <p>This component encapsulates reusable behavior used when constructing,
 * configuring, or interpreting SOAP UI requests and responses.</p>
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see SoapuiWsdlSettings
 */
public class SoapuiWsdlSettings {

	/**
	 * caches and associates WSDLs locally for offline access and improved
	 * performance
	 */
	public boolean cacheWsdls = true;
	/**
	 * generate example values in new requests
	 */
	public boolean xmlGenerationTypeExampleValue = false;
	/**
	 * generate comments with type information in new requests
	 */
	public boolean xmlGenerationTypeCommentValue = false;
	/**
	 * always include optional schema elements when creating requests
	 */
	public boolean xmlGenerationAlwaysIncludeOptionalElements = true;
	/**
	 * pretty print response messages
	 */
	public boolean prettyPrintResponseXml = true;
	/**
	 * generate rpc message parts for attachments
	 */
	public boolean attachmentParts = true;
	/**
	 * allow incorrect content-types in mime-attachments
	 */
	public boolean allowIncorrectContenttype = true;
	/**
	 */
	public boolean enableMtom;
	/**
	 * local directory containing schemas that should be added to loading/validation
	 */
	public String schemaDirectory;
	/**
	 * uses the WSDL binding name (instead of portType) for imported Interfaces
	 */
	public boolean nameWithBinding = true;
	/**
	 * types to exclude in request generation
	 */
	public StringList excludedTypes;
	/**
	 * fails schema imports if types/particles are redefined
	 */
	public StringList strictSchemaTypes;
	/**
	 * minimum message size to compress
	 */
	public int compressionLimit;
	/**
	 * pretty prints project files
	 */
	public boolean prettyPrintProjectFiles;
	/**
	 * xml generation skip comments
	 */
	public boolean xmlGenerationSkipComments;
	/**
	 * Trims leading and trailing whitespaces from WSDL file (might not work on non
	 * 8 bit encoding)
	 */
	public boolean trimWsdl;

	public boolean isCacheWsdls() {
		return cacheWsdls;
	}

	public void setCacheWsdls(boolean cacheWsdls) {
		this.cacheWsdls = cacheWsdls;
	}

	public boolean isXmlGenerationTypeExampleValue() {
		return xmlGenerationTypeExampleValue;
	}

	public void setXmlGenerationTypeExampleValue(boolean xmlGenerationTypeExampleValue) {
		this.xmlGenerationTypeExampleValue = xmlGenerationTypeExampleValue;
	}

	public boolean isXmlGenerationTypeCommentValue() {
		return xmlGenerationTypeCommentValue;
	}

	public void setXmlGenerationTypeCommentValue(boolean xmlGenerationTypeCommentValue) {
		this.xmlGenerationTypeCommentValue = xmlGenerationTypeCommentValue;
	}

	public boolean isXmlGenerationAlwaysIncludeOptionalElements() {
		return xmlGenerationAlwaysIncludeOptionalElements;
	}

	public void setXmlGenerationAlwaysIncludeOptionalElements(boolean xmlGenerationAlwaysIncludeOptionalElements) {
		this.xmlGenerationAlwaysIncludeOptionalElements = xmlGenerationAlwaysIncludeOptionalElements;
	}

	public boolean isPrettyPrintResponseXml() {
		return prettyPrintResponseXml;
	}

	public void setPrettyPrintResponseXml(boolean prettyPrintResponseXml) {
		this.prettyPrintResponseXml = prettyPrintResponseXml;
	}

	public boolean isAttachmentParts() {
		return attachmentParts;
	}

	public void setAttachmentParts(boolean attachmentParts) {
		this.attachmentParts = attachmentParts;
	}

	public boolean isAllowIncorrectContenttype() {
		return allowIncorrectContenttype;
	}

	public void setAllowIncorrectContenttype(boolean allowIncorrectContenttype) {
		this.allowIncorrectContenttype = allowIncorrectContenttype;
	}

	public boolean isEnableMtom() {
		return enableMtom;
	}

	public void setEnableMtom(boolean enableMtom) {
		this.enableMtom = enableMtom;
	}

	public String getSchemaDirectory() {
		return schemaDirectory;
	}

	public void setSchemaDirectory(String schemaDirectory) {
		this.schemaDirectory = schemaDirectory;
	}

	public boolean isNameWithBinding() {
		return nameWithBinding;
	}

	public void setNameWithBinding(boolean nameWithBinding) {
		this.nameWithBinding = nameWithBinding;
	}

	public StringList getExcludedTypes() {
		return excludedTypes;
	}

	public void setExcludedTypes(StringList excludedTypes) {
		this.excludedTypes = excludedTypes;
	}

	public StringList getStrictSchemaTypes() {
		return strictSchemaTypes;
	}

	public void setStrictSchemaTypes(StringList strictSchemaTypes) {
		this.strictSchemaTypes = strictSchemaTypes;
	}

	public int getCompressionLimit() {
		return compressionLimit;
	}

	public void setCompressionLimit(int compressionLimit) {
		this.compressionLimit = compressionLimit;
	}

	public boolean isPrettyPrintProjectFiles() {
		return prettyPrintProjectFiles;
	}

	public void setPrettyPrintProjectFiles(boolean prettyPrintProjectFiles) {
		this.prettyPrintProjectFiles = prettyPrintProjectFiles;
	}

	public boolean isXmlGenerationSkipComments() {
		return xmlGenerationSkipComments;
	}

	public void setXmlGenerationSkipComments(boolean xmlGenerationSkipComments) {
		this.xmlGenerationSkipComments = xmlGenerationSkipComments;
	}

	public boolean isTrimWsdl() {
		return trimWsdl;
	}

	public void setTrimWsdl(boolean trimWsdl) {
		this.trimWsdl = trimWsdl;
	}

}
