package domain.containers.liquidBased;

public class Barrel extends liquidBasedContainer{

    public Barrel(double maxVolume) {
        super(maxVolume, "Barrel");
    }

    @Override
    public String toString() {
        return "  ID: "+super.id+"\tType: "+super.type+"\tMaxVolume: "+super.maxVolume
                +"\tLiquid: "+super.liquid.getName()+"\tVolumeFilled: "+super.liquid;
    }
}
