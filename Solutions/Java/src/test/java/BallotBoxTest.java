import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;


public class BallotBoxTest {
    BallotBox ballotBox;
    final String csvTest1 = "../../test-elections/test-01-basic-majority/cvr.csv";
    final String csvTest2 = "../../test-elections/test-02-no-initial-majority-candidate/cvr.csv";

    @Test
    @DisplayName("No File Test")
    public void testBallotBox() {
        BallotBox noFile = new BallotBox("");
    }

    @Test
    @DisplayName("Fill Ballets With CSV and Check that 1st ballot is correct")
    public void testFillBallotBox() {
        ballotBox = new BallotBox(csvTest1);
        assert(ballotBox.getBallots().getFirst().getChoice() == 1);
    }

    @Test
    public void testCandidates() {
        ballotBox = new BallotBox(csvTest2);
        assert(ballotBox.getCandidates().trim().equals("Alice Bob Carlos"));
    }

    @ParameterizedTest
    @DisplayName("Find correct victor")
    @CsvSource(value = {csvTest1 + ",Vim", csvTest2 + ",Bob"})
    public void testVoting(String file, String expectedWinner) {
        ballotBox = new BallotBox(file);
        ballotBox.assignVotes();
        String winner = ballotBox.getWinner();
        System.out.println(winner);
        assert(winner.equals(expectedWinner));
    }
}
