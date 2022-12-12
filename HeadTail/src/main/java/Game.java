import java.io.*;

public class Game {
    public static void main(String[] args) throws IOException {
        Integer amountOfVisitedCoordinates = getVisitedCoordinatesForAloneTail();
        System.out.println(amountOfVisitedCoordinates);
    }

    private static Integer getVisitedCoordinatesForAloneTail() throws IOException {
        BufferedReader br = getReader();

        Head head = new Head();
        Knot tail = new Knot();
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
