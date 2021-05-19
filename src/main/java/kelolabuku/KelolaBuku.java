/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelolabuku;

import kelolabuku.database.ConnectionHelper;
import java.sql.SQLException;
import kelolabuku.ui.DataManagerBuku;

/**
 *
 * @author User-1
 */
public class KelolaBuku {
    public static void main(String[] args) {
        testConnection();
    }
    private static void startDataManagerBuku(){
        DataManagerBuku dataManagerBuku = new DataManagerBuku();
        dataManagerBuku.setVisible(true);
    }
    private static void testConnection(){
        try{
            ConnectionHelper.getConnection();
            System.out.println("Database connected");
            startDataManagerBuku();
        }catch (SQLException ex){
            System.out.println(ex);
            System.out.println("Failed to connect database");
        }
    }
}
