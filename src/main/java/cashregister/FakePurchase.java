package cashregister;

public class FakePurchase extends Purchase{
    private String purchaseMessage;

    public void setPurchaseMessage(String purchaseMessage) {
        this.purchaseMessage = purchaseMessage;
    }

    public FakePurchase(Item[] items) {
        super(items);
    }
    @Override
    public String asString() {
        return purchaseMessage;
    }
}
