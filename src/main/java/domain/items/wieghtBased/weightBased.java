package domain.items.wieghtBased;

import domain.items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abstract model for weight based items. Weight parameter added for storage checks.
 * Implemented by coldItem and dryItem.
 * @see dryItem
 * @see coldItem
 *
 * @author DaanishShk
 * @version 1.0
 */
@Data
@NoArgsConstructor
public abstract class weightBased extends Item {
    double weight;

    public weightBased(String name, double weight) {
        super(name);
        this.weight = weight;
    }
}
