import java.util.ArrayList;
import java.util.List;

//Class to hold voter names and their assigned votes
public class Candidate implements Comparable<Candidate>{
    private String name;
    private int id;
    private List<Ballot> ballots = new ArrayList<>();

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

    public void addBallot(Ballot ballot) {
        this.ballots.add(ballot);
    }

    public List<Ballot> getBallots() {
        return ballots;
    }

    public int getTotalBallots() {
        return ballots.size();
    }

    //Compares Candidate's votes to another Candidate's
    @Override
    public int compareTo(Candidate otherCandidate) {
        return Integer.compare(getTotalBallots(), otherCandidate.getTotalBallots());

    }
}
