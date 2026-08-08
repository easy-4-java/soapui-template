package com.smartbear.soapui.template.setting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SoapuiHttpRequestCompressionTest {

    @Test
    public void shouldReturnCorrectAlgString() {
        assertEquals("None", SoapuiHttpRequestCompression.ALG_NONE.alg());
        assertEquals("gzip", SoapuiHttpRequestCompression.ALG_GZIP.alg());
        assertEquals("deflate", SoapuiHttpRequestCompression.ALG_DEFLATE.alg());
    }

    @Test
    public void shouldContainThreeValues() {
        SoapuiHttpRequestCompression[] values = SoapuiHttpRequestCompression.values();
        assertEquals(3, values.length);
    }

    @Test
    public void shouldResolveFromName() {
        assertEquals(SoapuiHttpRequestCompression.ALG_NONE, SoapuiHttpRequestCompression.valueOf("ALG_NONE"));
        assertEquals(SoapuiHttpRequestCompression.ALG_GZIP, SoapuiHttpRequestCompression.valueOf("ALG_GZIP"));
        assertEquals(SoapuiHttpRequestCompression.ALG_DEFLATE, SoapuiHttpRequestCompression.valueOf("ALG_DEFLATE"));
    }
}
