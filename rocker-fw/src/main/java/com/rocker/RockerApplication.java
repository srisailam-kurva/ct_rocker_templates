package com.rocker;

import com.fizzed.rocker.runtime.RockerRuntime;
import com.fizzed.rocker.runtime.StringBuilderOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class RockerApplication {

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("directcall", 3, new BigDecimal("5.00")),
                new Item("forwarded call", 2, new BigDecimal("8.00")),
                new Item("incoming call", 1, new BigDecimal("12.00"))
        );

        BigDecimal subtotal = calculateSubtotal(items);
        BigDecimal grandTotal = calculateGrandTotal(subtotal);

        RockerRuntime.getInstance().setReloading(true);
        String template = views.Invoice.template(items, subtotal, grandTotal)
                .render()
                .toString();

//        String renderedHtml = template.toString();
        log.info(template);

        String outputFile = "C:\\JAVA\\aaa.pdf";
        try (FileOutputStream os = new FileOutputStream(outputFile)) {
            ITextRenderer renderer = new ITextRenderer();
//            renderer.getSharedContext().setBaseURL("file:///C:/Users/Srisailam/Downloads/rocker/src/main/java/views");
            renderer.getSharedContext().setUserAgentCallback(new MyUserAgent(renderer.getOutputDevice()));

            renderer.setDocumentFromString(template);
            renderer.layout();
            renderer.createPDF(os, true);
            renderer.finishPDF();
            log.info("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static BigDecimal calculateSubtotal(List<Item> items) {
        return items.stream()
                .map(item -> item.getTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal calculateGrandTotal(BigDecimal subtotal) {
        return subtotal;
    }

    public static class Item {
        private String callType;
        private int duration;
        private BigDecimal cost;

        public Item(String callType, int duration, BigDecimal cost) {
            this.callType = callType;
            this.duration = duration;
            this.cost = cost;
        }

        public String getCallType() {
            return callType;
        }

        public int getDuration() {
            return duration;
        }

        public BigDecimal getCost() {
            return cost;
        }

        public BigDecimal getTotal() {
            return cost.multiply(BigDecimal.valueOf(duration));
        }

    }

}
