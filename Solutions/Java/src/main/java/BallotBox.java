import java.io.File;
import java.io.FileNotFoundException;
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
            String[] namesSplit = sc.nextLine().split(",");
            String[] names = Arrays.copyOfRange(namesSplit, 1, namesSplit.length);

            for (String name : names) {
                candidates.add(new Candidate(name));
            }
            while (sc.hasNextLine()) {
                int[] votes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                ballots.add(new Ballot(
                        Arrays.copyOfRange(votes, 1, votes.length)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Ballot> getBallots() {
        return ballots;
    }

    public String getCandidates() {
        StringBuilder importedCandidates = new StringBuilder();
        for (Candidate candidate : candidates) {
            importedCandidates.append(candidate.getName()).append(" ");
        }
        return importedCandidates.toString();
    }

    public void assignVotes () {
        if (ballots.size() == 0) {
            System.out.println("No ballots found");
            return;
        }
        for (Ballot b : ballots) {
            candidates.get(b.getChoice() - 1).addVote();
        }
    }

    public String getWinner() {
        List<Candidate> sortedCandides = candidates;
        sortedCandides.sort((a, b) -> {return -1 * a.compareTo(b);});
        return candidates.getFirst().getName();
    }
}
