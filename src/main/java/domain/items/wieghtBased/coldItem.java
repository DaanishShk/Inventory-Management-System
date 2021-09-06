package domain.items.wieghtBased;

import domain.items.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for Items requiring refrigeration. <code>temperature</code> added for further compatibility checks.
 * @author DaanishShk
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class coldItem extends weightBased {

    private double temperature;
    private final int type = 2;

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
        return type;
    }
}
