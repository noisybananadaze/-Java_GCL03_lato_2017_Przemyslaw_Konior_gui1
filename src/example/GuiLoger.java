package example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GuiLoger implements Logger
{
    public void log(String status,Student student){
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss:ms");
        Date date=new Date();
        date.getTime();
        String formatData=dateFormat.format(date);

        if(status.equals("ADDED")){
            CustomTabPane.getStudentList().add(student);
            CustomBarChart.increment(student);
            CustomLogView.getTextArea().appendText(formatData + "\t" + "[ "+status+" ]\t" + student.toString() + "\n");
        }

        if(status.equals("REMOVED")){
            CustomTabPane.getStudentList().remove(student);
            CustomBarChart.decrement(student);
            CustomLogView.getTextArea().appendText(formatData + "\t" + "[ "+status+" ]\t" + student.toString() + "\n");
        }


    }
}
