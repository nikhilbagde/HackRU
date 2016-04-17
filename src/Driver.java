import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *  (1) Validate that command line inputs for input and output file names.
 (2) Create the element(s)
 (3) Create the two visitor instances
 (4) Use the performance measurement loop given above.
 */

public class Driver {
    public static void main(String args[]) throws IOException {
        FileProcessor inputProcessor = new FileProcessor("input.txt");
        FileProcessor nameProcessor = new FileProcessor("lang.txt");
        FileProcessor codeProcessor = new FileProcessor("langab.txt");
        String[] langCode = new String[50];
        String[] lang = new String[50];
        String outputFile="output.txt";

        //outputFile = args[1].trim();

        int[] languageScore = new int[50];
        boolean[] latin = {false,true,false, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true,false, false,
                true, true, true, true, true, true, true,false, true, true,
                true, true, true, true, true, true, true, true,false,false,
                false, true, true, true, true, true, true ,true , true, true, true ,true , true, true};
        int[][] scoreArray = new int[50][50];

        WebDriver driver = new FirefoxDriver();

        String line1,line2;
        int counter1=0, counter2=0;
        while ((line1 = nameProcessor.readLineFromFile())!=null){
            lang[counter1]=line1;
            counter1++;
        }

        while ((line2 = codeProcessor.readLineFromFile())!=null){
            langCode[counter2]=line2;
            counter2++;
        }

        String[] englishDictionary = new String[100];
        int counter=0;

        String line = null;

        while (((line = inputProcessor.readLineFromFile())!=null) && counter<100){
            englishDictionary[counter]=line;
            counter++;
        }

        counter=0;

        String[][] dictionary = new String[52][100];

        String back_url = " . " + englishDictionary[counter];

        for (int i=1; i<99; i++) {
            counter++;

            back_url += " . " + englishDictionary[counter];
        }

        for (int b=0; b<lang.length; b++) {
            languageScore[b]=0;
            String url = "http://translate.google.com/#en/" + langCode[b] + "/" + back_url;
            counter=0;

            if (latin[b]==true) {
                dictionary[b] = Selenium2Example.get2(url,driver);
            } else {
                dictionary[b] = Selenium2Example.get1(url,driver);
            }
            System.out.println( lang[b] + " dictionary : " + dictionary[b].length );
        }


        //BufferedWriter bw = null;
        int count = 0;
        //bw = new BufferedWriter(new FileWriter(outputFile, true));
        for (int x=0; x<50; x++) {
            for (int y=0; y<50; y++) {
                count = 0;
                for (int i=0; i<90; i++) {
                    scoreArray[x][y] = StringOperations.compareString(dictionary[x][i], dictionary[y][i]);
                    count += StringOperations.compareString(dictionary[x][i], dictionary[y][i]);

                    //System.out.print("score : " + scoreArray[x][y]);
                    //System.out.println(" Count : " + count);
                     //inputProcessor.writeLineToFile(outputFile, scoreArray);
                    //bw.write(String.valueOf(scoreArray[x][y]));
                    //bw.write(String.valueOf(scoreArray[x][y] + " " + count));
                    //bw.newLine();
                }
                inputProcessor.writeLineToFile(outputFile, scoreArray[x][y], count);
                //bw.write(String.valueOf(scoreArray[x][y] + " " + count));
                //bw.newLine();
            }


        }

        //System.out.println("This is final output :" + Arrays.toString(scoreArray));
        //bw.close();
    }
}