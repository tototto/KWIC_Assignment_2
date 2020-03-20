package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;
import java.util.Vector;

public class Required
{
    Vector<String> Required = new Vector<String>();
    Ignore Words_to_Ignore;

    public Required(Ignore Words_to_Ignore)
    {
        this.Words_to_Ignore = Words_to_Ignore;
    }

    public Vector<String> Get_List_of_Required_Words()
    {
        return Required;
    }

    public void getRequired_Words()
    {
        System.out.println("Please provide file path to list of Words Required ");
        GetFilePath();
        //System.out.println(Required);
    }

    private void GetFilePath()
    {
            Scanner InputReader = new Scanner(System.in);
            String FilePath = InputReader.nextLine(); // get file Path
            Read_Word_Required(FilePath);
    }

    public void add_Word_Required(String Words_Required)
    {
        if(check_Word_is_Already_in_Ignore_List(Words_Required) == false)
            Required.add(Words_Required);
        //else
            // nothing will be added
    }

    private  boolean check_Word_is_Already_in_Ignore_List(String Words_Requireid)
    {
        if(Words_to_Ignore.Get_List_of_Ignore_Words() == null || Words_to_Ignore.Get_List_of_Ignore_Words().isEmpty())
            return false;

        boolean result = Words_to_Ignore.Get_List_of_Ignore_Words().contains(Words_Requireid);
        return result;
    }

    public void Read_Word_Required(String filepath)
    {
        boolean bool = false;

        do {
            try
            {
                String line;
                BufferedReader br = new BufferedReader(new FileReader(filepath));
                //while ((SentenceHolder.Insert(br.readLine())) != null){
                while ((line = br.readLine()) != null) {

                    add_Word_Required(line);
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
