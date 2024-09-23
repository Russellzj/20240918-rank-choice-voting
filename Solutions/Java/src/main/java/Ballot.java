import java.util.Arrays;

public class Ballot {
    private int voteLocation = 0;
    private int[] votes;

    public Ballot(int[] votes) {
        this.votes = votes;
    }

    public int getChoice() {
        return votes[voteLocation];
    }

}
