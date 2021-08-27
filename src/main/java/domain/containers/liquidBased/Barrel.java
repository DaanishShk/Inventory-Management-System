package domain.containers.liquidBased;

import domain.items.liquidBased.Liquid;

import java.util.HashMap;
import java.util.Map;

public class Barrel {

    private double maxVolume;
    private Map<Liquid, Integer> items;
    private int id;

    public Barrel(double maxVolume) {
        this.maxVolume = maxVolume;
        this.items = new HashMap<>();
        this.id = this.hashCode();
    }


}
