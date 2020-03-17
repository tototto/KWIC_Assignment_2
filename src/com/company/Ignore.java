package com.company;

import java.util.Scanner;
import java.util.Vector;

public class Ignore
{
    Vector<String> Ignore_Words = new Vector<String>();

    public void getIgnore_Words()
    {
        System.out.println("Please provide Words to Ignore (1 word at a time) : ");
        System.out.println("To stop providing Words to Ignore, type \"exit\" ");
        Keep_Getting_Line();
        System.out.println(Ignore_Words);
    }

    private void Keep_Getting_Line()
    {
        while(true)
        {
            Scanner InputReader = new Scanner(System.in);
            String Word_to_Ignore = InputReader.next(); // get only 1 word

            if(Word_to_Ignore.toLowerCase().compareTo("exit") == 0)
                break;

            add_Word_to_Ignore(Word_to_Ignore);
        }
    }

    private void add_Word_to_Ignore(String Word_to_Ignore)
    {
        Ignore_Words.add(Word_to_Ignore);
    }

    public Vector<String> Get_List_of_Ignore_Words()
    {
        return Ignore_Words;
    }
}

