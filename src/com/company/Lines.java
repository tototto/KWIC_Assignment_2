package com.company;
import java.util.*;

public class Lines
{
    private Vector<String> sentence = new Vector();
    private CircularShift Sentence_Shifter;

    Lines(Vector<String> OutputStorage)
    {
        Sentence_Shifter = new CircularShift(OutputStorage);
    }

    public Lines()
    {}

    public String Insert(String line)
    {
        if( !line.equals("") ){
            sentence.add(line);
            Sentence_Shifter.GetOriginalSentence(line);
            Sentence_Shifter.Run();
        }

        return sentence.lastElement();
    }

}
