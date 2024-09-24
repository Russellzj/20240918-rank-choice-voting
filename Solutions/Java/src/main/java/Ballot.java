public class Ballot {
    private int currentRank = 1;
    private int[] votes;

    public Ballot(int[] votes) {
        this.votes = votes;
    }

    public int getChoice() {
        int choice = 1;
        for (int vote : votes) {
            if (vote == currentRank) {
                return choice;
            } else {
                choice++;
            }
        }
        return choice;
    }


}
