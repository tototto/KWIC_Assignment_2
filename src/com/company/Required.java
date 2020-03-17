package com.company;
import java.util.*;
import java.util.Scanner;
import java.util.Vector;

public class Required
{
    Vector<String> Required = new Vector<String>();
    Ignore Words_to_Ignore;

    Required(Ignore Words_to_Ignore)
    {
        this.Words_to_Ignore = Words_to_Ignore;
    }

    public Vector<String> Get_List_of_Required_Words()
    {
        return Required;
    }

    public void getRequired_Words()
    {
        System.out.println("Please provide Words Required (1 word at a time) : ");
        System.out.println("To stop providing Words Required, type \"exit\" ");
        Keep_Getting_Line();
        System.out.println(Required);
    }

    private void Keep_Getting_Line()
    {
        while(true)
        {
            Scanner InputReader = new Scanner(System.in);
            String Words_Required = InputReader.next(); // get only 1 word

            if(Words_Required.toLowerCase().compareTo("exit") == 0)
                break;

            add_Word_Required(Words_Required);
        }
    }

    private void add_Word_Required(String Words_Required)
    {
        if(check_Word_is_Already_in_Ignore_List(Words_Required) == false)
            Required.add(Words_Required);
        else
            System.out.println("This word was found in your words to ignore. Please try again.");
    }

    private  boolean check_Word_is_Already_in_Ignore_List(String Words_Requireid)
    {
        if(Words_to_Ignore.Get_List_of_Ignore_Words() == null || Words_to_Ignore.Get_List_of_Ignore_Words().isEmpty())
            return false;

        boolean result = Words_to_Ignore.Get_List_of_Ignore_Words().contains(Words_Requireid);
        return result;
    }
}
