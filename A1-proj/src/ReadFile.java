import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/** Class containing a file reading demo */
public class ReadFile {
  /** The main method reads from a file and prints the contents. */
  public static void main(String[] args) {
  }

  public String getFilename(String filename){
    return filename;
  }

  public String[] getStringData(int fieldNum, String filename){
    Scanner file = null;

    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    }
//    while (file.hasNextLine()) {
//      count++;
//    }

    String[] array = new String[365];

    for(int i = 0; i < array.length; i++){
      String line = file.nextLine();
      String[] fields = line.split("\\s+");

      array[i] = fields[fieldNum];
    }

    file.close();
    return array;
  }

  public float[] getFloatData(int fieldNum, String filename){
    Scanner file = null;

    int count = 0;

    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    }
//    while (file.hasNextLine()) {
//      count++;
//    }

    float[] array = new float[365];

    for(int i = 0; i < array.length; i++){
      String line = file.nextLine();
      String[] fields = line.split("\\s+");

      array[i] = Float.parseFloat(fields[fieldNum]);
    }

    file.close();
    return array;
  }


}