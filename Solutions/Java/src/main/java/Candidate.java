//Class to hold voter names and their assigned votes
public class Candidate implements Comparable<Candidate>{
    private String name;
    private int votes;

    public Candidate (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addVote() {
        votes++;
    }

    //Compares Candidate's votes to another Candidate's
    @Override
    public int compareTo(Candidate otherCandidate) {
        return Integer.compare(votes, otherCandidate.votes);

    }
}
