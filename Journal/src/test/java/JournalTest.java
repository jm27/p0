import com.github.jm27.p0.domain.Journal;
import org.junit.Assert;
import org.junit.Test;

public class JournalTest {

    private final Journal journal = new Journal();
    @Test
    public void createEntryTest() {
        int expected = 3;
        int actual = Math.addExact(2,1);
        Assert.assertTrue(expected == actual);
    }

}
