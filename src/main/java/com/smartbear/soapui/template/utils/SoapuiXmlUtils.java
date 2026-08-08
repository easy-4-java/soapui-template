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
package com.smartbear.soapui.template.utils;

import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utility class providing helper methods for XML DOM node operations used in
 * SOAP UI request and response processing.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 3.0.0
 */
public class SoapuiXmlUtils {

	/**
	 * Returns the local name of the given node, falling back to the node name
	 * if the local name is not available.
	 *
	 * @param node the DOM node
	 * @return the local name or node name
	 */
	public static String getName(Node node) {
		String name = node.getLocalName();
		if (name != null) {
			return name;
		}
		return node.getNodeName();
	}
	
	/**
	 * Returns the local name of the given element, falling back to the tag name
	 * if the local name is not available.
	 *
	 * @param element the DOM element
	 * @return the local name or tag name
	 */
	public static String getName(Element element) {
		String name = element.getLocalName();
		if (name != null) {
			return name;
		}
		return element.getTagName();
	}
	
	/**
	 * Counts the number of sibling elements with the given tag name that appear
	 * before the specified node.
	 *
	 * @param node    the reference node
	 * @param tagName the tag name to count
	 * @return the number of preceding siblings with the given tag name
	 */
	public static int countElementsBefore(Node node, String tagName) {
		
		Node parent = node.getParentNode();

		NodeList siblings = parent.getChildNodes();
		int count = 0;
		int siblingCount = siblings.getLength();

		for (int i = 0; i < siblingCount; ++i) {
			Node sibling = siblings.item(i);

			if (sibling == node) {
				break;
			}
			if ((sibling.getNodeType() == 1) && (((Element) sibling).getTagName().equals(tagName))) {
				++count;
			}
		}

		return count;
	}
	
	
	/**
	 * Counts the number of direct child nodes of the given element that match the
	 * specified node type.
	 *
	 * @param element  the parent node
	 * @param nodeType the DOM node type to count (e.g., {@link Node#ELEMENT_NODE})
	 * @return the number of child nodes matching the type
	 */
	public static int countChildElementsOfType(Node element, int nodeType) {
		NodeList children = element.getChildNodes();
		int count = 0;		
		for (int i = 0; i < children.getLength(); ++i) {
			Node child = children.item(i);
			if (child.getNodeType() == nodeType) {
				count += 1;
			}
		}
		return count;
    }
	 
	/**
	 * Returns the first direct child node of the given element that matches the
	 * specified node type.
	 *
	 * @param element  the parent node
	 * @param nodeType the DOM node type to find
	 * @return the first matching child node, or {@code null} if none found
	 */
	public static Node getFirstChildByType(Node element, int nodeType) {
		NodeList children = element.getChildNodes();
		int childCount = children.getLength();

		for (int i = 0; i < childCount; ++i) {
			Node child = children.item(i);
			if (child.getNodeType() == nodeType) {
				return child;
			}
		}

		return null;
	}
	
	/**
	 * Determines whether the given element represents a collection by checking
	 * if its first child comment contains the text "Zero or more repetitions".
	 *
	 * @param element the DOM node to check
	 * @return {@code true} if the element is a collection, {@code false} otherwise
	 */
	public static boolean assertIsCollection(Node element) {
		Comment firstComment = (Comment) SoapuiXmlUtils.getFirstChildByType(element, Node.COMMENT_NODE);
		return ((firstComment != null) && (firstComment.getNodeValue().indexOf("Zero or more repetitions") != -1));
	}
	
}
