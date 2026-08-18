/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
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

import java.io.File;

import com.eviware.soapui.impl.settings.SettingsImpl;
import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.impl.wsdl.support.http.HttpClientSupport;
import com.eviware.soapui.model.project.Project;
import com.eviware.soapui.model.settings.Settings;
import com.eviware.soapui.settings.HttpSettings;
import com.eviware.soapui.settings.ProjectSettings;
import com.eviware.soapui.settings.ProxySettings;
import com.eviware.soapui.settings.SSLSettings;
import com.eviware.soapui.settings.WSISettings;
import com.eviware.soapui.settings.WsaSettings;
import com.eviware.soapui.settings.WsdlSettings;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.types.StringList;

public class SoapuiSettingsImpl extends SettingsImpl {

	protected Settings parent;
	public SoapuiSettingsImpl() {
		super();
		HttpClientSupport.addSSLListener(this);
	}

	public SoapuiSettingsImpl(Settings parent) {
		super(parent);
		this.parent = parent;
		HttpClientSupport.addSSLListener(this);
	}
	
	public SoapuiSettingsImpl(SoapuiSettings settings, Settings parent) {
		this.parent = parent;
		this.setProjectSettings(settings.getProject());
		this.setHttpSettings(settings.getHttp());
		this.setProxySettings(settings.getProxy());
		this.setSslSettings(settings.getSsl());
		this.setWsaSettings(settings.getWsa());
		this.setWsdlSettings(settings.getWsdl());
		this.setWsiSettings(settings.getWsi());
		HttpClientSupport.addSSLListener(this);
	}
	
	protected void defaultProjectSettings() {
		setIfNotSet(ProjectSettings.PROJECT_ROOT, null);
        setIfNotSet(ProjectSettings.PROJECT_NATURE, Project.SOAPUI_NATURE_ID);
        setIfNotSet(ProjectSettings.SHADOW_PASSWORD, false);
        setIfNotSet(ProjectSettings.HERMES_CONFIG, null);
	}
	
	
	protected void defaultHttpSettings() {
		if (this.getString(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1).equals(HttpSettings.HTTP_VERSION_0_9)) {
        	this.setString(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1);
        }
        setIfNotSet(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1);
        setIfNotSet(HttpSettings.MAX_TOTAL_CONNECTIONS, 2000);
        setIfNotSet(HttpSettings.RESPONSE_COMPRESSION, true);
        setIfNotSet(HttpSettings.LEAVE_MOCKENGINE, true);
        setIfNotSet(HttpSettings.RESPONSE_COMPRESSION, true);
        setIfNotSet(HttpSettings.AUTHENTICATE_PREEMPTIVELY, false);
        setIfNotSet(HttpSettings.FORWARD_SLASHES, true);
        setIfNotSet(HttpSettings.INCLUDE_REQUEST_IN_TIME_TAKEN, true);
        setIfNotSet(HttpSettings.INCLUDE_RESPONSE_IN_TIME_TAKEN, true);
        setIfNotSet(HttpSettings.MAX_RESPONSE_SIZE, 0);
        setIfNotSet(HttpSettings.MAX_CONNECTIONS_PER_HOST, 500);
        setIfNotSet(HttpSettings.MAX_TOTAL_CONNECTIONS, 2000);
        setIfNotSet(HttpSettings.LEAVE_MOCKENGINE, true);
        setIfNotSet(HttpSettings.ENABLE_MOCK_WIRE_LOG, false);
        setIfNotSet(HttpSettings.START_MOCK_SERVICE, true);
        
	}
	
	protected void defaultProxySettings() {
		if (!this.isSet(ProxySettings.AUTO_PROXY) && !this.isSet(ProxySettings.ENABLE_PROXY)) {
        	this.setBoolean(ProxySettings.AUTO_PROXY, false);
        	this.setBoolean(ProxySettings.ENABLE_PROXY, false);
        }
	}
	
	protected void defaultWsaSettings() {
		setIfNotSet(WsaSettings.SOAP_ACTION_OVERRIDES_WSA_ACTION, false);
		setIfNotSet(WsaSettings.USE_DEFAULT_RELATES_TO, true);
        setIfNotSet(WsaSettings.USE_DEFAULT_RELATIONSHIP_TYPE, true);
        setIfNotSet(WsaSettings.OVERRIDE_EXISTING_HEADERS, false);
        setIfNotSet(WsaSettings.ENABLE_FOR_OPTIONAL, false);
	}
	
