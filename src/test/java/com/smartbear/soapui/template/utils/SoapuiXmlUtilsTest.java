package com.smartbear.soapui.template.utils;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SoapuiXmlUtilsTest {

    private Document createDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    @Test
    public void shouldGetLocalNameFromElement() throws Exception {
        Document doc = createDocument();
        Element element = doc.createElementNS("http://example.com", "test:myElement");
        String name = SoapuiXmlUtils.getName(element);
        assertNotNull(name);
        assertTrue(name.length() > 0);
    }

    @Test
    public void shouldGetLocalNameFromNode() throws Exception {
        Document doc = createDocument();
        Element element = doc.createElementNS("http://example.com", "test:myNode");
        String name = SoapuiXmlUtils.getName((Node) element);
        assertNotNull(name);
    }

    @Test
    public void shouldFallbackToTagNameWhenLocalNameIsNull() throws Exception {
        Document doc = createDocument();
        Element element = doc.createElement("simpleElement");
        String name = SoapuiXmlUtils.getName(element);
        assertEquals("simpleElement", name);
    }

    @Test
    public void shouldFallbackToNodeNameWhenLocalNameIsNull() throws Exception {
        Document doc = createDocument();
        Element element = doc.createElement("simpleNode");
        String name = SoapuiXmlUtils.getName((Node) element);
        assertEquals("simpleNode", name);
    }

    @Test
    public void shouldCountElementsBeforeGivenNode() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        Element child1 = doc.createElement("target");
        Element child2 = doc.createElement("other");
        Element child3 = doc.createElement("target");
        parent.appendChild(child1);
        parent.appendChild(child2);
        parent.appendChild(child3);

        int count = SoapuiXmlUtils.countElementsBefore(child3, "target");
        assertEquals(1, count);
    }

    @Test
    public void shouldReturnZeroWhenNoElementsBefore() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        Element child1 = doc.createElement("target");
        parent.appendChild(child1);

        int count = SoapuiXmlUtils.countElementsBefore(child1, "target");
        assertEquals(0, count);
    }

    @Test
    public void shouldCountChildElementsOfType() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        parent.appendChild(doc.createElement("child1"));
        parent.appendChild(doc.createTextNode("text"));
        parent.appendChild(doc.createElement("child2"));
        parent.appendChild(doc.createComment("comment"));

        int elementCount = SoapuiXmlUtils.countChildElementsOfType(parent, Node.ELEMENT_NODE);
        assertEquals(2, elementCount);

        int textCount = SoapuiXmlUtils.countChildElementsOfType(parent, Node.TEXT_NODE);
        assertEquals(1, textCount);

        int commentCount = SoapuiXmlUtils.countChildElementsOfType(parent, Node.COMMENT_NODE);
        assertEquals(1, commentCount);
    }

    @Test
    public void shouldReturnZeroForEmptyElement() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("empty");
        int count = SoapuiXmlUtils.countChildElementsOfType(parent, Node.ELEMENT_NODE);
        assertEquals(0, count);
    }

    @Test
    public void shouldGetFirstChildByType() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        parent.appendChild(doc.createTextNode("text"));
        parent.appendChild(doc.createElement("child"));

        Node firstElement = SoapuiXmlUtils.getFirstChildByType(parent, Node.ELEMENT_NODE);
        assertNotNull(firstElement);
        assertEquals("child", firstElement.getNodeName());
    }

    @Test
    public void shouldReturnNullWhenNoChildOfType() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        parent.appendChild(doc.createTextNode("text"));

        Node result = SoapuiXmlUtils.getFirstChildByType(parent, Node.ELEMENT_NODE);
        assertNull(result);
    }

    @Test
    public void shouldReturnNullForEmptyParent() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("empty");
        Node result = SoapuiXmlUtils.getFirstChildByType(parent, Node.ELEMENT_NODE);
        assertNull(result);
    }

    @Test
    public void shouldAssertIsCollectionWhenCommentPresent() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        Comment comment = doc.createComment("Zero or more repetitions:");
        parent.appendChild(comment);
        parent.appendChild(doc.createElement("item"));

        assertTrue(SoapuiXmlUtils.assertIsCollection(parent));
    }

    @Test
    public void shouldAssertNotCollectionWhenCommentAbsent() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        parent.appendChild(doc.createElement("item"));

        assertFalse(SoapuiXmlUtils.assertIsCollection(parent));
    }

    @Test
    public void shouldAssertNotCollectionWhenCommentDoesNotMatch() throws Exception {
        Document doc = createDocument();
        Element parent = doc.createElement("parent");
        Comment comment = doc.createComment("some other comment");
        parent.appendChild(comment);

        assertFalse(SoapuiXmlUtils.assertIsCollection(parent));
    }
}
