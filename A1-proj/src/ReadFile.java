import java.io.*;
import java.util.Scanner;

/** Class containing a file reading demo */
public class ReadFile {
  /** The main method reads from a file and prints the contents. */
  public static void main(String[] args) {
    System.out.println(getFilename("data/YUMA_2023.txt"));
  }

  public static String getFilename(String filename){
    return filename.substring(filename.indexOf("data")+5);
  }

  public static String[] getStringData(int fieldNum, String filename){
    Scanner file = null;
    Scanner newFile = null;
    int count = 0;

    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    }

    while(file.hasNextLine()){
      count++;
      file.nextLine();
    }
    file.close();

    try {
      newFile = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    }

    String[] array = new String[count];

    for(int i = 0; i < array.length; i++){
      String line = newFile.nextLine();
      String[] fields = line.split("\\s+");

      array[i] = fields[fieldNum];
    }

    newFile.close();
    return array;
  }

  public static float[] getFloatData(int fieldNum, String filename){
    Scanner file = null;
    Scanner newFile = null;
    int count = 0;

    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    }

    while(file.hasNextLine()){
      count++;
      file.nextLine();
    }

    try {
      newFile = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("Cannot locate file.");
      System.exit(-1);

    }

    float[] array = new float[count];

    for(int i = 0; i < array.length; i++){
      String line = newFile.nextLine();
      String[] fields = line.split("\\s+");

      array[i] = Float.parseFloat(fields[fieldNum]);
    }

    newFile.close();
    return array;
  }


}