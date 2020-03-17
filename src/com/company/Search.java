package com.company;
import java.io.*;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Search
{
    File file;
    private Vector<String> SentenceToBeSearched = new Vector();
    private String SearchTerm;
    private Vector<String> SearchResult = new Vector();

    private void GetSearchTerm()
    {
        System.out.println("Please type your search term:");
        Scanner SearchTermReader = new Scanner(System.in);
        this.SearchTerm = SearchTermReader.nextLine();
    }

    private void GetFilePath()
    {
        System.out.println("Please provide full file path of Output.txt that you want to search");
        Scanner InputReader = new Scanner(System.in);
        String FilePath = InputReader.nextLine();

        FileReader(FilePath);
    }
    private void FileReader(String FilePath)
    {
        // try to read file
        boolean Retry = false;

        do{
                if(Retry){
                    System.out.println("Please provide full file path of Output.txt that you want to search");
                    Scanner InputReader = new Scanner(System.in);
                    FilePath = InputReader.nextLine();

                    if(FilePath.equals("exit") == true)
                        System.exit(0);
                }

                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(FilePath));
                    System.out.println("Searching File... ");

                    String line;

                    //read file line by line till EOF
                    while ((line = br.readLine()) != null)
                    {
                        SentenceToBeSearched.add(line);
                        br.mark(1000000000);

                        if( (line = br.readLine() ) != null )
                        {
                            br.reset();
                        }
                        else
                            break;
                    }
                    Retry = false;
                }
                //if file cannot be Read
                catch(java.io.FileNotFoundException e)
                {
                    System.out.println("Error File Not found");
                    System.out.println("Please re-enter file path again or type \"exit\" to quit");
                    Retry = true;
                }
                catch(java.io.IOException e)
                {
                    System.out.println("Error Reading File");
                    System.out.println("Please re-try or provide file path to another file type \"exit\" to quit");
                    Retry = true;
                }

        }while(Retry);
    }

    public void SearchFile()
    {
        GetSearchTerm();
        GetFilePath();
        LookForResult();
        DisplaySearchResult();
    }

    private void LookForResult()
    {
        int SearchTermSize = SearchTerm.length();

        Iterator i = SentenceToBeSearched.iterator();
        while (i.hasNext()) {
            String CurrentTerm = i.next().toString();
            if(SearchTerm.regionMatches(true, 0, CurrentTerm, 0, SearchTerm.length()))
                SearchResult.add(CurrentTerm);
        }
    }

    private void DisplaySearchResult()
    {
        System.out.println("The Result are:");
        Iterator i = SearchResult.iterator();
        while (i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
