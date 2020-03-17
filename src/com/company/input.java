package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

public class input
{
    private Lines SentenceHolder;

    public input(Vector<String> OutputStorage)
    {
        SentenceHolder = new Lines(OutputStorage);
    }

    // accept the full PATH of an input file
    public void GetInput()
    {
        System.out.println("Please provide full file path of Input.txt: ");
        Scanner InputReader = new Scanner(System.in);
        String FilePath = InputReader.nextLine();
        FileReader(FilePath);
    }

    public void FileReader(String FilePath)
    {
        boolean Retry = false;
        // try to read file
        do{
            if(Retry){
                System.out.println("Please provide full file path of Input.txt: ");
                Scanner InputReader = new Scanner(System.in);
                FilePath = InputReader.nextLine();

                if(FilePath.equals("exit") == true)
                    System.exit(0);
            }

            try {
                BufferedReader br = new BufferedReader(new FileReader(FilePath));
                System.out.println("File Has been Read Sucessfully, to continue type: \"run\", to Exit type \"exit\" ");
                Scanner InputReader = new Scanner(System.in);
                String command = InputReader.nextLine();
                switch (command.toLowerCase()) {
                    case "run":
                                //System.out.println("The input file consist of the following lines: ");
                                //read file line by line till EOF
                                String line;

                                //while ((SentenceHolder.Insert(br.readLine())) != null){
                                while ((line = br.readLine()) != null) {

                                    SentenceHolder.Insert(line);
                                    br.mark(1000000000);

                                    if ((line = br.readLine()) != null) //!line.equals("\n")
                                    {
                                        br.reset();
                                    } else
                                        break;
                                }
                                Retry = false;
                                break;

                    case "exit":
                                // Quit the Application
                                System.exit(0);
                                break;

                    default:    System.out.println("You must enter a valid command");
                                Retry = true;
                                break;
                }

            } catch (java.io.FileNotFoundException e) {
                System.out.println("Error File Not found");
                System.out.println("Please type \"input\" again to retry another file path or type \"exit\" to quit");
                Retry = true;

            } catch (java.io.IOException e) {
                System.out.println("Error Reading File");
                System.out.println("Please type \"input\" again to retry another file path or type \"exit\" to quit");
                Retry = true;
            }
        }while(Retry);
    }
}

