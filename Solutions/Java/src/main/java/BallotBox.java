import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BallotBox {
    //Holds candidate's names and total votes
    private List<Candidate> candidates = new ArrayList<>();
    //All ballots are initially stored here
    private List<Ballot> ballots= new ArrayList<>();

    public BallotBox (String file) {
        try (Scanner sc = new Scanner(new File(file))) {
            String[] names = Arrays.copyOfRange(sc.nextLine().split(","), 1, 3);
            for (String name : names) {
                candidates.add(new Candidate(name));
            }
            while (sc.hasNextLine()) {
                int[] votes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                ballots.add(new Ballot(
                        Arrays.copyOfRange(votes, 1, votes.length)));
            }
        } catch (Exception e) {
            System.out.println("File not Found");
            return;
        }
    }

    public List<Ballot> getBallots() {
        return ballots;
    }

    public void assignVotes () {
        if (ballots.size() == 0) {
            System.out.println("No ballots found");
            return;
        }
        for (Ballot b : ballots) {
            if (b.getChoice() == 1) {
                candidates.get(0).addVote();
            } else {
                candidates.get(1).addVote();
            }
        }
    }

    public String getWinner() {
        List<Candidate> sortedCandides = candidates;
        sortedCandides.sort((a, b) -> {return -1 * a.compareTo(b);});
        return candidates.getFirst().getName();
    }
}
