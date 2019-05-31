package Reader;

import java.util.ArrayList;
import java.util.Calendar;

public class processor
{
    public processor()
    {
        //ArrayList<student> studentList = generateStudentList(inputSheet);
    }

    public ArrayList<awardForm> generateAwardForms(String inputSheet, int season, String requestSport)
    {
        //fall season = 0, spring season = 1
        //change season to mean either fall or spring

        ArrayList<student> studentList = generateStudentList(inputSheet);
/*
        excelReader excelReaderTest = new excelReader();
        ArrayList<String> rowTest = excelReaderTest.getRow(321,"C:/Users/jpark/IdeaProjects/Athletics Awards Program/Athletic Awards File Examples/athletic awards for Spring 2016.xlsx");
        ArrayList<student> studentList = new ArrayList<>();
        studentList.add(new student(rowTest));
*/

        ArrayList<Integer> indexList = new ArrayList<>();
        ArrayList<student> selectedStudentList = new ArrayList<student>();
        int tracker;
        int seasonNumber = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR) - season;
        currentYear =2017; //TODO delete when done testing
        int tempInt =(currentYear);
        tempInt = tempInt - 2000;
        for(int cA=0;cA<studentList.size();cA++)
        {
            tracker = 0;
            seasonNumber = ((4 - (studentList.get(cA).getGrade() - tempInt)) * 2) - season; //TODO make sure to test code
            seasonNumber --;
            System.out.println("Student Grade: "+studentList.get(cA).getGrade());
            System.out.println("Temp Int: "+tempInt);
            System.out.println("Season: "+season);
            System.out.println("Season Number: "+seasonNumber);
            System.out.println(studentList.get(cA));

            //seasonNumber = 0;
//TODO figure out what is happening with the season number
            if(studentList.get(cA).getLevels().
                    get(seasonNumber).getLevel().length()
                    >-1&&studentList.get(cA).getLevels().
                    get(seasonNumber).getLevel().indexOf("/")>-1)
            {
            String currentSport = studentList.get(cA).getLevels().get(seasonNumber).getLevel().substring(0,studentList.get(cA).getLevels().get(seasonNumber).getLevel().indexOf("/"));

            System.out.println("current sport{"+currentSport+"} {"+requestSport+"} requested sport");

                if(currentSport.equals(requestSport))
                {
                    indexList.add(cA);
                    /*
                    System.out.println("Begin indexList test");
                    for(int counter=0;counter<indexList.size();counter++)
                    {
                        System.out.println(indexList.get(counter));
                    }
                    System.out.println("End indexList test");
                    System.out.println("Begin student list tests");
                    System.out.println("Current cA: "+cA);
                    System.out.println("indexList test: "+indexList.get(cA));
                    System.out.println("studentList test: "+studentList.get(indexList.get(cA)));
                    */
                    //selectedStudentList.add(studentList.get(indexList.get(tracker)));
                    selectedStudentList.add(studentList.get(cA));
                    tracker++;
                    studentList.get(cA).inputRepeatCount(tracker);
                }
            }

            /*
            for(int cB=0;cB<studentList.get(cA).getLevels().size();cB++)
            {
                //TODO figure out why the number is way off

                //currentYear = currentYear-2000; //TODO if you're using this in year 3000+ AD, you need to update the code. -3/14/19

                //System.out.println("current year: "+currentYear);
                seasonNumber = ((4 - (studentList.get(cA).getGrade() - tempInt)) * 2) + season; //TODO make sure to test code
                System.out.println("Season Number: "+seasonNumber);

                if(true)
                {
                    tracker++;
                    indexList.add(cA);
                    selectedStudentList.add(studentList.get(indexList.get(cA)));

                    studentList.get(cA).inputRepeatCount(tracker);
                }
            }
            */
        }

        System.out.println("Begin selected student list test");

        for(int counter=0;counter<selectedStudentList.size();counter++)
        {
            System.out.println(selectedStudentList.get(counter));
        }


        //TODO create code that determines which category is being used (after finishing test sample code)

        //TODO create test code that creates sheets for varsity students (add Management tag before finishing testing)
        ArrayList<awardForm> awardFormList = new ArrayList<>();
        for(int cA=0;cA<selectedStudentList.size();cA++)
        {
            seasonNumber = ((4 - (selectedStudentList.get(cA).getGrade() - tempInt)) * 2) + season; //TODO make sure to test code
            seasonNumber--;
            System.out.println("Season Number: "+seasonNumber);
            awardFormList.add(new awardForm(selectedStudentList.get(cA),seasonNumber)); //TODO make sure code actually works
        }

        return awardFormList;

    }

    public ArrayList<student> generateStudentList(String inputSheet) //TODO change back to private before completion
    {
        ArrayList<student> output = new ArrayList<student>();

        //TODO create code that converts the sheet into student list
        excelReader localExcelReader = new excelReader();
        //ArrayList<String> headerHolder = localExcelReader.headerCreater(inputSheet);

        //TODO find number of students
        int rowCount = localExcelReader.getColumn(1,0,inputSheet).size();
        ArrayList<String> inputRow =  new ArrayList<>();
        int tracker = 13;
        while(true) //TODO figure out what witchcraft is going on between lines 1-13
        {
            inputRow = localExcelReader.getRow(1+tracker,inputSheet);
            if(inputRow.get(0).equals("-"))
            {
                break;
            }
            output.add(new student(inputRow)); //TODO make sure arraylist input works properly for student class
            tracker++;
        }

        /*
        //TODO check then delete code
        ArrayList<String> widget = excelReaderTest.getRow(12,inputSheet);
        ArrayList<String> inputLevelList = new ArrayList<String>();
        student testStudent = new student();
        testStudent.convertToHeader(headerHolder);
        System.out.println(testStudent);

        ArrayList<String> scholarTest = excelReaderTest.getRow(14,"C:/Users/jpark/IdeaProjects/Athletics Awards Program/Athletic Awards File Examples/Scholar Athlete Awards 2015-2016.xlsx");

        int counter = 0;

        while(counter < scholarTest.size())
        {

            System.out.print(scholarTest.get(counter));
            System.out.println(" "+scholarTest.get(counter).length());
            counter++;
        }
        */

        return output;
    }

}
