import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BallotBox {
    private String[] names;
    private List<Ballot> ballots= new ArrayList<>();

    public BallotBox (String file) {
        try (Scanner sc = new Scanner(new File(file))) {
            names = sc.nextLine().split(",");
            while (sc.hasNextLine()) {
                int[] votes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                ballots.add(new Ballot(
                        Arrays.copyOfRange(votes, 1, votes.length)));
            }
        } catch (Exception e) {
            System.out.println("File not Found");
        }
    }

    public List<Ballot> getBallots() {
        return ballots;
    }
}
