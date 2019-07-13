import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Automation
{
   static void modifyFile(String filePath , String oldString, String newString)

   {
       File fileToBeModified = new File(filePath);
       //System.out.println(fileToBeModified.exists());
       //System.out.println();

       String oldContent = "";

       BufferedReader reader = null;

       FileWriter writer = null;

       try
       {
           reader = new BufferedReader(new FileReader(fileToBeModified));



           String line = reader.readLine();


           while (line != null)
           {
               //System.out.println("Line:--------------"+line);

               oldContent = oldContent + line + System.lineSeparator();
               //System.out.println("Line: "+oldContent.trim());


               line = reader.readLine();
           }

//System.out.println();
//System.out.println();

           //<cron-expression>0 0/5 * * * ?</cron-expression>
String newContent = oldContent.replaceAll(oldString, newString);
//System.out.println("Here the new One:++++++++++"+ newContent);


           writer = new FileWriter(fileToBeModified);

           //System.out.println("Write:=============="+ newContent);

           writer.write(newContent);
       }
       catch (IOException e)
       {
           e.printStackTrace();
            System.out.println(e);
       }
       finally
       {
           try
           {

                //POD Integration Job Deployment
//Maestro Pod Integration Quartz Server service
               reader.close();

               writer.close();
           }
           catch (IOException e)
           {
               e.printStackTrace();
               System.out.println(e);
           }
       }
   }

   public static void main(String abc[])
   {
       modifyFile("D:\\SpringPradyumna\\abc.txt", "\\<cron-expression\\>0 0\\/5 \\* \\* \\* \\?\\<\\/cron-expression\\>", "pradyumna");

       System.out.println("Successfully Done");
   }
}