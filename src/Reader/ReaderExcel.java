package Reader;//21,30,

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

public class ReaderExcel {
	private String inputFile;
	private int numRows;
	private int currentRow;
	private int currentColumn;
	
	public ReaderExcel()
	{
		this.inputFile = "";
		currentRow = 1;
		currentColumn = 0;
	}
	
	public ReaderExcel(String inputFile)
	{
		this.setInputFile(inputFile);
	}
	
	public void setInputFile(String inputFile) 
	{
		this.inputFile = inputFile;
		currentRow = 1;
		currentColumn = 0;
	}
	
	public void read() throws IOException 
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try
		{
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet =  w.getSheet(0);
			numRows = sheet.getRows();
		}
		catch (BiffException e)
		{
		 	e.printStackTrace();
		}
	}
	
	public String getLabel(int x, int y)
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String returner;
		try 
		{
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet =  w.getSheet(0);
			
			Cell cell = sheet.getCell(x,y);
			returner = cell.getContents();
			return returner;
		} 
		catch (BiffException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error";
		
	}
	
	public int getNumber(int x, int y)
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		int returner;
		String tempReturner;
		try 
		{
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet =  w.getSheet(0);
			
			Cell cell = sheet.getCell(x,y);
			tempReturner = cell.getContents();
			returner = Integer.parseInt(tempReturner);
			return returner;
		} 
		catch (BiffException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 589;
		
	}
	
	public int getNumRows() throws IOException
	{
		return numRows;
	}
	
	public void makeNewSheet(ArrayList<student> studentList) throws IOException //make 3 versions
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try
		{
			WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
			w = Workbook.getWorkbook(inputWorkbook);
			WritableSheet output = workbook.createSheet("Reorganized Sheet", 0);
			Number number;
			Label label;
			
			for (int counter = 0; counter < studentList.size(); counter++)
			{
				number = new Number (0, counter, studentList.get(counter).getId()); 
				output.addCell(number);
				
				label = new Label (1,counter,studentList.get(counter).getLastName());
				output.addCell(label);
				
				label = new Label (2,counter,studentList.get(counter).getFirstName());
				output.addCell(label);
				
				number = new Number (4, counter, studentList.get(counter).getGrade()); 
				output.addCell(number);
			}
			
			workbook.write(); 
			workbook.close();
		}
		
		catch (BiffException e)
		{
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	public void makeNewSheetWithName(ArrayList<student> studentList, String fileName, ArrayList<level> levels) throws IOException //make 3 versions
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String newFileName = fileName + ".xls";
		header top = new header(levels);
		try
		{
			WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName+".xls"));
			w = Workbook.getWorkbook(inputWorkbook);
			WritableSheet output = workbook.createSheet("Reorganized Sheet", 0);
			Number number;
			Label label;
			int wasThereTemp;
			
			
			label = new Label(0,0,top.getId());
			output.addCell(label);
			label = new Label(1,0,top.getLastName());
			output.addCell(label);
			label = new Label(2,0,top.getFirstName());
			output.addCell(label);
			label = new Label(3,0,"Grade Level");
			output.addCell(label);
	
			for (int counter = 0; counter < top.getDateList().size(); counter++)
			{
				number = new Number (0,counter+4,top.getDateList().get(counter).getWasPresent());
				output.addCell(number);
			}
			
			
			for (int counter = 0; counter < studentList.size(); counter++)
			{
				student tempHolder = studentList.get(counter);
				number = new Number (0, counter+1, tempHolder.getId()); 
				output.addCell(number);
				
				label = new Label (1,counter+1,tempHolder.getLastName());
				output.addCell(label);
				
				label = new Label (2,counter+1,tempHolder.getFirstName());
				output.addCell(label);
				
				number = new Number (3, counter+1, tempHolder.getGrade()); 
				output.addCell(number);
				
				for (int dateCounter = 0; counter < dateList.size(); counter++)
				{
					wasThereTemp = dateList.get(dateCounter).getWasPresent();
					number = new Number (dateCounter+5,counter+1,wasThereTemp);
					output.addCell(number);
				}
			}
			
			workbook.write(); 
			workbook.close();
		}
		
		catch (BiffException e)
		{
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
*/
/*
	public void editMasterList(ArrayList<student> studentList, header Header) throws IOException //make 3 versions
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try
		{
			WritableWorkbook workbook = Workbook.createWorkbook(new File("masterList2.xls"));
			System.out.println(workbook);
			System.out.println(inputWorkbook);
			System.out.println(inputFile);
			System.out.println(Workbook.getWorkbook(inputWorkbook));
			w = Workbook.getWorkbook(inputWorkbook);
			WritableSheet output = workbook.createSheet("Reorganized Sheet", 0);
			
			
			
			Number number;
			Label label;
			int wasThereTemp;
			String wasThereDateTemp;
			boolean dateResortNeeded = false;
			
			label = new Label(0,0,Header.getId());
			output.addCell(label);
			label = new Label(1,0,Header.getLastName());
			output.addCell(label);
			label = new Label(2,0,Header.getFirstName());
			output.addCell(label);
	
			for (int counter = 0; counter < Header.getLevelList().size(); counter++)
			{
				number = new Number (counter+3,0,Header.getLevelList().get(counter).getYear());
				output.addCell(number);
			}
			
			
			for (int counter = 0; counter < studentList.size(); counter++)
			{
				
				student tempHolder = studentList.get(counter);
				number = new Number (0, counter+1, tempHolder.getId()); 
				output.addCell(number); 
				
				label = new Label (1,counter+1,tempHolder.getLastName());
				output.addCell(label);
				
				label = new Label (2,counter+1,tempHolder.getFirstName());
				output.addCell(label);

				
				
				
				
				for (int dateCounter = 0; dateCounter < studentList.get(counter).getLevels().size(); dateCounter++)
				{
					wasThereTemp = studentList.get(counter).getLevels().get(dateCounter).getYear();
					
					number = new Number (dateCounter+3,counter+1,wasThereTemp);
					output.addCell(number);
				}			
			}
			
			workbook.write(); 
			workbook.close();
		}
		
		catch (BiffException e)
		{
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

	public String getRow (int row)  throws IOException //convert into more applicable/specific output form
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String returner = "";
		boolean isZero=false;
		if(row==0)
		{
			isZero = true;
		}
		try
		{
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet =  w.getSheet(0);
			
			for (int i = 0; i < sheet.getColumns(); i++)
			{
				Cell cell = sheet.getCell(i,row);
				CellType type = cell.getType();
				returner = returner + " " + cell.getContents();
			}
			
			
		}
		catch (BiffException e)
		{
			e.printStackTrace();
		}
		return returner;
	}

	public student getStudentRow (int row)  throws IOException //convert into more applicable/specific output form
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		
		alphabetizer al = new alphabetizer();
		
		int Iid;//
		int Igrade; //
		String IfirstName; //
		String IlastName; //
		ArrayList<level> Ilevels = new ArrayList<level>();//
		boolean IASB; //
		level tempLevel;
		int tempYear;
		double firstVal;
		double lastVal;
		String tempTeam;
		
		student returner;
		returner = null;
		boolean isZero=false;
		if(row==0)
		{
			isZero = true;
		}
		try
		{
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet =  w.getSheet(0);
			/*
			for (int i = 0; i < sheet.getColumns(); i++)
			{
				Cell cell = sheet.getCell(i,row);
				CellType type = cell.getType();
				returner = returner + " " + cell.getContents();
			}
			*/
			
			Cell cell = sheet.getCell(5,row);
			String temp = cell.getContents();
			IfirstName = temp.substring(0, temp.indexOf(",")); //maybe recheck
			IlastName = temp.substring(temp.indexOf(","), temp.length());
			
			cell = sheet.getCell(6,row);
			Igrade = Integer.parseInt(cell.getContents());
			
			cell = sheet.getCell(7,row);
			Iid = Integer.parseInt(cell.getContents());
			
			cell = sheet.getCell(4, row);
			temp = cell.getContents();
			if(temp == "Yes")
			{
				IASB = true;
			}
			else if(temp == "No")
			{
				IASB = false;
			}
			else 
			{
				System.out.println("Please make sure that there is either a 'Yes' or a 'No' in the ASB column for " + 
				IlastName + ", " + IfirstName);
				IASB = false;
			}
			
			cell = sheet.getCell(9,row);
			temp = cell.getContents();
			if (temp.length()>=1)
			{
				cell = sheet.getCell(9,0);
				tempYear = Integer.parseInt(cell.getContents());
				cell = sheet.getCell(2,row);
				tempTeam = cell.getContents();
				
				tempLevel = new level(tempYear,temp,tempTeam);
				Ilevels.add(tempLevel);
			}
			
			cell = sheet.getCell(8,row);
			temp = cell.getContents();
			if (temp.length()>=1)
			{
				cell = sheet.getCell(8,0);
				tempYear = Integer.parseInt(cell.getContents());
				cell = sheet.getCell(2,row);
				tempTeam = cell.getContents();
				
				tempLevel = new level(tempYear,temp,tempTeam);
				Ilevels.add(tempLevel);
			}
			
			cell = sheet.getCell(1,row);
			temp = cell.getContents();
			if (temp.length()>=1)
			{
				cell = sheet.getCell(1,0);
				tempYear = Integer.parseInt(cell.getContents());
				cell = sheet.getCell(2,row);
				tempTeam = cell.getContents();
				
				tempLevel = new level(tempYear,temp,tempTeam);
				Ilevels.add(tempLevel);
			}
			
			firstVal = al.assignAlphVal(IfirstName);
			lastVal = al.assignAlphVal(IlastName);
			
			returner = new student(Iid, IfirstName, IlastName, Igrade, Ilevels, IASB,firstVal,lastVal);
			return returner;
		}
		catch (BiffException e)
		{
			e.printStackTrace();
		}
		return returner;
	}
	
	public String getNextString (int row)  throws IOException //not sure of purpose
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String returner = "";
		try
		{
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet =  w.getSheet(0);
			Cell cell = sheet.getCell(currentColumn,currentRow);
			returner = returner + " " + cell.getContents();
		}
		catch (BiffException e)
		{
			e.printStackTrace();
		}
		return returner;
	}
	
}


