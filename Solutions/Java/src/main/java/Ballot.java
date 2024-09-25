import java.util.Set;

public class Ballot {
    private int currentRank = 1;
    private int[] votes;

    public Ballot(int[] votes) {
        this.votes = votes;
    }

    public int getVote(Set<Integer> eliminatedIds) {
            for (int voteId = 1; voteId <= votes.length; voteId++) {
                int vote = votes[voteId - 1];
                if (vote == currentRank) {
                    if (!eliminatedIds.contains(voteId)) {
                        return voteId;
                    } else {
                        currentRank++;
                        voteId = 1;
                    }
                }
            }
            return 0;
        }


    public void incrementCurrentRank() {
        currentRank++;
    }


}
