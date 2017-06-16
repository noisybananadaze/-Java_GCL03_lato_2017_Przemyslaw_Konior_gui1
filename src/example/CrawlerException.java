package example;


public class CrawlerException extends Exception{
    private String message;

    CrawlerException(String msg){this.message=message;}

    @Override
    public String toString() {
        return  message;
    }
}
