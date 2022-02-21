package org.sadkowski.invoices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String getAllInvoices(Model model){
        List<Invoice> allInvoices = invoiceService.getAllInvoices();
        model.addAttribute("allInvoices",allInvoices);
        return "gui";
    }
}
