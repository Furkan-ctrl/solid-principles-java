// SRP Practice Exercise — starter code. Refactor this so each responsibility
// (data, calculation, printing, saving, emailing) lives in its own class.
// See README.md in this folder for the full task and requirements.

class Invoice {
    private String customerName;
    private double[] itemPrices;

    public Invoice(String customerName, double[] itemPrices) {
        this.customerName = customerName;
        this.itemPrices = itemPrices;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double[] getItemPrices() {
        return itemPrices;
    }

}

class InvoiceCalculator {
    public double calculateTotal(Invoice invoice)
    {
        double total = 0;
        for(double price : invoice.getItemPrices())
        {
            total += price;
        }
        return total;
    }
}


class InvoicePrinter {
    private final InvoiceCalculator calculator;

    public InvoicePrinter(InvoiceCalculator calculator) {
        this.calculator = calculator;
    }

    public void print(Invoice invoice)
    {
        System.out.println("Invoice for: " + invoice.getCustomerName());

        for (double price : invoice.getItemPrices())
        {
            System.out.println("  - $" + price);
        }
        System.out.println("Total: $" + calculator.calculateTotal(invoice));
    }
}

class InvoiceStorage {
    public void saveToFile(Invoice invoice, String filename) {
        System.out.println("Saving invoice for " + invoice.getCustomerName() + " to " + filename);
    }
}

class InvoiceMailer {
    public void email(Invoice invoice, String emailAddress) {
        System.out.println("Emailing invoice for " + invoice.getCustomerName() + " to " + emailAddress);
    }
}

public class Starter {
    public static void main(String[] args) {

        Invoice invoice = new Invoice("Furkan", new double[]{19.99, 65.51, 100.00});

        InvoiceCalculator calculator = new InvoiceCalculator();
        InvoicePrinter printer = new InvoicePrinter(calculator);
        InvoiceStorage storage = new InvoiceStorage();
        InvoiceMailer mailer = new InvoiceMailer();

        double total = calculator.calculateTotal(invoice);
        System.out.println("Total: $" + total + "\n");

        printer.print(invoice);

        storage.saveToFile(invoice, "Furkan_invoice.txt");

        mailer.email(invoice, "fnaghiyev2007@ada.edu.az");
    }
}


