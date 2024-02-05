import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/** Class containing a file reading demo */
public class ReadFile {
  /** The main method reads from a file and prints the contents. */
  public static String filename = "C:/Users/buddy/Documents/GitHub/A1-proj/A1-proj/data/YUMA_2023.txt";
  public static void main(String[] args) {

  }

  public static String getFilename(){
    return filename;
  }

  public static String[] getStringData(int fieldNum){
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

  public static float[] getFloatData(int fieldNum){
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