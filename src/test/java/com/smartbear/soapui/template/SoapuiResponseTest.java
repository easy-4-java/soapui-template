package com.smartbear.soapui.template;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eviware.soapui.impl.wsdl.WsdlRequest;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.model.iface.Submit.Status;

public class SoapuiResponseTest {

    @Test
    public void shouldStoreAndRetrieveAllFields() {
        WsdlRequest request = null;
        Response response = null;
        Status status = Status.FINISHED;
        Exception error = new RuntimeException("test error");

        SoapuiResponse<WsdlRequest> soapuiResponse = new SoapuiResponse<>(request, response, status, error);

        assertNull(soapuiResponse.getRequest());
        assertNull(soapuiResponse.getResponse());
        assertEquals(Status.FINISHED, soapuiResponse.getStatus());
        assertNotNull(soapuiResponse.getError());
        assertEquals("test error", soapuiResponse.getError().getMessage());
    }

    @Test
    public void shouldHandleNullError() {
        SoapuiResponse<WsdlRequest> soapuiResponse = new SoapuiResponse<>(null, null, Status.FINISHED, null);

        assertNull(soapuiResponse.getError());
        assertEquals(Status.FINISHED, soapuiResponse.getStatus());
    }

    @Test
    public void shouldHandleCancelledStatus() {
        SoapuiResponse<WsdlRequest> soapuiResponse = new SoapuiResponse<>(null, null, Status.CANCELED, null);
        assertEquals(Status.CANCELED, soapuiResponse.getStatus());
    }

    @Test
    public void shouldHandleErrorException() {
        Exception error = new Exception("connection failed");
        SoapuiResponse<WsdlRequest> soapuiResponse = new SoapuiResponse<>(null, null, Status.ERROR, error);

        assertEquals(Status.ERROR, soapuiResponse.getStatus());
        assertEquals("connection failed", soapuiResponse.getError().getMessage());
    }

    @Test
    public void shouldHandleInitializedStatus() {
        SoapuiResponse<WsdlRequest> soapuiResponse = new SoapuiResponse<>(null, null, Status.INITIALIZED, null);
        assertEquals(Status.INITIALIZED, soapuiResponse.getStatus());
    }

    @Test
    public void shouldHandleRunningStatus() {
        SoapuiResponse<WsdlRequest> soapuiResponse = new SoapuiResponse<>(null, null, Status.RUNNING, null);
        assertEquals(Status.RUNNING, soapuiResponse.getStatus());
    }
}
