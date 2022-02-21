package org.sadkowski.invoices;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    private final List<Invoice> invoiceList;

    public InvoiceServiceImpl() {
        this.invoiceList = new ArrayList<>();

        invoiceList.add(new Invoice(1L,
                BigDecimal.valueOf(100),
                LocalDate.of(2022,02,18),
                "Tool1" ));

        invoiceList.add(new Invoice(2L,
                BigDecimal.valueOf(200),
                LocalDate.of(2032,02,18),
                "Tool2" ));
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceList;
    }

    @Override
    public void deleteInvoice(Long id) {
    invoiceList.removeIf(element -> element.getId().equals(id));
    }

    @Override
    public void updateInvoice(Invoice newInvoice) {
    Invoice oldInvoice = invoiceList.stream()
            .filter(element -> element.getId().equals(newInvoice.getId()))
            .findFirst()
            .orElseThrow();
    int index = invoiceList.indexOf(oldInvoice);
    invoiceList.set(index, newInvoice);
    }

}
