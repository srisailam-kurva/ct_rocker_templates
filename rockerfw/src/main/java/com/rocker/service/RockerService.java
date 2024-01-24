package com.rocker.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class RockerService {

    public String getTemplate(){

        String name="sree";


        String template1=templates.inv.template(name)
                        .render().toString();

        log.info("completed");
//        log.info(template);

        String outputFile = "C:\\JAVA\\vss.pdf";

        try  {
            HtmlConverter.convertToPdf(template1, new FileOutputStream(outputFile), new ConverterProperties());

            System.out.println("Conversion completed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "done";
    }

}
