package edu.kis.vh.nursery;

//kombinacja tych klawiszy alt + ← oraz alt + → pozwala przemieszczac sie pomiedzy otwartymi wczesniej plikami
public class HanoiRhymer extends DefaultCountingOutRhymer {
    /**
     * counting out class
     */
    private int totalRejected = 0;

    /**
     * return total rejected int
     */
    public int reportRejected() {
        return totalRejected;
    }

    /**
     * counting total rejected
     * @param in input number to count in
     */
    @Override
    public void countIn(final int in) {
        if (!callCheck() && in > getLastNumber())
            totalRejected++;
        else
            super.countIn(in);
    }
}
