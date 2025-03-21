
public class InvoiceItem_Demo {

	private String invoiceId;
	private String invoiceDesc;
	private int invoiceQty;
	private double invoiceItemPrice;

	InvoiceItem_Demo(int invoiceQty, double invoceItemPrice) {
		this.invoiceQty = invoiceQty;
		this.invoiceItemPrice = invoceItemPrice;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}

	public void setInvoiceQty(int invoiceQty) {
		this.invoiceQty = invoiceQty;
	}

	public void setInvoiceItemPrice(double invoiceItemPrice) {
		this.invoiceItemPrice = invoiceItemPrice;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public String getInvoiceDesc() {
		return invoiceDesc;
	}

	public int getInvoiceQty() {
		return invoiceQty;
	}

	public double getInvoiceItemPrice() {
		double itemPrice = this.invoiceItemPrice;
		if (this.invoiceQty > 1) {
			itemPrice = this.invoiceItemPrice * this.invoiceQty;
		}
		return itemPrice;
	}

}
