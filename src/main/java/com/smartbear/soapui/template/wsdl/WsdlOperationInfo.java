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
package com.smartbear.soapui.template.wsdl;

import java.util.List;

import javax.wsdl.OperationType;

import org.apache.commons.lang.StringUtils;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.support.Constants;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;
import com.eviware.soapui.support.SoapUIException;
import com.google.common.collect.Lists;
import com.smartbear.soapui.template.utils.SoapuiRequestUtils;

/**
 * Represents the parsed information of a WSDL operation, including its name, type,
 * description, SOAP action, target namespace, request/response XML, and input parameters.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 * @see WsdlInterfaceInfo
 */
public class WsdlOperationInfo {

	private String endPoint;
	private String operationName;
	private OperationType operationType;
	private String operationDesc;
	private String requestXml;
	private String responseXml;
	private String soapAction;
	private SoapVersion soapVersion;
	private String targetNameSpace;
	private String targetXsd;
	private List<String> inputNames;
	private List<String> inputTypes;
	private List<String> inputDesc;
	private String sep = "#";

	/**
	 * Constructs a WsdlOperationInfo from a {@link WsdlOperation} instance,
	 * extracting its name, description, type, request/response XML, SOAP version,
	 * SOAP action, target namespace, and input parameters.
	 *
	 * @param operation the WSDL operation to extract information from
	 */
	public WsdlOperationInfo(WsdlOperation operation) {

		WsdlInterface wsdlInterface = operation.getInterface();

		this.operationName = operation.getName();
		this.operationDesc = operation.getDescription();
		this.operationType = operation.getOperationType();

		this.requestXml = operation.createRequest(true);
		this.responseXml = operation.createResponse(true);
		this.soapVersion = wsdlInterface.getSoapVersion();
		this.soapAction = this.soapVersion.getSoapActionHeader(operation.getAction());

		// 处理targetNameSpace
		this.targetNameSpace = requestXml.substring(requestXml.lastIndexOf("\"http://") + 1,
				requestXml.lastIndexOf("\">"));

		if (this.soapVersion.getEnvelopeNamespace().equalsIgnoreCase(Constants.SOAP11_ENVELOPE_NS)) {
			targetXsd = "11";
		} else if (this.soapVersion.getEnvelopeNamespace().equalsIgnoreCase(Constants.SOAP12_ENVELOPE_NS)) {
			targetXsd = "12";
		}

		try {

			this.inputNames = Lists.newArrayList();
			this.inputTypes = Lists.newArrayList();

			SoapuiRequestUtils.extractRequest(this.requestXml, this.soapVersion, this.inputNames, this.inputTypes);

		} catch (SoapUIException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Returns the endpoint address of this operation.
	 *
	 * @return the endpoint address string
	 */
	public String getEndPoint() {
		return endPoint;
	}

	/**
	 * Returns the operation name.
	 *
	 * @return the operation name
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * Returns the operation type (e.g., request-response, one-way).
	 *
	 * @return the {@link OperationType}
	 */
	public OperationType getOperationType() {
		return operationType;
	}

	/**
	 * Returns the operation description.
	 *
	 * @return the description string
	 */
	public String getOperationDesc() {
		return operationDesc;
	}

	/**
	 * Returns the generated request XML template for this operation.
	 *
	 * @return the request XML string
	 */
	public String getRequestXml() {
		return requestXml;
	}

	/**
	 * Returns the generated response XML template for this operation.
	 *
	 * @return the response XML string
	 */
	public String getResponseXml() {
		return responseXml;
	}

	/**
	 * Returns the SOAP action header value for this operation.
	 *
	 * @return the SOAP action string
	 */
	public String getSoapAction() {
		return soapAction;
	}

	/**
	 * Returns the SOAP version used by this operation.
	 *
	 * @return the {@link SoapVersion}
	 */
	public SoapVersion getSoapVersion() {
		return soapVersion;
	}

	/**
	 * Returns the target namespace of this operation.
	 *
	 * @return the target namespace URI string
	 */
	public String getTargetNameSpace() {
		return targetNameSpace;
	}

	/**
	 * Returns the target XSD version indicator ("11" for SOAP 1.1, "12" for SOAP 1.2).
	 *
	 * @return the XSD version string
	 */
	public String getTargetXsd() {
		return targetXsd;
	}

	/**
	 * Returns the list of input parameter names.
	 *
	 * @return the list of input parameter names
	 */
	public List<String> getInputNames() {
		return inputNames;
	}

	/**
	 * Returns the list of input parameter types.
	 *
	 * @return the list of input parameter types
	 */
	public List<String> getInputTypes() {
		return inputTypes;
	}

	/**
	 * Returns the list of input parameter descriptions.
	 *
	 * @return the list of input parameter descriptions
	 */
	public List<String> getInputDesc() {
		return inputDesc;
	}

	@Override
	public String toString() {
		StringBuffer su = new StringBuffer();
		su.append(this.operationName);
		su.append(this.sep);
		su.append(this.inputTypes == null ? "" : StringUtils.join(this.inputTypes.toArray(), "@"));
		su.append(this.sep);
		su.append(this.inputNames == null ? "" : StringUtils.join(this.inputNames.toArray(), "@"));
		su.append(this.sep);
		su.append(this.operationDesc == null ? "" : this.operationDesc);
		su.append(this.sep);
		su.append(this.sep);
		su.append(this.soapAction == null ? "" : this.soapAction);
		su.append(this.sep);
		su.append(this.targetXsd == null ? "" : this.targetXsd);
		return su.toString();
	}

}