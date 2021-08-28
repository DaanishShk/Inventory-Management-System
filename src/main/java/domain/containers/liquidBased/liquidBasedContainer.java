package domain.containers.liquidBased;

import domain.items.liquidBased.Liquid;
import lombok.Data;

@Data
public abstract class liquidBasedContainer {

    double maxVolume;
    Liquid liquid;
    int id;
    String type;

    public liquidBasedContainer(double maxVolume, String type) {
        this.maxVolume = maxVolume;
        this.liquid = null;
        this.id = this.hashCode(); // Temporary id using hashcode
    }

    public abstract String toString();

    public boolean setLiquid(Liquid liquid) {      // returns true if replaced successfully
        if (this.liquid != null) {
            return false;
        }
        if (liquid.getVolume() > this.maxVolume) {
            return false;
        }
        this.liquid = liquid;
        return true;
    }

    public void removeLiquid() {
        this.liquid = null;
    }

    public double amountFilled() {
        return this.liquid.getVolume();
    }

    public void printContents() {
        System.out.println("Contents of "+this.type+":");
        if(liquid==null) System.out.println("  EMPTY");
        else {
            System.out.println("  Liquid: "+this.liquid+"\tFraction filled: "
                    +this.liquid.getVolume()+"/"+this.maxVolume);
        }
    }
}

