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

    @ParameterizedTest
    @DisplayName("Find correct winner")
    @CsvSource(value = {csvTest1 + ",Vim"})//, csvTest2 + ",Bob", csvTest4 + ",Alice"})
    public void testWinning(String file, String expectedWinner) {
        ballotBox = new BallotBox(file);
    }
}
