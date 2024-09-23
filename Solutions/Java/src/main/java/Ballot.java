import java.util.Arrays;

public class Ballot {
    int voteLocation = 0;
    int[] votes;

    public Ballot(int[] votes) {
        this.votes = votes;
    }

    public int getChoice() {
        return votes[voteLocation];
    }

}
