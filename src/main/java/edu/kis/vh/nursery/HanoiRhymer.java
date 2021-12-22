package edu.kis.vh.nursery;

//kombinacja tych klawiszy alt + ← oraz alt + → pozwala przemieszczac sie pomiedzy otwartymi wczesniej plikami
public class HanoiRhymer extends DefaultCountingOutRhymer {

    int totalRejected = 0;

    public int reportRejected() {
        return totalRejected;
    }

    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
