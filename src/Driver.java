import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  (1) Validate that command line inputs for input and output file names.
    (2) Create the element(s)
    (3) Create the two visitor instances
    (4) Use the performance measurement loop given above.
 */

public class Driver {

	public static void main(String args[]) {

        int DEBUG_VALUE=0, NUM_ITERATION=0;
        String inputFile="", outputFile="";
        if(args.length < 1){
            System.err.println("Incorrect number of argument entered! " + args.length);
            throw new IllegalArgumentException();
        }else{
            try {
                StringOperations stringOperations = new StringOperations();
                FileProcessor fileProcessor = new FileProcessor(args[0].trim());

                String line = null;
                while ((line = fileProcessor.readLineFromFile())!=null){
                    stringOperations.processInputString(line);
                }
                stringOperations.displayCount();
                fileProcessor.reader.close();



            } catch(NumberFormatException e) {
                System.err.println("Invalid Number of Iteration argument value entered!");
                e.printStackTrace();
                System.exit(1);
            } catch (ArrayIndexOutOfBoundsException e){
                System.err.println(" Out of bound value entered.");
                e.printStackTrace();
                System.exit(1);
            } catch (FileNotFoundException e) {
                System.err.println("Entered File can not be opened!, Please specify right file name. ");
                e.printStackTrace();
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            } finally {
                //fileProcessor.scanner.close();
            }
        }
	}
}

