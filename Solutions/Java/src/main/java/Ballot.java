import java.util.HashSet;
import java.util.Set;

public class Ballot {
    private int currentRank = 1;
    private int[] votes;

    public Ballot(int[] votes) {
        this.votes = votes;
    }

    public int getChoice(Set<Integer> eliminatedIds) {
        int choice = 1;
        for (int vote : votes) {
            if (vote == currentRank) {
                if (eliminatedIds.contains(choice))
                    currentRank++;
                else {
                    return choice;
                }
            } else {
                choice++;
            }
        }
        return choice;
    }

    public void incrementCurrentRank() {
        currentRank++;
    }


}