	protected void defaultWsdlSettings() {
		 if (!this.isSet(WsdlSettings.EXCLUDED_TYPES)) {
            StringList list = new StringList();
            list.add("schema@http://www.w3.org/2001/XMLSchema");
            this.setString(WsdlSettings.EXCLUDED_TYPES, list.toXml());
        }
        setIfNotSet(WsdlSettings.NAME_WITH_BINDING, true);
        setIfNotSet(WsdlSettings.NAME_WITH_BINDING, 500);
        setIfNotSet(WsdlSettings.XML_GENERATION_ALWAYS_INCLUDE_OPTIONAL_ELEMENTS, true);
        setIfNotSet(WsdlSettings.CACHE_WSDLS, true);
        setIfNotSet(WsdlSettings.PRETTY_PRINT_RESPONSE_MESSAGES, true);
	}
	
	protected void defaultWsiSettings() {
		boolean setWsiDir = false;
        String wsiLocationString = this.getString(WSISettings.WSI_LOCATION, null);
        if (StringUtils.isNullOrEmpty(wsiLocationString)) {
            setWsiDir = true;
        } else {
            File wsiFile = new File(wsiLocationString);
            if (!wsiFile.exists()) {
                setWsiDir = true;
            }
        }
        if (setWsiDir) {
            String wsiDir = System.getProperty("wsi.dir", new File(".").getAbsolutePath());
            this.setString(WSISettings.WSI_LOCATION, wsiDir);
        }
	}

	public void setProjectSettings(SoapuiProjectSettings projectSettings) {
		if(projectSettings != null) {
	        setIfNotSet(ProjectSettings.PROJECT_ROOT, projectSettings.getProjectRoot());
	        setIfNotSet(ProjectSettings.PROJECT_NATURE, projectSettings.getProjectNature());
	        setIfNotSet(ProjectSettings.SHADOW_PASSWORD, projectSettings.isShadowPassword());
	        setIfNotSet(ProjectSettings.HERMES_CONFIG, projectSettings.getHermesConfigPath());
		} else {
			defaultProjectSettings();
		}
	}

	public void setHttpSettings(SoapuiHttpSettings httpSettings) {
		if(httpSettings != null) {
			
			if (this.getString(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1).equals(HttpSettings.HTTP_VERSION_0_9)) {
	        	this.setString(HttpSettings.HTTP_VERSION, httpSettings.getHttpVersion().version());
	        }
	        setIfNotSet(HttpSettings.USER_AGENT, httpSettings.getUseragent());
	        setIfNotSet(HttpSettings.REQUEST_COMPRESSION, httpSettings.getRequestCompression().alg());
	        setIfNotSet(HttpSettings.RESPONSE_COMPRESSION, httpSettings.isResponseCompression());
	        setIfNotSet(HttpSettings.DISABLE_RESPONSE_DECOMPRESSION, httpSettings.isDisableResponseDecompression());
	        setIfNotSet(HttpSettings.CLOSE_CONNECTIONS, httpSettings.isCloseConnections());
	        setIfNotSet(HttpSettings.CHUNKING_THRESHOLD, httpSettings.getChunkingThreshold());
	        setIfNotSet(HttpSettings.AUTHENTICATE_PREEMPTIVELY, httpSettings.isAuthenticatePreemptively());
	        setIfNotSet(HttpSettings.EXPECT_CONTINUE, httpSettings.isExpectContinue());
	        setIfNotSet(HttpSettings.ENCODED_URLS, httpSettings.isEncodedUrls());
	        setIfNotSet(HttpSettings.FORWARD_SLASHES, httpSettings.isForwardSlashes());
	        setIfNotSet(HttpSettings.BIND_ADDRESS, httpSettings.getBindAddress());
	        
	        setIfNotSet(WsdlRequest.REMOVE_EMPTY_CONTENT, httpSettings.isRemoveEmptyContent());
	        setIfNotSet(WsdlRequest.STRIP_WHITESPACES, httpSettings.isStripWhitespaces());
	        setIfNotSet(WsdlRequest.REQUEST_HEADERS_PROPERTY, httpSettings.getRequestHeaders().toXml());
	        setIfNotSet(WsdlRequest.BIND_ADDRESS, httpSettings.getBindAddress());
	        setIfNotSet(WsdlRequest.DISABLE_MULTIPART_ATTACHMENTS, httpSettings.isDisableMultipartAttachments());
	        setIfNotSet(WsdlRequest.DUMP_FILE, httpSettings.getDumpFile());
	        setIfNotSet(WsdlRequest.MAX_SIZE, httpSettings.getMaxResponseSize());
	        setIfNotSet(WsdlRequest.FOLLOW_REDIRECTS, httpSettings.isFollowRedirects());
	        setIfNotSet(WsdlRequest.BIND_ADDRESS, httpSettings.getBindAddress());
	        
	        setIfNotSet(WsdlRequest.INLINE_RESPONSE_ATTACHMENTS, httpSettings.isInlineResponseAttachments());
	        setIfNotSet(WsdlRequest.EXPAND_MTOM_RESPONSE_ATTACHMENTS, httpSettings.isExpandMtomResponseAttachments());
	        setIfNotSet(WsdlRequest.FORCE_MTOM, httpSettings.isForceMtom());
	        setIfNotSet(WsdlRequest.ENABLE_INLINE_FILES, httpSettings.isEncodeAttachments());
	        setIfNotSet(WsdlRequest.SKIP_SOAP_ACTION, httpSettings.isSkipSoapAction());
	        
	        setIfNotSet(HttpSettings.INCLUDE_REQUEST_IN_TIME_TAKEN, httpSettings.isIncludeRequestInTimeTaken());
	        setIfNotSet(HttpSettings.INCLUDE_RESPONSE_IN_TIME_TAKEN, httpSettings.isIncludeResponseInTimeTaken());
	        setIfNotSet(HttpSettings.SOCKET_TIMEOUT, httpSettings.getSocketTimeout());
	        setIfNotSet(HttpSettings.MAX_RESPONSE_SIZE, httpSettings.getMaxResponseSize());
	        setIfNotSet(HttpSettings.MAX_CONNECTIONS_PER_HOST, httpSettings.getMaxConnectionsPerHost());
	        setIfNotSet(HttpSettings.MAX_TOTAL_CONNECTIONS, httpSettings.getMaxTotalConnections());
	        setIfNotSet(HttpSettings.LEAVE_MOCKENGINE, httpSettings.isLeaveMockengine());
	        setIfNotSet(HttpSettings.ENABLE_MOCK_WIRE_LOG, httpSettings.isEnableMockWireLog());
	        setIfNotSet(HttpSettings.START_MOCK_SERVICE, httpSettings.isStartMockService());
		} else {
			defaultHttpSettings();
		}
	}

