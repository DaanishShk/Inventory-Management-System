package domain.items.wieghtBased;

import domain.items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class weightBased extends Item {
    double weight;

    public weightBased(String name, double weight) {
        super(name);
        this.weight = weight;
    }
}
