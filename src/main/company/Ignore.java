package main.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

public class Ignore
{
    Vector<String> Ignore_Words = new Vector<String>();

    public void getIgnore_Words()
    {
        System.out.println("Please provide file path to list of Words to ignore ");
        GetFilePath();
        //System.out.println(Ignore_Words);
    }

    private void GetFilePath()
    {
            Scanner InputReader = new Scanner(System.in);
            String FilePath = InputReader.nextLine(); // get file Path
            Read_Word_to_Ignore(Ignore_Words, FilePath);
    }

    public void add_Word_to_Ignore(String Word_to_Ignore)
    {
        Ignore_Words.add(Word_to_Ignore);
    }

    public Vector<String> Get_List_of_Ignore_Words()
    {
        return Ignore_Words;
    }

    public void Read_Word_to_Ignore(Vector<String> Ignore_Words_List, String filepath)
    {
        boolean bool = false;

        do {
            try
            {
                String line;
                BufferedReader br = new BufferedReader(new FileReader(filepath));
                //while ((SentenceHolder.Insert(br.readLine())) != null){
                while ((line = br.readLine()) != null) {

                    Ignore_Words_List.add(line);
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

