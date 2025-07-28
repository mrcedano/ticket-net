
package Builders;

import DTOs.CarteleraDto;
import java.time.LocalDate;

public class CarteleraBuilder {
    private int id = 0;
    private LocalDate fromDate = null;
    private LocalDate toDate = null;
    private int isActivated = 0;

    public CarteleraBuilder() {
    }

    public CarteleraBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CarteleraBuilder withFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public CarteleraBuilder withToDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }
    
    public CarteleraBuilder withIsActivated(int isActivated) {
        this.isActivated = isActivated;
        return this;
    }

    public CarteleraDto build() {
        return new CarteleraDto(id, fromDate, toDate, isActivated);
    }
}

