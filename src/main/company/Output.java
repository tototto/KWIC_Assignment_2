package main.company;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Output
{
    private File file;
    private Vector<String> output;

    public Output(Vector<String> output)
    {
        this.output = output;
    }

    public void ProvideFileName()
    {
        System.out.println("");
        System.out.println("Please Name your Output File:");
        Scanner FileName = new Scanner(System.in);
        String OutputFileName = FileName.nextLine();
        file = new File("./"+OutputFileName+".txt");
    }

    public void CreateFile()
    {
        ProvideFileName();

        try{
            if (file.createNewFile())
            {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (java.io.IOException e)
        {
            System.out.println("An Error Occurred while creating the file");
        }

    }

    public void Write(Vector<String> OutputToBeWritten)
    {
        //Write Content
        try{
            //FileWriter writer = new FileWriter(file);
            FileOutputStream OutputStream = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(OutputStream));

            for(int i = 0; i < OutputToBeWritten.size(); i++)
            {
                String sentence = OutputToBeWritten.get(i);
                writer.write(sentence);
                writer.newLine();
            }
            System.out.println("Your Output Text File has been generated");
            writer.close();
        }
        catch (java.io.IOException e)
        {
            System.out.println("An Error Occurred while writing the file");
        }

    }

    public void display()
    {
        Iterator i = output.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
