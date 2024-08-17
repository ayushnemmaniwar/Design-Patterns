package com.example.srp;



public class SRPExample {
    public static class Invoice {
        public void AddInvoice() {
            System.out.println("Add Invoice");
        }

        public void delInvoice() {
            System.out.println("Del Invoice");
        }

        //To follow SRP we have created separate classes for email and report generation

//        public void generateReport() {
//            System.out.println("Gen");
//        }
//
//        public void emailReport() {
//            System.out.println("Email");
//        }

    }

    public static class GenerateReport {
        public void generateReport() {
            System.out.println("Report");
        }
    }

    public class Email {
        public void emailReport() {
            System.out.println("Email");
        }
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.AddInvoice();
        GenerateReport generateReport = new GenerateReport();
        generateReport.generateReport();
        System.out.println("hello");
    }
}
