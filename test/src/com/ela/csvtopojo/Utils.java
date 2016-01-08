package com.ela.csvtopojo;

import javax.xml.XMLConstants;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
/**
 * Few simple utils to read DOM. This is originally from the Jakarta Commons Modeler.
 * 
 * @author Costin Manolache
 */
public class Utils {
  private static final String XMLNAMESPACE = "xmlns";
  /**
   * Set a namespace/prefix on an element if it is not set already. First off, it searches for the element
   * for the prefix associated with the specified namespace. If the prefix isn't null, then this is
   * returned. Otherwise, it creates a new attribute using the namespace/prefix passed as parameters.
   * 
   * @param element
   * @param namespace
   * @param prefix
   * @return the prefix associated with the set namespace
   */
  public static String setNamespace(Element element, String namespace, String prefix) {
      String pre = getPrefixRecursive(element, namespace);
      if (pre != null) {
          return pre;
      }
      element.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:" + prefix, namespace);
      return prefix;
  }
  public static String getPrefixRecursive(Element el, String ns) {
    String prefix = getPrefix(el, ns);
    if (prefix == null && el.getParentNode() instanceof Element) {
        prefix = getPrefixRecursive((Element)el.getParentNode(), ns);
    }
    return prefix;
  }
  public static String getPrefix(Element el, String ns) {
    NamedNodeMap atts = el.getAttributes();
    for (int i = 0; i < atts.getLength(); i++) {
        Node node = atts.item(i);
        String name = node.getNodeName();
        if (ns.equals(node.getNodeValue())
            && (name != null && (XMLNAMESPACE.equals(name) || name.startsWith(XMLNAMESPACE + ":")))) {
            return node.getPrefix();
        }
    }
    return null;
}
  
  
  
  public static void main(String [] args)
  {
	  Document doc = new Document();
	// Create the root node and its text node, using the document as a factory
	Element root = myDocument.createElement("myRootElement");
      
	  Utils.setNamespace(informationTable, "http://www.sec.gov/edgar/document/thirteenf/informationtable", null);
  }
}
