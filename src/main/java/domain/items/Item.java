package domain.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abstract Item class defined with name attribute. getType() function required for compatibility checks while
 * transferring items from buffer to container.
 *
 * @author DaanishShk
 * @version 1.0
 */
@Data // getter/setter for this class will not be defined in subclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {
    protected String name;

    public abstract int getType();
}
