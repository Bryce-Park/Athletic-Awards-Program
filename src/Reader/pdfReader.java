package Reader;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

public class pdfReader 
{
	PDFTextStripper textReader;
	File inputFile;
	
	public pdfReader()
	{
		try 
		{
			textReader = new PDFTextStripper();
		} 
		catch (IOException e) 
		{
			// TO DO Auto-generated catch block -your code is fixed now! youre welcome-claire g.
			e.printStackTrace();
		}
	}
	
	public void testReader()
	{
		try {
			PDFTextStripper textTestReader = new PDFTextStripper();
			
			PDDocument document = new PDDocument();
			
			PDPage my_page = new PDPage();
			document.addPage(my_page);
			
			File file = new File("C:/Users/jpark/Desktop/PDF Spreadsheet Test.pdf");
			PDDocument readTest = PDDocument.load(file);
			
			
			String text = textTestReader.getText(readTest);
			
			System.out.println(text);

			
			readTest.save("C:/Users/jpark/Desktop/"+"Tester");
			document.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertFile(String path)
	{
		inputFile = new File(path);
	}
	

}

