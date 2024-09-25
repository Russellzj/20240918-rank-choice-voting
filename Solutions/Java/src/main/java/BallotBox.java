import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BallotBox {
    //Holds candidate's ID, names and total votes
    private Map<Integer, Candidate> candidates = new HashMap<>();

    //All ballots are initially stored here
    private List<Ballot> ballots= new ArrayList<>();

    //Holds IDs of candidates that have been removed
    Set<Integer> eliminatedIds = new HashSet<>();

    int round = 1;
    public BallotBox (String file) {
        try (Scanner sc = new Scanner(new File(file))) {
            String[] namesSplit = sc.nextLine().split(",");
            for (int i = 1; i < namesSplit.length; i++) {
                candidates.put(i, new Candidate(namesSplit[i], i));
            }
            while (sc.hasNextLine()) {
                String[] importedVotes = sc.nextLine().split(",");
                int[] votes = new int[importedVotes.length];
                //used to hold ranks already used to make sure the ballot is acceptable
                Set<String> usedRanks = new HashSet<>();
                //Changes to false if the ballot is not valid
                boolean isValid = true;
                for (int i = 0; i < votes.length; i++) {
                    if (importedVotes[i].isBlank()) {
                        votes[i] = 0;
                    } else if (!usedRanks.contains(importedVotes[i])) {
                        votes[i] = Integer.parseInt(importedVotes[i]);
                        usedRanks.add(importedVotes[i]);
                    } else {
                        isValid = false;
                        break;
                    }
                }
                //Only add vote to ballots if the ballot is valid
                if (isValid) {
                    //ignores the first element of the ballot since we do not need ballot ID
                    ballots.add(new Ballot(Arrays.copyOfRange(votes, 1, votes.length)));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setVotes () {
        for(Ballot ballot : ballots) {
            int choice = ballot.getVote(eliminatedIds);
            candidates.get(choice).addBallot(ballot);
        }
    }

    public int redistributeVotes (int removeID) {
        ++round;
        eliminatedIds.add(removeID);
        List<Ballot> ballotsToRedistribute = candidates.get(removeID).getBallots();
        candidates.remove(removeID);
        for(int i = 0; i < ballotsToRedistribute.size(); i++) {
            ballotsToRedistribute.get(i).incrementCurrentRank();
            int voteToDistribute = ballotsToRedistribute.get(i).getVote(eliminatedIds);
            if (voteToDistribute != 0) {
                candidates.get(ballotsToRedistribute.get(i).getVote(eliminatedIds)).
                        addBallot(ballotsToRedistribute.get(i));
            }
        }
        return getWinner();
    }

    public int getWinner() {
        List<Candidate> sortedCandidates = new ArrayList<>();
        sortedCandidates.addAll(candidates.values());
        sortedCandidates.sort((a, b) -> {return -1 * a.compareTo(b);});
        if (sortedCandidates.getFirst().getTotalBallots() * 2 > ballots.size() ||
                sortedCandidates.size() <= 2) {
            return sortedCandidates.getFirst().getId();
        } else {
            return redistributeVotes(sortedCandidates.getLast().getId());
        }
    }

    public String getWinnerName() {
        return candidates.get(getWinner()).getName();
    }
}
