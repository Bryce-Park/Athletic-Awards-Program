package Reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileSerialization 
{
	public FileSerialization ()
	{
		
	}
	
	public void saveList (ArrayList<student> providedList)
	{
		try {
			Object t2 = (Object) providedList;
			// write object to file
			FileOutputStream fos = new FileOutputStream("savedOrganizedList.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t2);
			oos.close();

				FileInputStream fis = new FileInputStream("savedOrganizedList.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object bob = ois.readObject();
			
				ArrayList<student> t3 = (ArrayList<student>) bob;
			
				ois.close();
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ea) 
		{
			ea.printStackTrace();
		} 
		catch (ClassNotFoundException eat) 
		{
			eat.printStackTrace();
		}
	}
	
	public void saveListWithName (ArrayList<student> providedList, String name)
	{
		try {
			Object t2 = (Object) providedList;
			// write object to file
			FileOutputStream fos = new FileOutputStream(name+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t2);
			oos.close();

				FileInputStream fis = new FileInputStream(name+".ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object bob = ois.readObject();
			
				ArrayList<student> t3 = (ArrayList<student>) bob;
			
				ois.close();
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ea) 
		{
			ea.printStackTrace();
		} 
		catch (ClassNotFoundException eat) 
		{
			eat.printStackTrace();
		}
	}
	
	public void saveHeaderWithName (header providedHeader, String name)
	{
		try {
			Object t2 = (Object) providedHeader;
			// write object to file
			FileOutputStream fos = new FileOutputStream(name+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t2);
			oos.close();

				FileInputStream fis = new FileInputStream(name+".ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object bob = ois.readObject();
			
				header t3 = (header) bob;
			
				ois.close();
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ea) 
		{
			ea.printStackTrace();
		} 
		catch (ClassNotFoundException eat) 
		{
			eat.printStackTrace();
		}
	}
	
	public ArrayList<student> getStudentList ()
	{
		ArrayList<student> studentList = new ArrayList<student>();
		try {
			
				FileInputStream fis = new FileInputStream("savedOrganizedList.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object holder = ois.readObject();
				ArrayList<student> t3 = (ArrayList<student>) holder;
			
				ois.close();
				studentList = t3;
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ea) 
		{
			ea.printStackTrace();
		} 
		catch (ClassNotFoundException eat) 
		{
			eat.printStackTrace();
		}
		
		return studentList;
	}
	
	public ArrayList<student> getStudentListWithName (String name)
	{
		ArrayList<student> studentList = new ArrayList<student>();
		try {
			
				FileInputStream fis = new FileInputStream(name+".ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object holder = ois.readObject();
				ArrayList<student> t3 = (ArrayList<student>) holder;
			
				ois.close();
				studentList = t3;
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ea) 
		{
			ea.printStackTrace();
		} 
		catch (ClassNotFoundException eat) 
		{
			eat.printStackTrace();
		}
		
		return studentList;
	}
	
	public header getHeaderWithName (String name)
	{
		header Header = new header();
		try {
			
				FileInputStream fis = new FileInputStream(name+".ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object holder = ois.readObject();
				header t3 = (header) holder;
			
				ois.close();
				Header = t3;
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException ea) 
		{
			ea.printStackTrace();
		} 
		catch (ClassNotFoundException eat) 
		{
			eat.printStackTrace();
		}
		
		return Header;
	}
		

}


