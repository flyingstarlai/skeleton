package starlai.dev.skeleton.data.local;

/**
 * Created by izayoi on 3/8/17.
 */

public class Quantity {
    public long id;
    public String name;
    public int monthly;
    public int yearly;

    public Quantity(long id, String name,  int monthly, int yearly) {
        this.id = id;
        this.name = name;
        this.monthly = monthly;
        this.yearly = yearly;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthly() {
        return monthly;
    }

    public void setMonthly(int monthly) {
        this.monthly = monthly;
    }

    public int getYearly() {
        return yearly;
    }

    public void setYearly(int yearly) {
        this.yearly = yearly;
    }
}
