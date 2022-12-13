import java.util.ArrayList;
import java.util.HashSet;

public class InnerKnot extends Knot implements  Subject{

    private ArrayList<Observer> observers;
    private int previousX = 0;
    private int previousY = 0;

    public InnerKnot() {
        super();
        observers = new ArrayList<>();
    }

    @Override
    public void update(int subjectX, int subjectY, int previousSubjectX, int previousSubjectY) {
        this.previousX = x;
        this.previousY = y;
        super.update(subjectX, subjectY, previousSubjectX, previousSubjectY);
        informObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void informObservers() {
        for (Observer observer : observers) {
            observer.update(this.x, this.y, this.previousX, this.previousY);
        }
    }
}
