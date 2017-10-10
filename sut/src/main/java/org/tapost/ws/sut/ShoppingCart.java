package org.tapost.ws.sut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    final List<ItemPosition> items = new ArrayList<>();
    BigDecimal total = BigDecimal.ZERO;

    public List<ItemPosition> getItems() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
