package domain.items;

public class Item {

    private String name;
    private double val;
    private String valType;

    public Item(String name, double val, String valType) {
        this.name = name;
        this.val = val;
        this.valType = valType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public String getValType() {
        return valType;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +"\t"+valType+": "+this.val;
    }
}
