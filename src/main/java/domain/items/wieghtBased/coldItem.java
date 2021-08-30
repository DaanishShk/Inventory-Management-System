package domain.items.wieghtBased;

import domain.items.Item;
import lombok.Data;

@Data
public class coldItem extends weightBased {

    private double temperature;

    public coldItem(String name, double weight, double temperature){
        super(name, weight);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\tType: cold"+"\tWeight: "+weight+"\tTemperature: "+temperature;
    }
}
