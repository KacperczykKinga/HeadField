public class Tail extends Knot{
    @Override
    public void update(int subjectX, int subjectY, int previousSubjectX, int previousSubjectY) {
        if (isFurtherInRow(subjectX, subjectY)) {
            this.y = previousSubjectY;
        } else if (isFurtherInColumn(subjectX, subjectY)) {
            this.x = previousSubjectX;
        } else if (getPitagoras(subjectX, subjectY) == Math.sqrt(5)) {
            this.x = previousSubjectX;
            this.y = previousSubjectY;
        }
        visitedCoordinates.add(x + "," + y);
    }
}
