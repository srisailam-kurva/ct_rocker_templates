package com.rocker.model;

import lombok.ToString;

@ToString
public class Invoice {
    public String invoiceNumber;
    public String invoiceDate;
    public Float amount;

    public Invoice(String invoiceNumber, String invoiceDate, float amount) {
        this.invoiceNumber=invoiceNumber;
        this.invoiceDate=invoiceDate;
        this.amount=amount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
