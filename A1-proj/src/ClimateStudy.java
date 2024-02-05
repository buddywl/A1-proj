import java.io.*;
public class ClimateStudy {
    public static void main(String[] args){
        ReadFile file = new ReadFile();

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

        printData(twentyThree);
        printData(twentyTwo);
        printData(twentyOne);
        printData(twenty);
        printData(nineteen);
        printData(eighteen);
        printData(seventeen);
        printData(sixteen);
        printData(fifteen);
        printData(fourteen);
    }

    public static float annualMean(String filename){
        ReadFile file = new ReadFile();
        ClimateQueries cq = new ClimateQueries();
        float[] data = file.getFloatData(7, filename);

        return cq.mean(data, cq.logicalNot(cq.isEqualTo(data, -9999.0f)));

    }

    public static int overThirty(String filename){
        ReadFile file = new ReadFile();
        ClimateQueries cq = new ClimateQueries();
        float[] data = file.getFloatData(5, filename);

        return cq.count(cq.isGreaterThan(data, 30));
    }

    public static int getYear(String filename){
        ReadFile file = new ReadFile();
        String[] data = file.getStringData(1, filename);

        String yearString = data[0].substring(0,4);
        return Integer.parseInt(yearString);
    }


    public static String getFirst(String filename){
        ReadFile file = new ReadFile();
        ClimateQueries cq = new ClimateQueries();

        float[] tempData = file.getFloatData(7, filename);
        String[] dates = file.getStringData(1, filename);
        int index = cq.findFirst(cq.isGreaterThan(tempData, annualMean(filename)));

        String month = dates[index].substring(4,6);
        String day = dates[index].substring(6,8);
        String year = dates[index].substring(0,4);

        if(month.equals("01")){
            month = "January";
        } else if (month.equals("02")){
            month = "February";
        } else if (month.equals("03")){
            month = "March";
        } else if (month.equals("04")){
            month = "April";
        } else if (month.equals("05")){
            month = "May";
        } else if (month.equals("06")){
            month = "June";
        } else if (month.equals("07")){
            month = "July";
        } else if (month.equals("08")){
            month = "August";
        } else if (month.equals("09")){
            month = "September";
        } else if (month.equals("10")){
            month = "October";
        } else if (month.equals("11")){
            month = "November";
        } else if (month.equals("12")){
            month = "December";
        }

        return month + " " + day + " " + year;
    }

    public static void printData(String filename){
        int year = getYear(filename);
        float annualMean = annualMean(filename);
        String firstOccurrence = getFirst(filename);
        int numThirty = overThirty(filename);

        System.out.println(year + "\n-------");
        System.out.println("The annual mean for " + year + " was:   " + annualMean + " degrees Celsius");
        System.out.println("The first temperature greater than the annual mean occurred on:   " + firstOccurrence);
        System.out.println("Number of days greater than 30 degrees:   " + numThirty + " days");
        System.out.println("\n\n");
    }


}
