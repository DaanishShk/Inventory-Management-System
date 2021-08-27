package domain.items.wieghtBased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter/setter for this class will not be defined in subclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {
    String name;
    double weight;
}
