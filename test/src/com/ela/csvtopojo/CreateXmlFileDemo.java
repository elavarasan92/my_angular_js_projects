package com.ela.csvtopojo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;

public class CreateXmlFileDemo {
	
   public static void main(String argv[]) {

      try {
         DocumentBuilderFactory dbFactory =
         DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = 
            dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         CSVReader reader = new CSVReader(new FileReader("E:\\SharedFolder\\Rajesh\\13_F_Data.csv"));
         // root element
         Element rootElement = doc.createElement("informationTable");
         doc.appendChild(rootElement);
         rootElement.setAttribute("xmlns", "http://www.sec.gov/edgar/document/thirteenf/informationtable");
         rootElement.setAttribute("xmlns:xsi", "http://wwww.w3.org/2001/XMLSchema-instance");

         String[] nextLine;
		 
		 nextLine=reader.readNext();                      //to skip the first line
		 
		  while ((nextLine = reader.readNext()) != null) {
			  
//			  for(int i=0;i<nextLine.length;i++)
//		      {
			  Element infoTable = doc.createElement("infoTable");
		         rootElement.appendChild(infoTable);
		         
		         
		         Element nameOfIssuer = doc.createElement("nameOfIssuer");
		         nameOfIssuer.appendChild(  doc.createTextNode(nextLine[0]));
		         infoTable.appendChild(nameOfIssuer);
		         
		         
		         Element titleOfClass = doc.createElement("titleOfClass");
		         titleOfClass.appendChild(  doc.createTextNode(nextLine[1]));
		         infoTable.appendChild(titleOfClass);
		         
		         Element cusip = doc.createElement("cusip");
		         cusip.appendChild(  doc.createTextNode(nextLine[2]));
		         infoTable.appendChild(cusip);
		         
		         Element value = doc.createElement("value");
		         value.appendChild(  doc.createTextNode(nextLine[3]));
		         infoTable.appendChild(value);
		         
		         
		         Element shrsOrPrnAmt = doc.createElement("shrsOrPrnAmt");
		         infoTable.appendChild(shrsOrPrnAmt);
		             
		         
		         Element sshPrnamt = doc.createElement("sshPrnamt");
		         sshPrnamt.appendChild(  doc.createTextNode(nextLine[4]));
		         shrsOrPrnAmt.appendChild(sshPrnamt);
		         
		         
		         Element sshPrnamtType = doc.createElement("sshPrnamtType");
		         sshPrnamtType.appendChild(  doc.createTextNode(nextLine[5]));
		         shrsOrPrnAmt.appendChild(sshPrnamtType);
		         
		         Element putCall = doc.createElement("putCall");
		         value.appendChild(  doc.createTextNode(nextLine[6]));
		         infoTable.appendChild(putCall);
		         
		         Element investmentDiscretion = doc.createElement("investmentDiscretion");
		         value.appendChild(  doc.createTextNode(nextLine[7]));
		         infoTable.appendChild(investmentDiscretion);
		         
		         Element otherManager = doc.createElement("otherManager");
		         value.appendChild(  doc.createTextNode(nextLine[8]));
		         infoTable.appendChild(otherManager);
		         
		         
		         
		         Element votingAuthority = doc.createElement("votingAuthority");
		         infoTable.appendChild(votingAuthority);
		             
		         
		         Element sole = doc.createElement("sole");
		         sole.appendChild(  doc.createTextNode(nextLine[9]));
		         votingAuthority.appendChild(sole);
		         
		         
		         Element shared = doc.createElement("shared");
		         shared.appendChild(  doc.createTextNode(nextLine[10]));
		         votingAuthority.appendChild(shared);
		         
		         Element none = doc.createElement("none");
		         none.appendChild(  doc.createTextNode(nextLine[11]));
		         votingAuthority.appendChild(none);
	//	      }
			  
		  }
         //  supercars element
        

         TransformerFactory transformerFactory =
         TransformerFactory.newInstance();
         Transformer transformer =
         transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result =
         new StreamResult(new File("C:\\Users\\elavarasan.natarajan\\Desktop\\output1.xml"));
         transformer.transform(source, result);
         // Output to console for testing
         StreamResult consoleResult =
         new StreamResult(System.out);
         transformer.transform(source, consoleResult);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
