import java.util.Scanner;

public class ExcaptionExample {
    public static void main(String[] args){
        int x=100;
        Scanner scanner=new Scanner(System.in);
        int y=scanner.nextInt();
        try{
            System.out.println(x/y);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("hello world");
        }finally {
            System.out.println("inside finally");
        }


    }
}
