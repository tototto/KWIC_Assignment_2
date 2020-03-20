package main.company;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer
{
    Vector<String> AlphabetizedResults;

    Alphabetizer(Vector<String> OutputStorage)
    {
        AlphabetizedResults = OutputStorage;
    }

    public void AlphabetizeThis(String ResultToAlphabetized)
    {
        AlphabetizedResults.add(ResultToAlphabetized);
    }

    public void Sort()
    {
        Collections.sort(AlphabetizedResults, new SortIgnoreCase());
    }

    public class SortIgnoreCase implements Comparator<Object>
    {
        public int compare(Object o1, Object o2)
        {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return s1.toLowerCase().compareTo(s2.toLowerCase());
        }
    }
}
