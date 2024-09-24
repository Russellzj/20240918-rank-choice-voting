//Class to hold voter names and their assigned votes
public class Candidate implements Comparable<Candidate>{
    private String name;
    private int votes;
    private int id;

    public Candidate (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }

    //Compares Candidate's votes to another Candidate's
    @Override
    public int compareTo(Candidate otherCandidate) {
        return Integer.compare(votes, otherCandidate.votes);

    }
}
