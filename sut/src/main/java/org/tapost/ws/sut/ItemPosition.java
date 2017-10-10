package org.tapost.ws.sut;

public class ItemPosition {

    private Item item;
    private Integer amount;

    public ItemPosition(Item item, Integer amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ItemPosition{" +
                "item=" + item +
                ", amount=" + amount +
                '}';
    }

}
