import org.junit.Assert;
import org.junit.Test;
import com.company.*;

import java.util.Vector;

public class test
{
    Vector<String> outputStorage = new Vector<String>();
    input Input = new input(outputStorage);

    @Test
    public void TestFileReading()
    {
        Input.FileReader("C:\\Users\\P0500236\\Desktop\\U\\Requirements\\TIC3001-Updated-Assignment1-testcases\\testcase1\\TitlesInput1.txt");
    }


}
