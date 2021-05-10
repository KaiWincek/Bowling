package main.java.company;

public class Roll {
    private int value;
    private RollType rollType;

    public Roll(int value, RollType rollType) {
        this.value = value;
        this.rollType = rollType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RollType getRollType() {
        return rollType;
    }

    public void setRollType(RollType rollType) {
        this.rollType = rollType;
    }
}
