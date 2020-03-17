package com.company;

import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class Main
{
    // Master Control Here
    public static void main(String[] args)
    {
        Ignore WordToIgnore = new Ignore();
        Required WordsRequired;

        while(true)
        {
            Vector<String> OutputStorage = new Vector<String>();
            System.out.println("The Following Command are accepted: input, exit, search");
            System.out.println("Please enter a command: ");
            Scanner InputReader = new Scanner(System.in);
            String command = InputReader.nextLine();
            Filter filter  = new Filter();

            switch(command.toLowerCase())
            {
                case "input":
                            // Get Input
                            input Input = new input(OutputStorage);
                            Input.GetInput();

                            // Get words to Ignore
                            WordToIgnore.getIgnore_Words();

                            // Get words Required
                            WordsRequired = new Required(WordToIgnore);
                            WordsRequired.getRequired_Words();

                            // Filter by Ignore Words
                            filter.Remove_Ignore_Sentence(OutputStorage, WordToIgnore);
                            filter.Keep_Only_Sentence_Starting_With_Required(OutputStorage, WordsRequired);

                            // Output
                            Output output = new Output(OutputStorage);
                            output.display();
                            output.CreateFile();
                            output.Write(OutputStorage);
                            break;

                case "search":
                            // Search
                            Search search = new Search();
                            search.SearchFile();
                            break;

                case "exit":
                            // Quit the Application
                            System.exit(0);

                //default: System.out.println("Please Enter a valid command");
            }
        }
    }
}
