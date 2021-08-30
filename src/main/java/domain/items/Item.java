package domain.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter/setter for this class will not be defined in subclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {
    protected String name;
}
