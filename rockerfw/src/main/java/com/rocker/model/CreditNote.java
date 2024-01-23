package com.rocker.model;

import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class CreditNote {
//    private ObjectId id;
    private Customer customer;
    private String referenceNumber = "1000";
    private String taxDescription = "vf";
    private Date createdAt;
    private String issueDate;
    private String filename;
    private Integer tax;
    private Float dues;
    private Float consumptions;
    private Float others;
    private Float netAmount = 10.0f;
    private Float taxAmount = 5.0f;
    private Float totalAmount = 15.0f;
    private List<Invoice> invoices;
    private boolean isGenerated = false;

//    public ObjectId getId() {
//        return id;
//    }

//    public void setId(ObjectId id) {
//        this.id = id;
//    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Float getDues() {
        return dues;
    }

    public void setDues(Float dues) {
        this.dues = dues;
    }

    public Float getConsumptions() {
        return consumptions;
    }

    public void setConsumptions(Float consumptions) {
        this.consumptions = consumptions;
    }

    public Float getOthers() {
        return others;
    }

    public void setOthers(Float others) {
        this.others = others;
    }

    public Float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

    public Float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public boolean isGenerated() {
        return isGenerated;
    }

    public void setGenerated(boolean generated) {
        isGenerated = generated;
    }

}
