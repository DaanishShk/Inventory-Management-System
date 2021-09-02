package domain.containers.liquidBased;

import domain.items.liquidBased.Liquid;

public class Barrel extends liquidBasedContainer{

    public Barrel(double maxVolume) {
        super(maxVolume, 0, "Barrel");
    }

    @Override
    public String toString() {
        return "ID: "+super.id+"\t\tContainerType: "+super.type+"\t\tMaxVolume: "+super.maxVolume
                +"\t\tLiquid: "+(liquid==null?"empty": liquid.getName())+"\t\tVolumeFilled: "+(liquid==null?"NA": liquid);
    }

    @Override
    public boolean addItem(Liquid item, double vol) {
        return false;
    }
}
