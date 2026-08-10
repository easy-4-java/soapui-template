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
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.support.SoapUIException;

/**
 * Represents the parsed information of a WSDL document, including its URL and
 * the list of interfaces it exposes.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 3.0.0
 * @see WsdlInterfaceInfo
 */
public class WsdlInfo {

	private String wsdlUrl;

	private List<WsdlInterfaceInfo> interfaces;

	/**
	 * Constructs a WsdlInfo by importing the WSDL from the given URL using a new project.
	 *
	 * @param wsdlUrl the WSDL document URL
	 * @throws SoapUIException if the WSDL cannot be imported
	 */
	public WsdlInfo(String wsdlUrl) throws SoapUIException {
		try {
			this.wsdlUrl = wsdlUrl;
			// create new project
			WsdlProject project = new WsdlProject();
			WsdlInterface[] wsdlInterfaces = WsdlImporter.importWsdl(project, wsdlUrl);
			if (null != wsdlInterfaces) {
				List<WsdlInterfaceInfo> interfaces = new ArrayList<WsdlInterfaceInfo>();
				for (WsdlInterface wsdlInterface : wsdlInterfaces) {
					WsdlInterfaceInfo interfaceInfo = new WsdlInterfaceInfo(wsdlInterface);
					interfaces.add(interfaceInfo);
				}
				this.interfaces = interfaces;
			}
		} catch (Exception e) {
			throw new SoapUIException("Failed to import WSDL '" + wsdlUrl + "'.", e);
		}
	}

	/**
	 * Constructs a WsdlInfo by importing the WSDL from the given URL using the specified project.
	 *
	 * @param wsdlUrl  the WSDL document URL
	 * @param project  the {@link WsdlProject} to use for importing
	 * @throws SoapUIException if the WSDL cannot be imported
	 */
	public WsdlInfo(String wsdlUrl, WsdlProject project) throws SoapUIException {
		try {
			this.wsdlUrl = wsdlUrl;
			WsdlInterface[] wsdlInterfaces = WsdlImporter.importWsdl(project, wsdlUrl);
			if (null != wsdlInterfaces) {
				List<WsdlInterfaceInfo> interfaces = new ArrayList<WsdlInterfaceInfo>();
				for (WsdlInterface wsdlInterface : wsdlInterfaces) {
					WsdlInterfaceInfo interfaceInfo = new WsdlInterfaceInfo(wsdlInterface);
					interfaces.add(interfaceInfo);
				}
				this.interfaces = interfaces;
			}
		} catch (Exception e) {
			throw new SoapUIException("Failed to import WSDL '" + wsdlUrl + "'.", e);
		}
	}
	
	/**
	 * Constructs a WsdlInfo from a WSDL URL and pre-imported interfaces.
	 *
	 * @param wsdlUrl        the WSDL document URL
	 * @param wsdlInterfaces the pre-imported WSDL interfaces, may be {@code null}
	 * @throws SoapUIException if an error occurs during construction
	 */
	public WsdlInfo(String wsdlUrl, WsdlInterface[] wsdlInterfaces) throws SoapUIException {
		this.wsdlUrl = wsdlUrl;
		if (null != wsdlInterfaces) {
			List<WsdlInterfaceInfo> interfaces = new ArrayList<WsdlInterfaceInfo>();
			for (WsdlInterface wsdlInterface : wsdlInterfaces) {
				WsdlInterfaceInfo interfaceInfo = new WsdlInterfaceInfo(wsdlInterface);
				interfaces.add(interfaceInfo);
			}
			this.interfaces = interfaces;
		}
	}

	/**
	 * Returns the WSDL document URL.
	 *
	 * @return the WSDL URL string
	 */
	public String getWsdlUrl() {
		return wsdlUrl;
	}

	/**
	 * Sets the WSDL document URL.
	 *
	 * @param wsdlUrl the WSDL URL string
	 */
	public void setWsdlUrl(String wsdlUrl) {
		this.wsdlUrl = wsdlUrl;
	}

	/**
	 * Returns the list of interfaces defined in the WSDL.
	 *
	 * @return the list of {@link WsdlInterfaceInfo} objects
	 */
	public List<WsdlInterfaceInfo> getInterfaces() {
		return interfaces;
	}

	/**
	 * Sets the list of interfaces defined in the WSDL.
	 *
	 * @param interfaces the list of {@link WsdlInterfaceInfo} objects
	 */
	public void setInterfaces(List<WsdlInterfaceInfo> interfaces) {
		this.interfaces = interfaces;
	}
}