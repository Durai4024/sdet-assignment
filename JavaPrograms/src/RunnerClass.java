
public class RunnerClass {

	public static void main(String[] args) {
		
		InvoiceItem_Demo invoiceItem1= new InvoiceItem_Demo(1, 120);
		System.out.println("First Item Price is "+ invoiceItem1.getInvoiceItemPrice());
		
		InvoiceItem_Demo invoiceItem2= new InvoiceItem_Demo(3, 60);
		System.out.println("Second Item Price is "+ invoiceItem2.getInvoiceItemPrice());

	}

}
