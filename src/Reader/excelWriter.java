package Reader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class excelWriter
{
    public excelWriter() throws Throwable
    {

    }

    public static void printAwardList(ArrayList<awardForm> awardFormList) throws Throwable
    {
        ArrayList<awardForm> localList = awardFormList;

        for(int counter=0;counter<awardFormList.size();counter++)
        {
            System.out.println("award form list test: "+awardFormList.get(counter));
        }

        for(int counter=0;counter<localList.size();counter++)
        {
            System.out.println("award form list test: "+localList.get(counter));
        }

        ArrayList<ArrayList<awardForm>> packagedList = new ArrayList<>();

        int macroTracker = 0;
        int tracker;
        for(int c1=0;c1<localList.size();c1++)
        {
            tracker = 0;

            for(int c2=0;c2<packagedList.size();c2++)
            {
                System.out.println("c2 size: "+c2);
                System.out.println("tester: "+packagedList.get(c2));
                System.out.println("tester-1: "+packagedList
                        .get(c2)
                        .get(0));
                System.out.println("tester1.5: "+localList.get(c1));
                System.out.println("tester2: "+localList.get(c1).getLevel());
                if(localList.get(c1).getLevel().
                        equals(packagedList.get(c2).get(0)))
                { 
                    packagedList.get(c2).add(localList.get(c1));
                    tracker++;
                }
            }

            if(tracker==0)
            {
                packagedList.add(new ArrayList<awardForm>());
                packagedList.get(macroTracker).add(localList.get(c1));
            }

        }

        for(int counter=0;counter<packagedList.size();counter++)
        {
            printIndividualSheets(packagedList.get(counter));
        }


    }

    public static void printIndividualSheets (ArrayList<awardForm> awardFormList) throws Throwable
    {
        SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory
        Sheet sh = wb.createSheet();

        ArrayList<awardForm> localList = awardFormList;
        String sport = localList.get(0).getName();
        String level = localList.get(0).getLevel();
        int blockStartXCoord = 0;
        int blockStartYCoord = 0;

        int awardFormListTracker = 0;

        //assuming each block row has 3 awardForms
        Row nameRow = sh.createRow(blockStartYCoord);
        Row titleRow = sh.createRow((blockStartYCoord+1));
        Row contentRow0 = sh.createRow((blockStartYCoord+2));
        Row contentRow1 = sh.createRow((blockStartYCoord+3));

        for(int c1=0;c1<=localList.size();c1++)
        {
            int rowAwardForm = 0;

            if(rowAwardForm==2)
            {
                nameRow = sh.createRow(blockStartYCoord);
                titleRow = sh.createRow((blockStartYCoord+1));
                contentRow0 = sh.createRow((blockStartYCoord+3));
                contentRow1 = sh.createRow((blockStartYCoord+5));

                rowAwardForm = 0;
                if(blockStartYCoord!=0)
                {
                    blockStartYCoord+=8;
                }
            }

            Cell nameCell = nameRow.createCell(0+(rowAwardForm*4));
            Cell titleCell = titleRow.createCell(rowAwardForm*4);

            nameCell.setCellValue(localList.get(awardFormListTracker).getStudent().getLastName()+ " " + localList.get(awardFormListTracker).getStudent().getFirstName());
            titleCell.setCellValue(localList.get(awardFormListTracker).getStudent().getLevels().get(0).getOriginal());

            int contentTracker=0;
            Cell contentCell;
            for(int c2=0;c2<localList.get(c1).getContents().size();c2++)
            {
                if(c2<3)
                {
                    contentCell = contentRow0.createCell(contentTracker);
                    contentCell.setCellValue(localList.get(c2).getContents().get(contentTracker).getItem());
                    if(localList.get(c2).getContents().get(contentTracker).isItValid())
                    {
                        contentCell.setCellValue(localList.get(c2).getContents().get(contentTracker).getItem()+" X");
                    }
                }
                else
                {
                    contentCell = contentRow1.createCell(contentTracker-3);
                    contentCell.setCellValue(localList.get(c2).getContents().get(contentTracker).getItem());
                    if(localList.get(c2).getContents().get(contentTracker).isItValid())
                    {
                        contentCell.setCellValue(localList.get(c2).getContents().get(contentTracker).getItem()+" X");
                    }
                }
            }

            rowAwardForm++;
        }

        // manually control how rows are flushed to disk
        if(1 % 100 == 0)
        {
            ((SXSSFSheet)sh).flushRows(100); // retain 100 last rows and flush all others
        }

        FileOutputStream out = new FileOutputStream(localList.get(0).getContents().get(0).getItem());
        //FileOutputStream out = new FileOutputStream("C:/Users/jpark/IdeaProjects/roboticsAttendanceSoftware");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }


    public static void exampleSheet (ArrayList<awardForm> awardFormList) throws Throwable
    {
        SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory
        Sheet sh = wb.createSheet();

        System.out.println("GOT HERE");

        int dataStartRow = 3;
        int matchCommentStart = 2;

        Row teamNumberRow = sh.createRow(0);
        Cell cell = teamNumberRow.createCell(0);

        Row pitCommentsStartRow = sh.createRow(1);
        cell = pitCommentsStartRow.createCell(0);
        cell.setCellValue("Pit Comments");

        Row commentRows = sh.createRow(2);
        int commentRowNum = 0;


        dataStartRow += matchCommentStart;

        Row commentsStartRow = sh.createRow(1+matchCommentStart);
        cell = commentsStartRow.createCell(0);
        cell.setCellValue("Match Number");
        cell = commentsStartRow.createCell(1);
        cell.setCellValue("Comments");



        Row headerRow = sh.createRow(0+dataStartRow);
        cell = headerRow.createCell(0);
        cell.setCellValue("Match Number");
        cell = headerRow.createCell(1);
        cell.setCellValue("Sandstorm Exit");
        cell = headerRow.createCell(2);
        cell.setCellValue("TeleOp Enter");
        cell = headerRow.createCell(3);
        cell.setCellValue("Point Total");
        cell = headerRow.createCell(4);
        cell.setCellValue("Penalty Total");
        cell = headerRow.createCell(5);
        cell.setCellValue("Hatch Total");
        cell = headerRow.createCell(6);
        cell.setCellValue("Cargo Total");

        //header match totals
        int headerTracker = 0;
        String locationHolder;
        String pieceHolder;
        for(int cA=0;cA<4;cA++)
        {
            for(int cB=0;cB<2;cB++)
            {
                if(cB==0)
                {
                    pieceHolder = "H";
                }
                else
                {
                    pieceHolder = "C";
                }
                if(cA==0)
                {
                    locationHolder = "C.S. ";
                }
                else if(cA==1)
                {
                    locationHolder = "R.L. ";
                }
                else if(cA==2)
                {
                    locationHolder = "R.M. ";
                }
                else
                {
                    locationHolder = "R.H. ";
                }
                cell = headerRow.createCell(7+headerTracker);
                cell.setCellValue(locationHolder + pieceHolder + " Total");
                headerTracker++;
            }
        }
        //header sandstorm totals
        headerTracker = 0;
        for(int cA=0;cA<4;cA++)
        {
            for(int cB=0;cB<2;cB++)
            {
                if(cB==0)
                {
                    pieceHolder = "H";
                }
                else
                {
                    pieceHolder = "C";
                }
                if(cA==0)
                {
                    locationHolder = "C.S. ";
                }
                else if(cA==1)
                {
                    locationHolder = "R.L. ";
                }
                else if(cA==2)
                {
                    locationHolder = "R.M. ";
                }
                else
                {
                    locationHolder = "R.H. ";
                }
                cell = headerRow.createCell(15+headerTracker);
                cell.setCellValue("S " + locationHolder + pieceHolder + " Total");
                headerTracker++;
            }
        }

        //header teleOp totals
        headerTracker = 0;
        for(int cA=0;cA<4;cA++)
        {
            for(int cB=0;cB<2;cB++)
            {
                if(cB==0)
                {
                    pieceHolder = "H";
                }
                else
                {
                    pieceHolder = "C";
                }
                if(cA==0)
                {
                    locationHolder = "C.S. ";
                }
                else if(cA==1)
                {
                    locationHolder = "R.L. ";
                }
                else if(cA==2)
                {
                    locationHolder = "R.M. ";
                }
                else
                {
                    locationHolder = "R.H. ";
                }
                cell = headerRow.createCell(23+headerTracker);
                cell.setCellValue("T " + locationHolder + pieceHolder + " Total");
                headerTracker++;
            }
        }

        //match data
        int mDStart = 2;


        //team total averages

        int tracker;
        int totalTracker = 0;
        //28
        Row row = sh.createRow(1+dataStartRow);
        cell = row.createCell(0);
        cell.setCellValue("Average");
        cell = row.createCell(1);
        //cell.setCellValue(inputTeam.getMatches().get(rownum).getSandStorm().getExitValue());
        cell = row.createCell(2);
        //cell.setCellValue(inputTeam.getMatches().get(rownum).getTeleOp().getEnterValue());
        cell = row.createCell(3);

        cell.setCellValue(totalTracker);

        totalTracker=0;
        cell = row.createCell(6);

        tracker = 0;
        totalTracker = 0;

        tracker = 0;
        totalTracker = 0;


        tracker = 0;
        totalTracker = 0;


        // manually control how rows are flushed to disk
        if(1 % 100 == 0)
        {
            ((SXSSFSheet)sh).flushRows(100); // retain 100 last rows and flush all others
        }

        FileOutputStream out = new FileOutputStream("Filler");
        //FileOutputStream out = new FileOutputStream("C:/Users/jpark/IdeaProjects/roboticsAttendanceSoftware");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
    }

}
