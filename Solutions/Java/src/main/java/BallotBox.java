import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BallotBox {
    //Holds candidate's ID, names and total votes
    private Map<Integer, Candidate> candidates = new HashMap<>();

    //All ballots are initially stored here
    private List<Ballot> ballots= new ArrayList<>();

    //Holds IDs of candidates that have been removed
    Set<Integer> removedIds = new HashSet<>();

    public BallotBox (String file) {
        try (Scanner sc = new Scanner(new File(file))) {
            String[] namesSplit = sc.nextLine().split(",");

            for (int i = 1; i < namesSplit.length; i++) {
                candidates.put(i, new Candidate(namesSplit[i], i));
            }
            while (sc.hasNextLine()) {
                int[] votes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                //ignores the first element of the ballot since we do not need ballot ID
                ballots.add(new Ballot(Arrays.copyOfRange(votes, 1, votes.length)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setVotes () {
        for(Ballot ballot : ballots) {
            candidates.get(ballot.getChoice()).addBallot(ballot);
        }
    }

    public String getWinner() {
        List<Candidate> sortedCandidates = new ArrayList<>();
        sortedCandidates.addAll(candidates.values());
        sortedCandidates.sort((a, b) -> {return -1 * a.compareTo(b);});
        if (sortedCandidates.getFirst().getTotalBallots() * 2 > ballots.size()) {
            return sortedCandidates.getFirst().getName();
        }

        return "Nope";
    }

    public void removeCandidate(int id) {
        removedIds.add(id);

    }
}
