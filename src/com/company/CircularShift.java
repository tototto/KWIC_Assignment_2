package com.company;
import java.util.Vector;
import java.util.Arrays;

public class CircularShift
{
    private Vector<String> ShiftedSentence = new Vector();
    private String OriginalSentence;
    private String[] SentenceArray;
    private Alphabetizer alphabetizer;
    Filter filter;

    CircularShift(Vector<String> OutputStorage)
    {
        alphabetizer = new Alphabetizer(OutputStorage);
    }

    public void GetOriginalSentence (String OriginalSentence)
    {
        this.OriginalSentence = OriginalSentence;
    }

    public void Run()
    {
        BreakIntoArray();
        ProduceAllShiftPermutation();
        alphabetizer.Sort();
    }

    private void BreakIntoArray()
    {
        if(OriginalSentence != null)
            SentenceArray = OriginalSentence.split(" ");
    }

    private void ProduceAllShiftPermutation()
    {
        for(int Permutation = 0; Permutation < SentenceArray.length; Permutation++)
        {
            PerformShiftingOnce();
            String EachShiftedResult = JoinBackIntoSentence();
            //System.out.println(EachShiftedResult);
            ShiftedSentence.add(EachShiftedResult);
            SendToAlphabetizer(EachShiftedResult);
        }
    }

    private void PerformShiftingOnce()
    {
        String SaveFirstElement = SentenceArray[0];
        MoveAllElementLeft();
        Place_First_Element_In_Last_Position(SaveFirstElement);
    }

    private void MoveAllElementLeft()
    {
        for(int index = 1; index < SentenceArray.length ; index++)
            SentenceArray[index-1] = SentenceArray[index];
    }

    private void Place_First_Element_In_Last_Position(String FirstElement)
    {
        SentenceArray[SentenceArray.length-1] = FirstElement;
    }

    private String JoinBackIntoSentence()
    {
        String FullSentence = "";
        for(int i = 0; i < SentenceArray.length ; i++)
            FullSentence = FullSentence + SentenceArray[i] + " ";

        return FullSentence.trim();
    }

    private void SendToAlphabetizer(String EachShiftedResult)
    {
        alphabetizer.AlphabetizeThis(EachShiftedResult);
    }

}
