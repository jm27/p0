import com.github.jm27.p0.domain.Journal;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JournalTest {
    final Logger LOG = LoggerFactory.getLogger("logger.debugger");

    public Scanner sc;
    public Journal journal;

    public Scanner textInput(String text){
        sc = new Scanner(text);
        return sc;
    }
    @Before
    public void init(){
       journal = new Journal();
    }

    @Test
    public void testA_createEntryTest() {
        LOG.debug("Test A Create entry running");
        boolean condition =  journal.createEntry(textInput("test0\n"));
        Assert.assertTrue(condition);
        LOG.debug("Test A Create entry passed");
    }

    @Test
    public void testB_alreadyCreatedEntryTest() {
        LOG.debug("Test B Duplicate Create entry running");
        boolean condition =  journal.createEntry(textInput("test0\n"));
        Assert.assertFalse(condition);
        LOG.debug("Test B Duplicate Create entry passed");
    }

    @Test
    public void testC_writeEntryTest() {
        LOG.debug("Test C Write entry running");
        boolean condition = journal.writeEntry(true, textInput("test0.txt\nHello World!\n"));
        Assert.assertTrue(condition);
        LOG.debug("Test C Write entry Passed");
    }

    @Test
    public void testD_readEntryTest(){
        LOG.debug("Test D Read entry running");
        boolean condition = journal.readEntry(textInput("test0.txt\n"));
        Assert.assertTrue(condition);
        LOG.debug("Test D read entry passed");
    }

    @Test
    public void testF_deleteEntryTest(){
        LOG.debug("Test F Delete entry running");
        boolean condition = journal.deleteEntry(textInput("test0.txt\n"));
        Assert.assertTrue(condition);
        LOG.debug("Test F Delete entry passed");
    }

    @After
    public void closeScanner(){
        sc.close();
    }
}
