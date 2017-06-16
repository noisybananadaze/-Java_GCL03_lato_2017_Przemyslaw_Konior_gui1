package example;


public class ConsoleLogger implements Logger {
    @Override
    public void log(String status, Student student) {
        if(student!=null) System.out.println(status + ": " + student.toString());
    }
}
