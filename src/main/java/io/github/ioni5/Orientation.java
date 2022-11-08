package io.github.ioni5;

public enum Orientation {
    
    POSITIVE(1), NEGATIVE(-1);

    private int number;

    private Orientation(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

}