	public void setProxySettings(SoapuiProxySettings proxySettings) {
		if(proxySettings != null) {
			if (!this.isSet(ProxySettings.AUTO_PROXY) && !this.isSet(ProxySettings.ENABLE_PROXY)) {
	        	this.setBoolean(ProxySettings.AUTO_PROXY, proxySettings.isAutoProxy());
	        	this.setBoolean(ProxySettings.ENABLE_PROXY, proxySettings.isEnableProxy());
	        }
			setIfNotSet(ProxySettings.HOST, proxySettings.getHost());
			setIfNotSet(ProxySettings.PORT, proxySettings.getPort());
			setIfNotSet(ProxySettings.USERNAME, proxySettings.getUsername());
			setIfNotSet(ProxySettings.PASSWORD, proxySettings.getPassword());
			setIfNotSet(ProxySettings.EXCLUDES, proxySettings.getExcludes());
		} else {
			defaultProxySettings();
		}
		
	}

	public void setSslSettings(SoapuiSSLSettings sslSettings) {
		if(sslSettings != null) {
			if (!this.isSet(SSLSettings.CLIENT_AUTHENTICATION)) {
	        	this.setBoolean(SSLSettings.CLIENT_AUTHENTICATION, sslSettings.isNeedClientAuthentication());
	        }
			if(sslSettings.isNeedClientAuthentication() 
					&& !StringUtils.isNullOrEmpty(sslSettings.getKeyStore())
					&& !StringUtils.isNullOrEmpty(sslSettings.getKeyStorePassword())) {
				setIfNotSet(SSLSettings.KEYSTORE, sslSettings.getKeyStore());
				setIfNotSet(SSLSettings.KEYSTORE_PASSWORD, sslSettings.getKeyStorePassword());
			}
			if (!this.isSet(SSLSettings.ENABLE_MOCK_SSL)) {
				setIfNotSet(SSLSettings.MOCK_PORT, sslSettings.getMockPort());
				setIfNotSet(SSLSettings.MOCK_PASSWORD, sslSettings.getMockPassword());
	        	this.setBoolean(SSLSettings.ENABLE_MOCK_SSL, sslSettings.isEnableMockSSL());
	        }
			if (sslSettings.isEnableMockSSL() 
					&& !StringUtils.isNullOrEmpty(sslSettings.getMockKeyStore())
					&& !StringUtils.isNullOrEmpty(sslSettings.getMockKeyStorePassword())) {
				setIfNotSet(SSLSettings.MOCK_KEYSTORE, sslSettings.getMockKeyStore());
				setIfNotSet(SSLSettings.MOCK_KEYSTORE_PASSWORD, sslSettings.getMockKeyStorePassword());
	        }
			if (sslSettings.isEnableMockSSL() 
					&& !StringUtils.isNullOrEmpty(sslSettings.getMockTrustStore())
					&& !StringUtils.isNullOrEmpty(sslSettings.getMockTrustStorePassword())) {
				setIfNotSet(SSLSettings.MOCK_TRUSTSTORE, sslSettings.getMockTrustStore());
				setIfNotSet(SSLSettings.MOCK_TRUSTSTORE_PASSWORD, sslSettings.getMockTrustStorePassword());
	        }
			
		}
	}

