package domain.items;

public class Item {

    private String name;
    private double val;
    private String valType;
    private int qty;

    public Item(String name, double val, String valType, int qty) {
        this.name = name;
        this.val = val;
        this.valType = valType;
        this.qty = qty;
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

    public double getTotalVal() {
        return this.qty * this.val;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +"\n"+valType+": "+this.val;
    }
}
