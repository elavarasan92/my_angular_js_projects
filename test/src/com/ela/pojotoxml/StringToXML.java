package com.ela.pojotoxml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StringToXML {
public static void main(String[] args) {
String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"></soap:Envelope>";

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

DocumentBuilder builder;
try
{
builder = factory.newDocumentBuilder();

// Use String reader
Document document = builder.parse( new InputSource(
        new StringReader( xmlString ) ) );

TransformerFactory tranFactory = TransformerFactory.newInstance();
Transformer aTransformer = tranFactory.newTransformer();
Source src = new DOMSource( document );
Result dest = new StreamResult( new File( "C:\\Users\\elavarasan.natarajan\\Desktop\\test.xml" ) );
aTransformer.transform( src, dest );
} catch (Exception e)
{
e.printStackTrace();
}
}
}