package database;

import entity.Coders;

import java.util.Date;
import java.util.List;

public class CRUDExample {
    public static void main(String[] args){
        System.out.println("Reading rows at"+new Date().toString());
      // Coders coders= new GenericDB<Coders>().getRow(database.tables.Coders.CODERS,null);
        //List<Coders> rows = (List<Coders>) GenericDB.getRows(database.tables.Coders, null, null);
       //List<Coders>rows =(List<Coders>) GenericDB.getRows(Coders.class,null,null);
        List<Coders> rows =
                (List<Coders>) GenericDB.getRows(
                        database.tables.Coders.CODERS,
                        Coders.class,
                        null,
                        null
                );
       for (Coders row:rows){
           System.out.println("Row"+row.getName()+" "+row.getAge());
       }
    }
  //  private static CRUDExample ourInstance=new CRUDExample();
    //public static CRUDExample getInstance(){return ourInstance;}
   // private CRUDExample(){


}
