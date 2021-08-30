package domain.containers.liquidBased;

import domain.items.liquidBased.Liquid;

public class Barrel extends liquidBasedContainer{

    public Barrel(double maxVolume, double currVolume) {
        super(maxVolume, currVolume, "Barrel");
    }

    @Override
    public String toString() {
        return "  ID: "+super.id+"\tType: "+super.type+"\tMaxVolume: "+super.maxVolume
                +"\tLiquid: "+super.liquid.getName()+"\tVolumeFilled: "+super.liquid;
    }

    @Override
    public boolean addItem(Liquid item, double vol) {
        return false;
    }
}
