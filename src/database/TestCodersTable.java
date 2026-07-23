//package tech.codingclub.database;
package database;
//import database.tables.Users;
import entity.Coders;
//import tech.codingclub.entity.Coders;

public class TestCodersTable {

    public static void main(String[] args) {

        Coders coders = new Coders("Akshat", 28L );

        //Insert this object into DB !

//           < ENTITY CLASS>
      new GenericDB<Coders>().addRow(database.tables.Coders.CODERS, coders);

    }
}
