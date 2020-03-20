package main.company;

public class CircularShifter
{
    String[] Words;
    String TempContainer;
    Lines Circularly_Shifted_Sentence;

    public void Run_Circular_Shifter(String line)
    {
        Words = line.split(" ");
        Produce_Circular_Shifting_Permutation();
        //System.out.println(Circularly_Shifted_Sentence.Output());
    }

    public void Produce_Circular_Shifting_Permutation()
    {
        for(int PermutationCount = 1; PermutationCount <= Words.length; PermutationCount++)
            Circular_Shift_Once();
    }

    private void Circular_Shift_Once()
    {
        for (int i = 0; i < Words.length - 1; i++) {
            String Temp = Words[i + 1];
            Words[i + 1] = Words[i];
        }

        TempContainer = Words[Words.length-1];
        Words[0] = TempContainer;

        Circularly_Shifted_Sentence = new Lines();
        Circularly_Shifted_Sentence.Insert( ConvertToString(Words) );
    }

    private String ConvertToString(String[] Words)
    {
        String sentence = "";

        for(int i = 0; i < Words.length -1; i++)
            sentence = sentence + Words[i] + " ";

        return sentence.trim();
    }
}
