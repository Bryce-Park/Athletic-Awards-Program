package Reader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;


public class excelReader {

    //private FileInputStream excelFile = FileInputStream;


    //private static final String FILE_NAME = "/tmp/MyFirstExcel.xlsx";

    public excelReader()
    {
        /*
        ArrayList<String> output = new ArrayList<String>();

        try {

            FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/excelTest/Writesheet.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            //System.out.println("ping0");

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                //create student class here

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0

                    //add to student class here
                    output.add(currentCell.getStringCellValue());

                }

                //add to student arrayList

                System.out.println("ping");
                return output;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
        //return null;
    }

    public ArrayList<String> getRow(int input,String targetFile)
    {
        ArrayList<String> output = new ArrayList<String>();

        System.out.println("test start");

        try {

            FileInputStream excelFile = new FileInputStream(new File(targetFile));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            Row testRow;
            testRow = datatypeSheet.getRow(input);
            Iterator<Cell> cellIterator = testRow.iterator();
            //cellIterator.next(); //TODO figure out what is in column A on the input sheet
            int tracker = 0;
            while (cellIterator.hasNext())
            {
                Cell currentCell = cellIterator.next();
                System.out.println("Cell Column Check: "+currentCell.toString()+" "+currentCell.getColumnIndex());

                while(currentCell.getColumnIndex()>tracker)
                {
                    System.out.println("Flag 1");
                    output.add("-");
                    tracker++;
                }

                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                System.out.print(currentCell.toString());
                System.out.println(" Filler "+ currentCell.toString().length());
                if(currentCell.toString().length()==0)
                {
                    //System.out.println("ping1");
                    System.out.println("Flag 0");
                    output.add("-");
                }
                else
                {
                    output.add(currentCell.toString());
                }
                tracker++;
            }

            if(12>output.size())
            {
                while(12>output.size())
                {
                    output.add("-");
                }
            }
            System.out.println("reader output check");
            for(int counter=0;counter<output.size();counter++)
            {
                System.out.print(output.get(counter)+" ");
            }

            System.out.println("ping0");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return output;
    }

    public ArrayList<String> headerCreater(String targetFile)
    {
        ArrayList<String> output = new ArrayList<String>();

        System.out.println("test start");

        try {

            FileInputStream excelFile = new FileInputStream(new File(targetFile));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            Row testRow;
            testRow = datatypeSheet.getRow(0);
            Iterator<Cell> cellIterator = testRow.iterator();

            //while (cellIterator.hasNext())
            //while (int cellCounter < 12)
            for(int cellCounter=0;cellCounter<12;cellCounter++)
            {

                Cell currentCell = cellIterator.next();
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                System.out.print(currentCell.toString());
                System.out.println(" Filler "+ currentCell.toString().length());
                if(currentCell.toString().length()==0)
                {
                    //System.out.println("ping1");
                    output.add(" ");
                }
                else
                {
                    output.add(currentCell.toString());
                }


            }

            System.out.println("ping0");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return output;
    }

    public ArrayList<String> getColumn(int startNumber,int columnNumber, String inputFile)
    {
        ArrayList<String> output = new ArrayList<String>();
        try {

            FileInputStream excelFile = new FileInputStream(new File(inputFile));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            int columnSize = datatypeSheet.getLastRowNum()+1;
            Iterator<Cell> cellIterator;

            Row testRow;
            for(int cA=startNumber;cA<columnSize;cA++)
            {
                testRow = datatypeSheet.getRow(cA);
                cellIterator = testRow.iterator();

                Cell currentCell = cellIterator.next();
                for(int cB=0;cB<columnNumber-1;cB++)
                {
                    currentCell = cellIterator.next();
                }

                output.add(currentCell.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public ArrayList<student> createStudentListFromData(int numRows)
    {
        ArrayList<student> outputList = new ArrayList<student>();
        ArrayList<String> receivingList = new ArrayList<String>();
        ArrayList<date> fillDateList = new ArrayList<date>();
        int tempInt;
        student tempStudent;
        for(int counter = 0; counter< numRows; counter++)
        {
            System.out.println("Ping:" + counter);
            receivingList = this.getRowFromIndicated(counter+1);
            System.out.println(receivingList.get(0));
            tempInt = Integer.parseInt(receivingList.get(0));
            tempStudent = new student(tempInt, receivingList.get(2), receivingList.get(1), receivingList.get(2));
            outputList.add(tempStudent);

        }

        return outputList;
    }

    public ArrayList<String> getRowFromIndicated(int input)
    {
        ArrayList<java.lang.String> output = new ArrayList<java.lang.String>();

        System.out.println("test start");

        try {

            FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/Athletics Awards Program/data.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            Row testRow;
            testRow = datatypeSheet.getRow(input);
            Iterator<Cell> cellIterator = testRow.iterator();

            while (cellIterator.hasNext()) {

                Cell currentCell = cellIterator.next();
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                System.out.print(currentCell.toString());
                System.out.println(" Filler");
                output.add(currentCell.toString());
            }

            System.out.println("ping0");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return output;
    }

    public ArrayList<String> getTest(int input)
    {
        ArrayList<String> output = new ArrayList<String>();

        System.out.println("test start");

        try {

            FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/excelTest/Writesheet.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            Row testRow;
            testRow = datatypeSheet.getRow(input);
            Iterator<Cell> cellIterator = testRow.iterator();

            while (cellIterator.hasNext()) {

                Cell currentCell = cellIterator.next();
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                System.out.println(currentCell.getStringCellValue());
                //add to student class here
                output.add(currentCell.getStringCellValue());

            }

            System.out.println("ping0");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return output;
    }

}