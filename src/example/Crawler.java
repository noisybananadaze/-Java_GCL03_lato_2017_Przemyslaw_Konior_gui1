package example;

import java.io.IOException;
import java.io.File;
import java.util.*;
import java.lang.InterruptedException;

import static example.Crawler.*;

public class Crawler {

    public String address=null;
    public static List<Student> studentsList=null;
    private List<Student> secondaryStuenttsList=null;
    private ConsoleLogger consolLoger= new ConsoleLogger();
    public static List<Student> getStudentsList(){
        return studentsList;
    }
    Crawler(String address)
    {
        this.address=address;
    }

    //////////////////////////////////////
    private List<IterationListener> iterationStartedListeners = new ArrayList<>();
    public void addIterationStartedListener(IterationListener listener){
        iterationStartedListeners.add(listener);
    }
    public void removeIterationStartedListener(IterationListener listener){iterationStartedListeners.remove(listener); }

    private List<IterationListener> iterationComplitedListeners = new ArrayList<>();
    public void addIterationComplitedListener(IterationListener listener){
        iterationComplitedListeners.add(listener);
    }
    public void removeIterationComplitedListener(IterationListener listener){ iterationComplitedListeners.remove(listener); }

    private List<StudentListener> studentaddedListeners = new ArrayList<>();
    public void addStudentaddedListener(StudentListener listener){
        studentaddedListeners.add(listener);
    }
    public void removeStudentaddedListeners(StudentListener listener){
        studentaddedListeners.remove(listener);
    }

    private List<StudentListener> studentRemovedListener = new ArrayList<>();
    public void addStudentremovedListener(StudentListener listener){
        studentRemovedListener.add(listener);
    }
    public void removeStudentremovedListeners(StudentListener listener){
        studentaddedListeners.remove(listener);
    }


    //////////////////////////////////////

    public List<Student> extractStudents(OrderMode mode,List<Student> students)
    {
        switch(mode) {
            case AGE:{Collections.sort(students,Student.Comparators.AGE);}break;
            //case FIRST_NAME:{Collections.sort(students,Student.Comparators.FIRST_NAME);}break;
            //case LAST_NAME:{Collections.sort(students,Student.Comparators.LAST_NAME);}break;
            case MARK:{Collections.sort(students,Student.Comparators.MARK);}break;
            default:{}break;

        }
        return students;
    }

    public double extractMark(ExtremumMode mode,List<Student> students)
    {
        Student result=new Student();
        switch(mode){
            case MAX:{result=Collections.max(students,Student.Comparators.MARK);}break;
            case MIN:{result=Collections.min(students,Student.Comparators.MARK);}break;
            default:{}break;
        }
        return result.getMark();
    }

    public int extractAge(ExtremumMode mode,List<Student> students)
    {
        Student result=new Student();
        switch(mode){
            case MAX:{result=Collections.max(students,Student.Comparators.AGE);}break;
            case MIN:{result=Collections.min(students,Student.Comparators.AGE);}break;
            default:{}break;
        }
        return result.getAge();
    }

    /////////////////////////////////////////////////////////////////////////////////
    public void run() throws Exception{
        GUIthread guIthread=new GUIthread();
        (new Thread(guIthread)).start();

        int iteration = 1;
        while(true){

            if(address == null) throw new CrawlerException("Wrong addres !!!");

            for(IterationListener el:iterationStartedListeners){
                el.handle(iteration);
            }
            secondaryStuenttsList=studentsList;
            studentsList= StudentsParser.parse(new File(address));

            // TODO: wykrywanie danych studentow
            if(secondaryStuenttsList==null)
            {
                for (Student el:studentsList) {
                    for (StudentListener e : studentaddedListeners)
                        e.handle(el);
                }
            }

            if(studentsList!=null && secondaryStuenttsList!=null) {

                boolean flag = false;
                for (Student el : studentsList) {
                    for (Student el2 : secondaryStuenttsList) {
                        if (el.equals(el2)) {
                            flag = false;
                            break;
                        } else {
                            flag = true;

                        }
                    }
                    if (flag) {
                        for (StudentListener e : studentaddedListeners) {
                            e.handle(el);
                        }
                    }
                }

                boolean flag2 = false;
                for (Student el : secondaryStuenttsList) {
                    for (Student el2 : studentsList) {
                        if (el.equals(el2)) {
                            flag2 = false;
                            break;
                        } else {
                            flag2 = true;
                        }
                    }
                    if (flag2) {
                        for (StudentListener e : studentRemovedListener) {
                            e.handle(el);
                        }
                    }
                }
            }




            System.out.println("Age: <"+ extractAge(ExtremumMode.MIN,studentsList)+","+extractAge(ExtremumMode.MAX,studentsList)+">");
            System.out.println("Mark: <"+ extractMark(ExtremumMode.MIN,studentsList)+","+extractMark(ExtremumMode.MAX,studentsList)+">");
            System.out.println("Ordered by MARK: ");
            studentsList = extractStudents(OrderMode.MARK,studentsList);
            for (Student el:studentsList )
            {
                System.out.println(el.toString());
            }

            Thread.sleep(10000);

            for(IterationListener el:iterationComplitedListeners){
                el.handle(iteration);
            }
            iteration++;

        }



    }

}

