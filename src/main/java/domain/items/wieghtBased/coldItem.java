package domain.items.wieghtBased;

import domain.items.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class coldItem extends weightBased {

    private double temperature;

    public coldItem(String name, double weight, double temperature){
        super(name, weight);
        this.temperature = temperature;
    }

    public coldItem(double temperature) {
        this(null, 0, temperature);
    }

    @Override
    public String toString() {
        return "Name: "+name+"\tType: cold"+"\tWeight: "+weight+"\tTemperature: "+temperature;
    }

    @Override
    public int getType() {
        return 2;
    }
}
