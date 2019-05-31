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

public class genderReader {
	private String inputFile;
	private int numRows;
	private int currentRow;
	private int currentColumn;
	
	public genderReader()
	{
		this.inputFile = "";
		currentRow = 1;
		currentColumn = 0;
	}
	
	public genderReader(String inputFile)
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

	public simpleStudent getSimpleStudentRow (int row)  throws IOException //convert into more applicable/specific output form
	{
		File inputWorkbook = new File(inputFile);
		Workbook w;
		
		alphabetizer al = new alphabetizer();
		
		int Iid;//
		int Igrade; //
		String IfirstName; //
		String IlastName; //
		String Igender;
		
		simpleStudent returner;
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
			
			Cell cell = sheet.getCell(2,row);
			IfirstName = cell.getContents();
			
			cell = sheet.getCell(1,row);
			IlastName = cell.getContents();
			
			cell = sheet.getCell(3,row);
			Igender = cell.getContents();
			
			cell = sheet.getCell(4,row);
			Igrade = Integer.parseInt(cell.getContents());
			
			cell = sheet.getCell(0,row);
			Iid = Integer.parseInt(cell.getContents());
			
			returner = new simpleStudent(Iid,IlastName,IfirstName,Igender,Igrade);
			
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


