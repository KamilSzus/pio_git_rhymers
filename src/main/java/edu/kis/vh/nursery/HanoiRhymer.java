package edu.kis.vh.nursery;

//kombinacja tych klawiszy alt + ← oraz alt + → pozwala przemieszczac sie pomiedzy otwartymi wczesniej plikami
public class HanoiRhymer extends DefaultCountingOutRhymer {

    private int totalRejected = 0;

    public int reportRejected() {
        return totalRejected;
    }

    @Override
    public void countIn(final int in) {
        if (!callCheck() && in > getLastNumber())
            totalRejected++;
        else
            super.countIn(in);
    }
}
