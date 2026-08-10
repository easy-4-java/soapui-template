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

import java.util.ArrayList;
import java.util.List;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.support.soap.SoapVersion;

/**
 * Represents the parsed information of a WSDL interface, including its name, type,
 * description, SOAP version, endpoints, and the list of operations it exposes.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see WsdlOperationInfo
 */
public class WsdlInterfaceInfo {
	
	private String[] adrress;
	private String interfaceName;
	private String interfaceType;
	private String interfaceDesc;
	private SoapVersion soapVersion;
	private List<WsdlOperationInfo> operations;


	/**
	 * Constructs a WsdlInterfaceInfo from a {@link WsdlInterface} instance,
	 * extracting its name, type, description, SOAP version, endpoints, and operations.
	 *
	 * @param wsdlInterface the WSDL interface to extract information from
	 */
	public WsdlInterfaceInfo(WsdlInterface wsdlInterface) {
		this.interfaceName = wsdlInterface.getName();
		this.interfaceType = wsdlInterface.getInterfaceType();
		this.interfaceDesc = wsdlInterface.getDescription();
		this.soapVersion = wsdlInterface.getSoapVersion();
		this.adrress = wsdlInterface.getEndpoints();

		int operationNum = wsdlInterface.getOperationCount();
		List<WsdlOperationInfo> operations = new ArrayList<WsdlOperationInfo>();

		for (int i = 0; i < operationNum; i++) {
			WsdlOperation operation = (WsdlOperation) wsdlInterface.getOperationAt(i);
			WsdlOperationInfo operationInfo = new WsdlOperationInfo(operation);
			operations.add(operationInfo);
		}

		this.operations = operations;
	}

	/**
	 * Returns the interface name.
	 *
	 * @return the interface name
	 */
	public String getInterfaceName() {
		return interfaceName;
	}

	/**
	 * Sets the interface name.
	 *
	 * @param interfaceName the interface name
	 */
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	/**
	 * Returns the list of operations defined in this interface.
	 *
	 * @return the list of {@link WsdlOperationInfo} objects
	 */
	public List<WsdlOperationInfo> getOperations() {
		return operations;
	}

	/**
	 * Sets the list of operations for this interface.
	 *
	 * @param operations the list of {@link WsdlOperationInfo} objects
	 */
	public void setOperations(List<WsdlOperationInfo> operations) {
		this.operations = operations;
	}

	/**
	 * Returns the endpoint addresses of this interface.
	 *
	 * @return an array of endpoint address strings
	 */
	public String[] getAdrress() {
		return adrress;
	}

	/**
	 * Sets the endpoint addresses of this interface.
	 *
	 * @param adrress an array of endpoint address strings
	 */
	public void setAdrress(String[] adrress) {
		this.adrress = adrress;
	}

	/**
	 * Returns the interface type identifier.
	 *
	 * @return the interface type string
	 */
	public String getInterfaceType() {
		return interfaceType;
	}

	/**
	 * Sets the interface type identifier.
	 *
	 * @param interfaceType the interface type string
	 */
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	/**
	 * Returns the interface description.
	 *
	 * @return the description string
	 */
	public String getInterfaceDesc() {
		return interfaceDesc;
	}

	/**
	 * Sets the interface description.
	 *
	 * @param interfaceDesc the description string
	 */
	public void setInterfaceDesc(String interfaceDesc) {
		this.interfaceDesc = interfaceDesc;
	}

	/**
	 * Returns the SOAP version used by this interface.
	 *
	 * @return the {@link SoapVersion}
	 */
	public SoapVersion getSoapVersion() {
		return soapVersion;
	}

	/**
	 * Sets the SOAP version used by this interface.
	 *
	 * @param soapVersion the {@link SoapVersion}
	 */
	public void setSoapVersion(SoapVersion soapVersion) {
		this.soapVersion = soapVersion;
	}
	
}