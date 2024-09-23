import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;


public class BallotBoxTest {
    BallotBox ballotBox;
    String csvTest1 = "../../test-elections/test-01-basic-majority/cvr.csv";


    @Test
    @DisplayName("No File Test")
    public void testBallotBox() {
        BallotBox noFile = new BallotBox("");
    }
    @Test
    @DisplayName("Fill Ballets With CSV and Check that 1st ballot is correct")
    public void testFillBallotBox() {
        ballotBox = new BallotBox(csvTest1);
        assert(ballotBox.getBallots().get(0).getChoice() == 1);
    }

}
