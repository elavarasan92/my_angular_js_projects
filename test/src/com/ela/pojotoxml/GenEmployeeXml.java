
package com.ela.pojotoxml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

public class GenEmployeeXml {
	
	public String genXml()
	
	{
		  PojoXml pojoxml = PojoXmlFactory.createPojoXml();

          Employee employee = new Employee();
          Address address = new Address();
          
          employee.setName("Mike");
          employee.setAge(45);
          employee.setSalary(20000.45);
          address.setAddress1("Sagar");
          address.setAddress2("Nerul");
          address.setCity("Mumbai");
          address.setZip(002345);
          employee.setAddress(address);
          String xml = pojoxml.getXml(employee);
          
          System.out.println(xml);
          return xml;
	}
	
	public void writeFile(String yourXML) throws IOException{
	    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\elavarasan.natarajan\\Desktop\\test.xml"));
	    try { 
	        out.write(yourXML);
	        System.out.println("try BLOck@@@@@@@@@@@@@@@@@@@@@@@@@@");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        out.close();
	    }
	}
        
        public static void main(String[] args) throws IOException {
              
        	GenEmployeeXml genEmployeeXml = new GenEmployeeXml();
        	genEmployeeXml.writeFile(genEmployeeXml.genXml());

        }

}