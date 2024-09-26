import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ballot {
    private int currentRank = 1;

    //The key is the rank and the value is vote ID
    private Map<Integer, Integer> votes = new HashMap<>();

    public Ballot(int[] votes) {
        for (int i = 0; i < votes.length; i++) {
            this.votes.put(votes[i], i + 1);
        }
    }

    public int getRankID(Set<Integer> eliminatedIds) {
        while (currentRank <= votes.size()) {
            if (votes.containsKey(currentRank)) {
                if (!eliminatedIds.contains(votes.get(currentRank))) {
                    return votes.get(currentRank);
                }
            }
            currentRank++;
        }
        return 0;
    }

    public void incrementCurrentRank() {
        currentRank++;
    }


}
