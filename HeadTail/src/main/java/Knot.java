import java.util.ArrayList;
import java.util.HashSet;

public class Knot implements Observer {
    private int x = 0;
    private int y = 0;
    public HashSet<String> visitedCoordinates;

    public Knot() {
        visitedCoordinates = new HashSet<>();
        visitedCoordinates.add("0,0");
    }

    @Override
    public void update(int subjectX, int subjectY, int previousSubjectX, int previousSubjectY) {
        if (x == subjectX && Math.abs(subjectY - y) == 2) {
            this.y = previousSubjectY;
        } else if (y == subjectY && Math.abs(subjectX - x) == 2) {
            this.x = previousSubjectX;
        } else if (getPitagoras(subjectX, subjectY) == Math.sqrt(5)) {
            this.x = previousSubjectX;
            this.y = previousSubjectY;
        }
        visitedCoordinates.add(x + "," + y);
    }

    public Double getPitagoras(int subjectX, int subjectY) {
        return Math.sqrt(Math.pow(subjectX - x, 2) + Math.pow(subjectY - y, 2));
    }

    public Integer getAmountOfCoordinates() {
        return visitedCoordinates.size();
    }
}
