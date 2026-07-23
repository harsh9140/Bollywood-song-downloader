package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class createFile {
    public static boolean create(String createwithName){

        File file=new File(createwithName);
        boolean fileCreated=false;
        try {

           fileCreated= file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        return fileCreated;}
    public static ArrayList<String> readAndPrintFile(String fileName) {
        Scanner scanner=null;
        ArrayList<String>strings=new ArrayList<>();
                try{
                    File file=new File(fileName);

                     scanner=new Scanner(file);

        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            strings.add(line);
            System.out.println(line);
        }}
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if (scanner!=null){
                scanner.close();
            }
                    }
                return strings;
        }


public static void main(String[] args){
        System.out.println("This side is harsh patel");
        System.out.println("running fileUtility at"+new Date().toString());
            String nameOfNewFile="C:\\Users\\harsh\\OneDrive\\Desktop\\java\\data\\practice\\file\\create-File.txt";
            Boolean created=create(nameOfNewFile);
            System.out.println("file created: "+created);
//readAndPrintFile(nameOfNewFile);
ArrayList<String>stringArrayList=readAndPrintFile(nameOfNewFile);
for (String row:stringArrayList){
    System.out.println("Line: "+row);

}
System.out.println("no of lines in file"+stringArrayList.size());

    }

}

