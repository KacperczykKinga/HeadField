import java.io.*;

public class Game {
    public static void main(String[] args) throws IOException {
       // Integer amountOfVisitedCoordinates = getVisitedCoordinatesForAloneTail();
        Integer amountOfVisitedCoordinates = getVisitedCoordinatesForLongTail();

        System.out.println(amountOfVisitedCoordinates);
    }

    private static Integer getVisitedCoordinatesForLongTail() throws IOException {
        BufferedReader br = getReader();

        Head head = new Head();
        InnerKnot knot1 = new InnerKnot();
        head.addObserver(knot1);
        InnerKnot knot2 = new InnerKnot();
        knot1.addObserver(knot2);
        InnerKnot knot3 = new InnerKnot();
        knot2.addObserver(knot3);
        InnerKnot knot4 = new InnerKnot();
        knot3.addObserver(knot4);
        InnerKnot knot5 = new InnerKnot();
        knot4.addObserver(knot5);
        InnerKnot knot6 = new InnerKnot();
        knot5.addObserver(knot6);
        InnerKnot knot7 = new InnerKnot();
        knot6.addObserver(knot7);
        InnerKnot knot8 = new InnerKnot();
        knot7.addObserver(knot8);
        InnerKnot tail = new InnerKnot();
        knot8.addObserver(tail);

        String line;
        while ((line = br.readLine()) != null) {
            makeOneMove(head, line);
        }
        return tail.getAmountOfCoordinates();
    }

    private static Integer getVisitedCoordinatesForAloneTail() throws IOException {
        BufferedReader br = getReader();

        Head head = new Head();
        Tail tail = new Tail();
        head.addObserver(tail);

        String line;
        while ((line = br.readLine()) != null) {
            makeOneMove(head, line);
        }
        return tail.getAmountOfCoordinates();
    }

    private static void makeOneMove(Head head, String line) {
        String[] movement = line.split(" ");
        Character move = movement[0].charAt(0);
        Integer howMany = Integer.valueOf(movement[1]);
        for(int i = 0; i <howMany; i++) {
            head.transform(move);
        }
    }

    private static BufferedReader getReader() throws FileNotFoundException {
        String fileName = "C:\\Users\\Kinga\\Downloads\\input9.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }
}
