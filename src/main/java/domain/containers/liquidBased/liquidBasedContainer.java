package domain.containers.liquidBased;

import domain.containers.Container;
import domain.items.liquidBased.Liquid;
import lombok.Data;

@Data
public abstract class liquidBasedContainer implements Container<Liquid> {

    double maxVolume;
    double currVolume;
    Liquid liquid;
    int id;
    String type;

    public liquidBasedContainer(double maxVolume, double currVolume, String type) {
        this.maxVolume = maxVolume;
        this.currVolume = currVolume;
        this.liquid = null;
        this.id = this.hashCode(); // Temporary id using hashcode
    }

    public abstract String toString();

    public boolean setLiquid(Liquid liquid, double volume) {      // returns true if replaced successfully
        if (this.liquid != null) {
            return false;
        }
        if (volume > this.maxVolume) {
            return false;
        }
        this.liquid = liquid;
        this.currVolume = volume;
        return true;
    }

    public void removeLiquid() {
        this.liquid = null;
    }

    public double amountFilled() {
        return this.currVolume;
    }

    public void printContents() {
        System.out.println("Contents of "+this.type+":");
        if(liquid==null) System.out.println("  EMPTY");
        else {
            System.out.println("  Liquid: "+this.liquid+"\tFraction filled: "
                    +this.currVolume+"/"+this.maxVolume);
        }
    }
}

