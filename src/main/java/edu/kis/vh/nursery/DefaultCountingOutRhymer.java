package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int LAST_INDEX = 11;
    private static final int SIZE = 12;
    private static final int START_VAL = -1;

    private final int[] numbers = new int[SIZE];
    private int total = START_VAL;

    public int getTotal() {
        return total;
    }// TODO: Delete unnecessary getter

    public void setTotal(int total) {
        this.total = total;
    }// TODO: Delete unnecessary setter

    public void countIn(final int in) {

        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == START_VAL;
    }

    public boolean isFull() {
        return total == LAST_INDEX;
    }

    protected int getLastNumber() {
        if (callCheck())
            return -1;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return -1;
        return numbers[total--];
    }

}
