package main.company;

import java.util.Iterator;
import java.util.Vector;

public class Filter
{
    public void Remove_Ignore_Sentence(Vector<String> Result, Ignore IgnoreList)
    {
        // remove all sentences that start with word in IGNORE list
        Iterator iter = Result.iterator();

        if(!IgnoreList.Get_List_of_Ignore_Words().isEmpty())
        {
            while (iter.hasNext()) {
                if (Check_Begins_With_Ignore_Words(iter.next().toString(), IgnoreList) == true)
                    iter.remove();
            }
        }
    }

    private boolean Check_Begins_With_Ignore_Words(String CurrentSentence, Ignore IgnoreList)
    {
        String firstWord = CurrentSentence.split(" ")[0].toLowerCase();
        Iterator iter = IgnoreList.Get_List_of_Ignore_Words().iterator();

        while (iter.hasNext())
        {
            if(iter.next().toString().toLowerCase().compareTo(firstWord) == 0)
                return true;
        }
        return false;
    }

    public void Keep_Only_Sentence_Starting_With_Required(Vector<String> Result, Required RequiredList)
    {
        // Keep all sentences that start with word in REQUIRED list
        Iterator iter = Result.iterator();

        if(!RequiredList.Get_List_of_Required_Words().isEmpty())
        {
            while (iter.hasNext()) {
                if (Check_Begins_With_Required_Words(iter.next().toString(), RequiredList) == false)
                    iter.remove();
            }
        }
    }

    private boolean Check_Begins_With_Required_Words(String CurrentSentence, Required RequiredList)
    {
        String firstWord = CurrentSentence.split(" ")[0].toLowerCase();
        Iterator iter = RequiredList.Get_List_of_Required_Words().iterator();

        while (iter.hasNext())
        {
            if(iter.next().toString().toLowerCase().compareTo(firstWord) == 0)
                return true;
        }
        return false;
    }
}
