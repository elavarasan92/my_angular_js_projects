package com.ela.pojotoxml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.pojoxml.core.PojoXml;
import org.pojoxml.core.PojoXmlFactory;

public class GenInfoTableXml {

	
public String genXML()
{
	 PojoXml pojoxml = PojoXmlFactory.createPojoXml();
	 
	 InformationTableList informationTableList = new InformationTableList();
	 List infoList = new ArrayList<>();

      InformationTable informationTable = new InformationTable();
     Voting voting = new Voting();
    
     informationTable.setNameOfIssuer("123 Co");
     informationTable.setTitleOfClass("COM");
     informationTable.setCusip("00206R102");
     informationTable.setValue(4467000);
     informationTable.setSshPrnamt(126200);
     informationTable.setSshPrnamtType("SH");
     informationTable.setPutCall("Put");
     informationTable.setInvestmentDiscretion("SOLE");
     informationTable.setOtherManager(12);
     
     
     voting.setSole(0);
     voting.setShared(0);
     voting.setNone(126200);
     
     informationTable.setVoting(voting);
     
     infoList.add(informationTable);
     
     informationTable.setNameOfIssuer("123 Co");
     informationTable.setTitleOfClass("COM");
     informationTable.setCusip("00206R102");
     informationTable.setValue(4467000);
     informationTable.setSshPrnamt(126200);
     informationTable.setSshPrnamtType("SH");
     informationTable.setPutCall("Put");
     informationTable.setInvestmentDiscretion("SOLE");
     informationTable.setOtherManager(12);
     
     
     voting.setSole(0);
     voting.setShared(0);
     voting.setNone(126200);
     
     informationTable.setVoting(voting);

     
     infoList.add(informationTable);
     
     informationTableList.setInformationTableList(infoList);
     
     String xml = pojoxml.getXml(informationTableList);
     System.out.println(xml);
     return xml;
}



public void writeFile(String yourXML) throws IOException{
    BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\elavarasan.natarajan\\Desktop\\output.xml"));
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
               

        	GenInfoTableXml genInfoTableXml = new GenInfoTableXml();
        	genInfoTableXml.writeFile(genInfoTableXml.genXML());
        }
}
