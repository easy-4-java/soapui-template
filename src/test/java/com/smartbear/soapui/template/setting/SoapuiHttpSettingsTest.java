package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoapuiHttpSettingsTest {

    private SoapuiHttpSettings settings;

    @Before
    public void setUp() {
        settings = new SoapuiHttpSettings();
    }

    @Test
    public void shouldHaveDefaultHttpVersion11() {
        assertEquals(SoapuiHttpVersion.HTTP_VERSION_1_1, settings.getHttpVersion());
    }

    @Test
    public void shouldSetAndGetHttpVersion() {
        settings.setHttpVersion(SoapuiHttpVersion.HTTP_VERSION_1_0);
        assertEquals(SoapuiHttpVersion.HTTP_VERSION_1_0, settings.getHttpVersion());
    }

    @Test
    public void shouldHaveNullUseragentByDefault() {
        assertNull(settings.getUseragent());
    }

    @Test
    public void shouldSetAndGetUseragent() {
        settings.setUseragent("CustomAgent/1.0");
        assertEquals("CustomAgent/1.0", settings.getUseragent());
    }

    @Test
    public void shouldHaveDefaultRequestCompressionNone() {
        assertEquals(SoapuiHttpRequestCompression.ALG_NONE, settings.getRequestCompression());
    }

    @Test
    public void shouldSetAndGetRequestCompression() {
        settings.setRequestCompression(SoapuiHttpRequestCompression.ALG_GZIP);
        assertEquals(SoapuiHttpRequestCompression.ALG_GZIP, settings.getRequestCompression());
    }

    @Test
    public void shouldHaveDefaultResponseCompressionFalse() {
        assertFalse(settings.isResponseCompression());
    }

    @Test
    public void shouldSetAndGetResponseCompression() {
        settings.setResponseCompression(true);
        assertTrue(settings.isResponseCompression());
    }

    @Test
    public void shouldHaveDefaultDisableResponseDecompressionFalse() {
        assertFalse(settings.isDisableResponseDecompression());
    }

    @Test
    public void shouldSetAndGetDisableResponseDecompression() {
        settings.setDisableResponseDecompression(true);
        assertTrue(settings.isDisableResponseDecompression());
    }

    @Test
    public void shouldHaveDefaultCloseConnectionsFalse() {
        assertFalse(settings.isCloseConnections());
    }

    @Test
    public void shouldSetAndGetCloseConnections() {
        settings.setCloseConnections(true);
        assertTrue(settings.isCloseConnections());
    }

    @Test
    public void shouldHaveDefaultChunkingThresholdMinus1() {
        assertEquals(-1, settings.getChunkingThreshold());
    }

    @Test
    public void shouldSetAndGetChunkingThreshold() {
        settings.setChunkingThreshold(1024);
        assertEquals(1024, settings.getChunkingThreshold());
    }

    @Test
    public void shouldHaveDefaultAuthenticatePreemptivelyFalse() {
        assertFalse(settings.isAuthenticatePreemptively());
    }

    @Test
    public void shouldSetAndGetAuthenticatePreemptively() {
        settings.setAuthenticatePreemptively(true);
        assertTrue(settings.isAuthenticatePreemptively());
    }

    @Test
    public void shouldHaveDefaultExpectContinueFalse() {
        assertFalse(settings.isExpectContinue());
    }

    @Test
    public void shouldSetAndGetExpectContinue() {
        settings.setExpectContinue(true);
        assertTrue(settings.isExpectContinue());
    }

    @Test
    public void shouldHaveDefaultEncodedUrlsFalse() {
        assertFalse(settings.isEncodedUrls());
    }

    @Test
    public void shouldSetAndGetEncodedUrls() {
        settings.setEncodedUrls(true);
        assertTrue(settings.isEncodedUrls());
    }

    @Test
    public void shouldHaveDefaultForwardSlashesFalse() {
        assertFalse(settings.isForwardSlashes());
    }

    @Test
    public void shouldSetAndGetForwardSlashes() {
        settings.setForwardSlashes(true);
        assertTrue(settings.isForwardSlashes());
    }

    @Test
    public void shouldHaveNullBindAddressByDefault() {
        assertNull(settings.getBindAddress());
    }

    @Test
    public void shouldSetAndGetBindAddress() {
        settings.setBindAddress("127.0.0.1");
        assertEquals("127.0.0.1", settings.getBindAddress());
    }

    @Test
    public void shouldHaveDefaultIncludeRequestInTimeTakenFalse() {
        assertFalse(settings.isIncludeRequestInTimeTaken());
    }

    @Test
    public void shouldSetAndGetIncludeRequestInTimeTaken() {
        settings.setIncludeRequestInTimeTaken(true);
        assertTrue(settings.isIncludeRequestInTimeTaken());
    }

    @Test
    public void shouldHaveDefaultIncludeResponseInTimeTakenFalse() {
        assertFalse(settings.isIncludeResponseInTimeTaken());
    }

    @Test
    public void shouldSetAndGetIncludeResponseInTimeTaken() {
        settings.setIncludeResponseInTimeTaken(true);
        assertTrue(settings.isIncludeResponseInTimeTaken());
    }

    @Test
    public void shouldHaveDefaultSocketTimeoutZero() {
        assertEquals(0, settings.getSocketTimeout());
    }

    @Test
    public void shouldSetAndGetSocketTimeout() {
        settings.setSocketTimeout(30000);
        assertEquals(30000, settings.getSocketTimeout());
    }

    @Test
    public void shouldHaveDefaultMaxResponseSizeZero() {
        assertEquals(0, settings.getMaxResponseSize());
    }

    @Test
    public void shouldSetAndGetMaxResponseSize() {
        settings.setMaxResponseSize(1024);
        assertEquals(1024, settings.getMaxResponseSize());
    }

    @Test
    public void shouldHaveDefaultMaxConnectionsPerHost500() {
        assertEquals(500, settings.getMaxConnectionsPerHost());
    }

    @Test
    public void shouldSetAndGetMaxConnectionsPerHost() {
        settings.setMaxConnectionsPerHost(100);
        assertEquals(100, settings.getMaxConnectionsPerHost());
    }

    @Test
    public void shouldHaveDefaultMaxTotalConnections2000() {
        assertEquals(2000, settings.getMaxTotalConnections());
    }

    @Test
    public void shouldSetAndGetMaxTotalConnections() {
        settings.setMaxTotalConnections(5000);
        assertEquals(5000, settings.getMaxTotalConnections());
    }

    @Test
    public void shouldHaveDefaultLeaveMockengineTrue() {
        assertTrue(settings.isLeaveMockengine());
    }

    @Test
    public void shouldSetAndGetLeaveMockengine() {
        settings.setLeaveMockengine(false);
        assertFalse(settings.isLeaveMockengine());
    }

    @Test
    public void shouldHaveDefaultEnableMockWireLogFalse() {
        assertFalse(settings.isEnableMockWireLog());
    }

    @Test
    public void shouldSetAndGetEnableMockWireLog() {
        settings.setEnableMockWireLog(true);
        assertTrue(settings.isEnableMockWireLog());
    }

    @Test
    public void shouldHaveDefaultStartMockServiceFalse() {
        assertFalse(settings.isStartMockService());
    }

    @Test
    public void shouldSetAndGetStartMockService() {
        settings.setStartMockService(true);
        assertTrue(settings.isStartMockService());
    }

    @Test
    public void shouldHaveDefaultRemoveEmptyContentFalse() {
        assertFalse(settings.isRemoveEmptyContent());
    }

    @Test
    public void shouldSetAndGetRemoveEmptyContent() {
        settings.setRemoveEmptyContent(true);
        assertTrue(settings.isRemoveEmptyContent());
    }

    @Test
    public void shouldHaveDefaultStripWhitespacesFalse() {
        assertFalse(settings.isStripWhitespaces());
    }

    @Test
    public void shouldSetAndGetStripWhitespaces() {
        settings.setStripWhitespaces(true);
        assertTrue(settings.isStripWhitespaces());
    }

    @Test
    public void shouldHaveDefaultDisableMultipartAttachmentsTrue() {
        assertTrue(settings.isDisableMultipartAttachments());
    }

    @Test
    public void shouldSetAndGetDisableMultipartAttachments() {
        settings.setDisableMultipartAttachments(false);
        assertFalse(settings.isDisableMultipartAttachments());
    }

    @Test
    public void shouldHaveNullDumpFileByDefault() {
        assertNull(settings.getDumpFile());
    }

    @Test
    public void shouldSetAndGetDumpFile() {
        settings.setDumpFile("/tmp/dump.log");
        assertEquals("/tmp/dump.log", settings.getDumpFile());
    }

    @Test
    public void shouldHaveDefaultFollowRedirectsTrue() {
        assertTrue(settings.isFollowRedirects());
    }

    @Test
    public void shouldSetAndGetFollowRedirects() {
        settings.setFollowRedirects(false);
        assertFalse(settings.isFollowRedirects());
    }

    @Test
    public void shouldHaveDefaultRequestHeadersNotNull() {
        assertNotNull(settings.getRequestHeaders());
    }

    @Test
    public void shouldSetAndGetRequestHeaders() {
        com.eviware.soapui.support.types.StringToStringsMap headers = new com.eviware.soapui.support.types.StringToStringsMap();
        settings.setRequestHeaders(headers);
        assertSame(headers, settings.getRequestHeaders());
    }

    @Test
    public void shouldHaveDefaultEncodeAttachmentsFalse() {
        assertFalse(settings.isEncodeAttachments());
    }

    @Test
    public void shouldSetAndGetEncodeAttachments() {
        settings.setEncodeAttachments(true);
        assertTrue(settings.isEncodeAttachments());
    }

    @Test
    public void shouldHaveDefaultInlineResponseAttachmentsFalse() {
        assertFalse(settings.isInlineResponseAttachments());
    }

    @Test
    public void shouldSetAndGetInlineResponseAttachments() {
        settings.setInlineResponseAttachments(true);
        assertTrue(settings.isInlineResponseAttachments());
    }

    @Test
    public void shouldHaveDefaultExpandMtomResponseAttachmentsFalse() {
        assertFalse(settings.isExpandMtomResponseAttachments());
    }

    @Test
    public void shouldSetAndGetExpandMtomResponseAttachments() {
        settings.setExpandMtomResponseAttachments(true);
        assertTrue(settings.isExpandMtomResponseAttachments());
    }

    @Test
    public void shouldHaveDefaultForceMtomFalse() {
        assertFalse(settings.isForceMtom());
    }

    @Test
    public void shouldSetAndGetForceMtom() {
        settings.setForceMtom(true);
        assertTrue(settings.isForceMtom());
    }

    @Test
    public void shouldHaveDefaultInlineFilesEnabledFalse() {
        assertFalse(settings.isInlineFilesEnabled());
    }

    @Test
    public void shouldSetAndGetInlineFilesEnabled() {
        settings.setInlineFilesEnabled(true);
        assertTrue(settings.isInlineFilesEnabled());
    }

    @Test
    public void shouldHaveDefaultSkipSoapActionFalse() {
        assertFalse(settings.isSkipSoapAction());
    }

    @Test
    public void shouldSetAndGetSkipSoapAction() {
        settings.setSkipSoapAction(true);
        assertTrue(settings.isSkipSoapAction());
    }
}
