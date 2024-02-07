import java.io.*;
public class ClimateStudy {
    /**
     * Prints out climate data for the given file and demonstrates the use of methods written in the class
     * @param args The command line arguments (ignored)
     **/
    public static void main(String[] args){
        File twentyThree_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2023.txt");
        File twentyTwo_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2022.txt");
        File twentyOne_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2021.txt");
        File twenty_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2020.txt");
        File nineteen_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2019.txt");
        File eighteen_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2018.txt");
        File seventeen_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2017.txt");
        File sixteen_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2016.txt");
        File fifteen_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2015.txt");
        File fourteen_Path = new File((args.length > 0) ? args[0] : "A1-proj/Data/Dinosaur/Dinosaur_2014.txt");

        String twentyThree = twentyThree_Path.getAbsolutePath();
        String twentyTwo = twentyTwo_Path.getAbsolutePath();
        String twentyOne = twentyOne_Path.getAbsolutePath();
        String twenty = twenty_Path.getAbsolutePath();
        String nineteen = nineteen_Path.getAbsolutePath();
        String eighteen = eighteen_Path.getAbsolutePath();
        String seventeen = seventeen_Path.getAbsolutePath();
        String sixteen = sixteen_Path.getAbsolutePath();
        String fifteen = fifteen_Path.getAbsolutePath();
        String fourteen = fourteen_Path.getAbsolutePath();

        System.out.println("------------------------------------------------------------");
        System.out.println("* Printing Climate Data for Dinosaur, CO from 2014 to 2023 *");
        System.out.println("------------------------------------------------------------");

        printData(fourteen, twentyThree);
        printData(fourteen, twentyTwo);
        printData(fourteen, twentyOne);
        printData(fourteen, twenty);
        printData(fourteen, nineteen);
        printData(fourteen, eighteen);
        printData(fourteen, seventeen);
        printData(fourteen, sixteen);
        printData(fourteen, fifteen);
        printData(fourteen, fourteen);

        System.out.println("------------------------------------------------------------");

        float[] annualMeans = {annualMean(fourteen), annualMean(fifteen), annualMean(sixteen), annualMean(seventeen), annualMean(eighteen), annualMean(nineteen), annualMean(twenty), annualMean(twentyOne), annualMean(twentyTwo), annualMean(twentyThree)};
        float mean1 = ArrayMethods.mean(annualMeans, 0, 5);
        float mean2 = ArrayMethods.mean(annualMeans,  5, 10);

        System.out.println("** DATA ANALYSIS **");
        System.out.println("The annual mean temperature for the years 2014 - 2018 was " + mean1 + " degrees Celsius");
        System.out.println("and the annual mean temperature for the years 2019 - 2023 was " + mean2 + " degrees Celsius");
        System.out.println("\n* Though we would expect the temperature to increase in more recent years based on current \nclimate trends, the opposite is true for the past 10 years in Dinosaur, CO. This is \nevident when considering that the average temperature during the first five years of the \ntime frame was greater than the second five years of the time frame.");
        System.out.println("\n* Furthermore, when examining the yearly data provided above, there does not seem to be a \nclear trend in temperature. There is no obvious relationship between the year and the first \noccurrence of a temperature greater than the annual mean in 2014, and the number of days \nin which the maximum temperature exceeds 30 degrees is variable across the ten years, This \nmay be due to lack of crucial data points, which indicates that a deeper statistical \nanalysis is necessary.");
    }

    /**
     Parses and array of floats which is extracted from a data file and returns out the mean of that data.
     * @param filename path to the data file
     * @return a float containing the annual mean of that year
     **/
    public static float annualMean(String filename){
        float[] data = ReadFile.getFloatData(8, filename);
        return ClimateQueries.mean(data, ClimateQueries.logicalNot(ClimateQueries.isEqualTo(data, -9999.0f)));

    }

    /**
     * Parses an array of floats which is extracted from a data file and returns out the number of values greater than 30.
     * @param filename path to the data file
     * @return an int number of values greater than 30
     **/
    public static int overThirty(String filename){
        float[] data = ReadFile.getFloatData(5, filename);

        return ClimateQueries.count(ClimateQueries.isGreaterThan(data, 30));
    }

    /**
     * returns the year of interest in which data from a file was taken
     * @param filename path to the data file
     * @return an int containing the year that the data was taken
     **/
    public static int getYear(String filename){
        String[] data = ReadFile.getStringData(1, filename);

        String yearString = data[0].substring(0,4);
        return Integer.parseInt(yearString);
    }

    /**
     * Reads an array of string containing the dates of data points and an array of floats containing the maximum temperatures
     * @param filename path to the data file
     * @param firstYear the path to the first year of data taken
     * @return a string containing the first day in which the temperature exceeded the annual mean temperature for the first year
     **/
    public static String getFirst(String firstYear, String filename){
        float[] tempData = ReadFile.getFloatData(7, filename);
        String[] dates = ReadFile.getStringData(1, filename);
        int index = ClimateQueries.findFirst(ClimateQueries.isGreaterThan(tempData, annualMean(firstYear)));

        String month = dates[index].substring(4,6);
        String day = dates[index].substring(6,8);
        String year = dates[index].substring(0,4);

        month = switch (month) {
            case "01" -> "January";
            case "02" -> "February";
            case "03" -> "March";
            case "04" -> "April";
            case "05" -> "May";
            case "06" -> "June";
            case "07" -> "July";
            case "08" -> "August";
            case "09" -> "September";
            case "10" -> "October";
            case "11" -> "November";
            case "12" -> "December";
            default -> month;
        };

        return month + " " + day + " " + year;
    }
    /**
     * Prints out climate data for the given file
     * @param filename path to the data file
     **/
    public static void printData(String firstYear, String filename){
        int year = getYear(filename);
        float annualMean = annualMean(filename);
        String firstOccurrence = getFirst(firstYear, filename);
        int numThirty = overThirty(filename);

        System.out.println(year + " ----");
        System.out.println("| *  The annual mean temperature in " + year + " was: " + annualMean + " degrees Celsius");
        System.out.println("| *  The first temperature greater than the annual mean occurred on: " + firstOccurrence);
        System.out.println("| *  Number of days greater than 30 degrees: " + numThirty + " days");
        System.out.print("\n");
    }


}
