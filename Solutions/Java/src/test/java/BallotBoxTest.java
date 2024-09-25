import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallotBoxTest {
    BallotBox ballotBox;
    final String csvTest1 = "../../test-elections/test-01-basic-majority/cvr.csv";
    final String csvTest2 = "../../test-elections/test-02-no-initial-majority-candidate/cvr.csv";
    final String csvTest3 = "../../test-elections/test-03-multiple-rounds-of-elimination/cvr.csv";
    final String csvTest4 = "../../test-elections/test-04-exhausted-ballot/cvr.csv";
    final String csvTest5 = "../../test-elections/test-05-no-majority--all-candidates-eliminated-except-one/cvr.csv";

    @Test
    @DisplayName("No File Test")
    public void testBallotBox() {
        BallotBox noFile = new BallotBox("");
    }

    @ParameterizedTest
    @DisplayName("Find correct winner")
    @CsvSource(value = {csvTest1 + ",Vim", csvTest2 + ",Bob", csvTest3 + ",Bob", csvTest4 + ",Alice", csvTest5 + ",Alice"})
    public void testWinning(String file, String expectedWinner) {
        ballotBox = new BallotBox(file);
        ballotBox.setVotes();
        String winner = ballotBox.getWinnerName();
        System.out.println("Winner: " + winner);
        System.out.println("Rounds: " + ballotBox.round);
        assert (winner.equals(expectedWinner));
    }

    @Test
    @DisplayName("Test Single File")
    public void testSingleFile() {
        ballotBox = new BallotBox(csvTest4);
        ballotBox.setVotes();
        String winner = ballotBox.getWinnerName();
        System.out.println("Winner: " + winner);
        System.out.println("Rounds: " + ballotBox.round);
    }
}
