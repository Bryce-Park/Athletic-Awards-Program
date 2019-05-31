package Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


public class Start {

	public static void main(String[] args) throws Throwable
	{
		int seasonTest = 1;
		int seasonTestNumber = ((4 - (19 - 17)) * 2) - seasonTest;
		System.out.println("season Number: "+seasonTestNumber);

		processor testProcessor = new processor();
		System.out.println("Ping 1");
		//ArrayList<student> testStudentList = testProcessor.generateStudentList("C:/Users/jpark/IdeaProjects/Athletics Awards Program/Athletic Awards File Examples/athletic awards for Spring 2016.xlsx");
		//ArrayList<student> testStudentList = testProcessor.generateStudentList("C:/Users/jpark/IdeaProjects/Athletics Awards Program/Athletic Awards File Examples/athletic awards for Spring 2016 (post-date change).xlsx");

		/*
		for(int counter=0;counter<testStudentList.size();counter++)
		{
			System.out.println(testStudentList.get(counter));
		}
*/

		int season = 0;
		int seasonNumber;
		int tempInt = 16;

		int currentYear = Calendar.getInstance().get(Calendar.YEAR) - season;
		int testingInt = 4-(20 - tempInt);
		//testingInt = 4 - testingInt;
		System.out.println("testing: "+testingInt);
		seasonNumber = ((4 - (20-tempInt)) * 2) + season; //TODO make sure to test code
		System.out.println("Season Nuumber: "+seasonNumber);

		ArrayList<awardForm> testAwardFormList = testProcessor.generateAwardForms("C:/Users/jpark/IdeaProjects/Athletics Awards Program/Athletic Awards File Examples/athletic awards for Spring 2016 (post-date change).xlsx",
				0,"SC");

		System.out.println("Begin Award Form List Test Main");
		//System.out.println(testAwardFormList.size());

		for(int counter=0;counter<testAwardFormList.size();counter++)
		{
			System.out.println(testAwardFormList.get(counter));
		}


		excelWriter testExcelWriter = new excelWriter();
		testExcelWriter.printAwardList(testAwardFormList);

		excelReader excelReaderTest = new excelReader();

		/*
		ArrayList<String> rowTest = excelReaderTest.getRow(321,"C:/Users/jpark/IdeaProjects/Athletics Awards Program/Athletic Awards File Examples/athletic awards for Spring 2016.xlsx"); //166
		if(rowTest.get(0).equals(" "))
		{
			System.out.println("Pinging");
			rowTest.remove(0);
		}
		*/
		/*
		ArrayList<String> inputLevelList = new ArrayList<String>();
		student testStudent = new student(rowTest);
		//testStudent.convertToHeader(headerHolder);
		//166,6
		//25,5
		System.out.println(testStudent);

		awardForm awardFormTest = new awardForm(testStudent,6); //TODO figure out which inputSeason number to use for (44, Artin)
		ArrayList<awardFormItem> awardFormItemList = awardFormTest.getContents();
		*/
		//for(int counter=0;counter<rowTest.size();counter++)
		//{
		//	System.out.println("Row Test: ["+rowTest.get(counter)+"]");
		//}

	}
}