package org.sadkowski.invoices;


import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    void deleteInvoice(Long id);
    void updateInvoice(Invoice invoice);

}
