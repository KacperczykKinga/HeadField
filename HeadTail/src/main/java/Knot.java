import java.util.ArrayList;
import java.util.HashSet;

public class Knot implements Observer {
    protected int x = 0;
    protected int y = 0;
    protected HashSet<String> visitedCoordinates;

    public Knot() {
        visitedCoordinates = new HashSet<>();
        visitedCoordinates.add("0,0");
    }

    @Override
    public void update(int subjectX, int subjectY, int previousSubjectX, int previousSubjectY) {
        if (isFurtherInRow(subjectX, subjectY)) {
            this.y = previousSubjectY;
        } else if (isFurtherInColumn(subjectX, subjectY)) {
            this.x = previousSubjectX;
        } else if (getPitagoras(subjectX, subjectY) == Math.sqrt(5)) {
            moveOneX(subjectX, previousSubjectX);
            moveOneY(subjectY, previousSubjectY);
        } else if (getPitagoras(subjectX, subjectY) == Math.sqrt(8)) {
            this.x = previousSubjectX;
            this.y = previousSubjectY;
        }
        visitedCoordinates.add(x + "," + y);
    }

    private void moveOneY(int subjectY, int previousSubjectY) {
        if(Math.abs(subjectY - y) == 2) {
            this.y = previousSubjectY;
        } else {
            this.y = subjectY;
        }
    }

    private void moveOneX(int subjectX, int previousSubjectX) {
        if(Math.abs(subjectX - x) == 2) {
            this.x = previousSubjectX;
        } else {
            this.x = subjectX;
        }
    }

    protected boolean isFurtherInColumn(int subjectX, int subjectY) {
        return y == subjectY && Math.abs(subjectX - x) == 2;
    }

    protected boolean isFurtherInRow(int subjectX, int subjectY) {
        return x == subjectX && Math.abs(subjectY - y) == 2;
    }

    protected Double getPitagoras(int subjectX, int subjectY) {
        return Math.sqrt(Math.pow(subjectX - x, 2) + Math.pow(subjectY - y, 2));
    }

    public Integer getAmountOfCoordinates() {
        return visitedCoordinates.size();
    }
}
