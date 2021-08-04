import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import com.github.jm27.p0.application.Helpers;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelpersTest {
    private final Helpers helpers = new Helpers();
    private final String PATH_NAME = Paths.get("Journal_Entries").toAbsolutePath().toString();

    @Test
    public void checkFileTest() {
        boolean actual = helpers.checkFile("test.txt", PATH_NAME);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void listFilesTest(){

        boolean expected = true;

    }

//    @Test
//    public void getTimeTest(){
//        LocalDateTime date = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy-hh-mm");
//        String text = date.format(formatter);
//        String expected = text;
//        String actual = helpers.getTime();
//        Assert.assertEquals(expected, actual);
//    }
}
