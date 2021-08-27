package domain.items.wieghtBased;

import lombok.Data;

@Data
public class coldItem extends Item{

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
