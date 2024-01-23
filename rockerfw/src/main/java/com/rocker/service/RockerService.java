package com.rocker.service;

import com.fizzed.rocker.Rocker;
import com.fizzed.rocker.runtime.RockerRuntime;
import com.rocker.model.CreditNote;
import com.rocker.model.Customer;
import com.rocker.model.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Service
@Slf4j
public class RockerService {

    private String lowi_style="src/main/java/views/lowi_style.css";

    //    @Value("${dge.template.lowimain.css}")
    private String lowi_main="src/main/java/views/lowi_main.css";

    private String logo="src/main/java/views//JOiNew.png";

    public String getTemplate(){

        CreditNote creditNote=new CreditNote();
//        creditNote.setId(1);
        creditNote.setCustomer(new Customer("mr","k","sree","yadhav","1",1,
                "1234","000","100","1-104","","509204","nandipet",
                "","mbnr","ts","600000","IN","ss12@gmail.com","english"));
        creditNote.setReferenceNumber(creditNote.getReferenceNumber());
        creditNote.setTaxDescription(creditNote.getTaxDescription());
        creditNote.setCreatedAt(new Date());
        creditNote.setIssueDate("11/01/2024");
        creditNote.setFilename("vf-invoice");
        creditNote.setTax(1);
        creditNote.setDues(1.0F);
        creditNote.setConsumptions(0.0F);
        creditNote.setOthers(1.0F);
        creditNote.setTotalAmount(creditNote.getTotalAmount());
        creditNote.setTaxAmount(creditNote.getTaxAmount());
        creditNote.setNetAmount(creditNote.getNetAmount());
        creditNote.setGenerated(true);
        creditNote.setInvoices(List.of(new Invoice("1234455","11/1/24",100.0f),
                new Invoice("010101","1/1/24",12.0f)));

//        log.info(String.valueOf(creditNote));

        Map<String,Object> contentMap=new HashMap<>();
        contentMap.put("lowi_style",lowi_style);
//        log.info(lowi_style);
        contentMap.put("lowi_main",lowi_main);
        contentMap.put("logo",logo);
//        log.info(contentMap.toString());

        Map<String, Properties> properties = new HashMap<>();
        Map<String,String> propertiesValues=new HashMap<>();
        Resource resource;
        String propertyFile = "language_es.properties";
        try {
            resource = new ClassPathResource(propertyFile);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            for(Map.Entry<Object,Object> entry:props.entrySet()){
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                propertiesValues.put(key, value);
            }
            properties.put("properties", props);
//            log.info("{} property file found", propertyFile);
        } catch (IOException e) {
//            log.info("{} property file not found", propertyFile);
        }

//        RockerRuntime.getInstance().setReloading(true);
        String template = templates.lowi_es.template(creditNote, contentMap, propertiesValues)
                .render()
                .toString();

        log.info("completed");
//        log.info(template);

//        String outputFile = "C:\\JAVA\\vff.pdf";
//        try (FileOutputStream os = new FileOutputStream(outputFile)) {
//            ITextRenderer renderer = new ITextRenderer();
////            renderer.getSharedContext().setBaseURL("file:///C:/Users/Srisailam/Downloads/rocker/src/main/java/views");
//            renderer.getSharedContext().setUserAgentCallback(new MyUserAgent(renderer.getOutputDevice()));
//
//            renderer.setDocumentFromString(template);
//            renderer.layout();
//            renderer.createPDF(os, true);
//            renderer.finishPDF();
//            log.info("done");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "done";
    }

}
