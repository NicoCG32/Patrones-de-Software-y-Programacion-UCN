package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    CustomerProvider provider = new CrmCustomerAdapter(new ExternalCrmApi());
    System.out.println(provider.findCustomer("C-10"));
}
}