	public void setWsaSettings(SoapuiWsaSettings wsaSettings) {
		if(wsaSettings != null) {
			setIfNotSet(WsaSettings.SOAP_ACTION_OVERRIDES_WSA_ACTION, wsaSettings.isSoapActionOverridesWsaAction());
			setIfNotSet(WsaSettings.USE_DEFAULT_RELATES_TO, wsaSettings.isUseDefaultRelatesTo());
	        setIfNotSet(WsaSettings.USE_DEFAULT_RELATIONSHIP_TYPE, wsaSettings.isUseDefaultRelationshipType());
	        setIfNotSet(WsaSettings.OVERRIDE_EXISTING_HEADERS, wsaSettings.isOverrideExistingHeaders());
	        setIfNotSet(WsaSettings.ENABLE_FOR_OPTIONAL, wsaSettings.isEnableForOptional());
		} else {
			defaultWsaSettings();
		}
	}

	public void setWsdlSettings(SoapuiWsdlSettings wsdlSettings) {
		if(wsdlSettings != null) {
			
			if (this.getString(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1).equals(HttpSettings.HTTP_VERSION_0_9)) {
	        	this.setString(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1);
	        }
	        setIfNotSet(HttpSettings.HTTP_VERSION, HttpSettings.HTTP_VERSION_1_1);
	        setIfNotSet(HttpSettings.MAX_TOTAL_CONNECTIONS, 2000);
	        setIfNotSet(HttpSettings.RESPONSE_COMPRESSION, true);
	        setIfNotSet(HttpSettings.LEAVE_MOCKENGINE, true);
	        setIfNotSet(HttpSettings.RESPONSE_COMPRESSION, true);
	        setIfNotSet(HttpSettings.INCLUDE_REQUEST_IN_TIME_TAKEN, true);
	        setIfNotSet(HttpSettings.INCLUDE_RESPONSE_IN_TIME_TAKEN, true);
	        setIfNotSet(HttpSettings.LEAVE_MOCKENGINE, true);
	        setIfNotSet(HttpSettings.START_MOCK_SERVICE, true);
		} else {
			defaultWsdlSettings();
		}
	}

	public void setWsiSettings(SoapuiWSISettings wsiSettings) {
		if(wsiSettings != null) {
			setIfNotSet(WSISettings.VERBOSE, wsiSettings.isVerbose());
			setIfNotSet(WSISettings.PROFILE_TYPE, wsiSettings.getProfileType().value());
			setIfNotSet(WSISettings.CORRELATION_TYPE, wsiSettings.getCorrelationType().value());
			setIfNotSet(WSISettings.MESSAGE_ENTRY, wsiSettings.isMessageEntry());
			setIfNotSet(WSISettings.FAILURE_MESSAGE, wsiSettings.isFailureMessage());
			setIfNotSet(WSISettings.ASSERTION_DESCRIPTION, wsiSettings.isAssertionDescription());
			setIfNotSet(WSISettings.WSI_LOCATION, wsiSettings.getLocation());
			setIfNotSet(WSISettings.SHOW_LOG, wsiSettings.isShowLog());
			setIfNotSet(WSISettings.OUTPUT_FOLDER, wsiSettings.getOutputFolder());
		} else {
			defaultWsiSettings();
		}
	}
	
    private void setIfNotSet(String id, boolean value) {
        if (!this.isSet(id)) {
        	this.setBoolean(id, value);
        }
    }

    private void setIfNotSet(String id, String value) {
        if (!this.isSet(id) && !StringUtils.isNullOrEmpty(value)) {
        	this.setString(id, value);
        }
    }

    private void setIfNotSet(String id, long value) {
        if (!this.isSet(id)) {
        	this.setLong(id, value);
        }
    }
    
    @Override
    public void setBoolean(String id, boolean value) {
    	super.setBoolean(id, value);
    	if(this.parent != null) {
    		this.parent.setBoolean(id, value);
    	}
    }
    
    @Override
    public void setString(String id, String value) {
    	super.setString(id, value);
    	if(this.parent != null) {
    		this.parent.setString(id, value);
    	}
    }
    
    @Override
    public void setLong(String id, long value) {
    	super.setLong(id, value);
    	if(this.parent != null) {
    		this.parent.setLong(id, value);
    	}
    }
	
}
