import java.util.ArrayList;

public class Head implements Subject {
    private ArrayList<Observer> observers;
    private int x = 0;
    private int y = 0;
    private int previousX = 0;
    private int previousY = 0;

    public Head() {
        observers = new ArrayList<>();
    }

    public void transform(Character direction) {
        this.previousX = x;
        this.previousY = y;
        switch (direction) {
            case 'R': this.x++; break;
            case 'L': this.x--; break;
            case 'D': this.y--; break;
            case 'U': this.y++; break;
        }
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
