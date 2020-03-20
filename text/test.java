import org.junit.Test;
import main.company.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Vector;
import static org.junit.Assert.assertEquals;

public class test
{
    Ignore WordToIgnore = new Ignore();
    Required WordsRequired = new Required(WordToIgnore);
    Filter filter  = new Filter();

    InputStream sysInBackup = System.in; // Backup System.in for Simulated CLI input
    ByteArrayInputStream in;

    Vector<String> Test = new Vector<String>();
    Vector<String> Result = new Vector<String>();

    @Test
    /**
     * Test 1
     * Regression Testing for basic KWIC Functionality:
     * Circular Shifting & Alphabetizing Input
    */
    public void Regression_For_Assignment_1()
    {
        Vector<String> OutputResult = new Vector<String>();
        Vector<String> CorrectOutput= new Vector<String>();

        input Input = new input(OutputResult);

        /* PREPARE SIMULATED CLI INPUT */
        in = new ByteArrayInputStream("run".getBytes()); // Use "run" as Simulated Input
        System.setIn(in); // Reset System.in to its original

        // read input and perform [Circular Shifting + Alphabetizing]
        Input.FileReader("TIC3001-Assignment1-testcases\\testcase1\\TitlesInput1.txt");

        // Read Correct Expected Output into test
        Read_Expected_Output(CorrectOutput);

        // assert output generated with Answer
        assertEquals(OutputResult, CorrectOutput);
    }

    @Test
    /*
    * Test that able to add Ignore Words
    * */
    public void Test_Add_Ignore_Word()
    {
        WordToIgnore.add_Word_to_Ignore("the");
        assertEquals(WordToIgnore.Get_List_of_Ignore_Words().toString(), "[the]");
    }

    @Test
    /*
     * Test that able to add Required Words
     * */
    public void Test_Add_Required_Word()
    {
        WordsRequired.add_Word_Required("Lemonade");
        assertEquals(WordsRequired.Get_List_of_Required_Words().toString(), "[Lemonade]");
    }

    @Test
    /**
     * Test 3
     * Test that Ignored words should be filtered out
     */
    public void Test_Ignore_Filter()
    {
        Test.add("The Wave Cool");
        Test.add("Lemonade is Great");
        Result.add("Lemonade is Great");
        WordToIgnore.add_Word_to_Ignore("the");
        filter.Remove_Ignore_Sentence(Test, WordToIgnore);
        assertEquals(Test, Result);
    }

    @Test
    /**
     * Test 4
     * Test that only Required Word will remain
     */
    public void Test_Required_Filter()
    {
        filter.Keep_Only_Sentence_Starting_With_Required(Test, WordsRequired);
        assertEquals(Test, Result);
    }

    /*
     * Helper Function to load Expected Result
    * */
    public void Read_Expected_Output(Vector<String> CorrectOutput)
    {
        boolean bool = false;

        do {
            try
            {
                String line;
                BufferedReader br = new BufferedReader(new FileReader("TIC3001-Assignment1-testcases\\testcase1\\Output1.txt"));
                //while ((SentenceHolder.Insert(br.readLine())) != null){
                while ((line = br.readLine()) != null) {

                    CorrectOutput.add(line);
                    br.mark(1000000000);

                    if ((line = br.readLine()) != null) //!line.equals("\n")
                    {
                        br.reset();
                    } else
                        break;
                }
                    bool = false;
                break;
            }
            catch (java.io.FileNotFoundException e) {
                System.out.println("Error File Not found");
                System.out.println("Please type \"input\" again to retry another file path or type \"exit\" to quit");
                bool = true;

            } catch (java.io.IOException e) {
                System.out.println("Error Reading File");
                System.out.println("Please type \"input\" again to retry another file path or type \"exit\" to quit");
                bool = true;
            }

        }while(bool);
    }

}
