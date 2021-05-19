/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelolabuku.database;

import kelolabuku.models.Buku;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author User-1
 */
public class BukuDatasource {
    public void save(Buku buku) throws SQLException {
        String sql = "INSERT INTO buku(judul, pengarang, penerbit, tahun_terbit) VALUES(?,?,?,?)";
        Connection connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, buku.getJudulBuku());
        preparedStatement.setString(2, buku.getPengarang());
        preparedStatement.setString(3, buku.getPenerbit());
        preparedStatement.setInt(4, buku.getTahunTerbit());
        
        preparedStatement.executeUpdate();
    }
    public void update(Buku buku) throws SQLException {
        String sql = "UPDATE buku SET judul=?, pengarang=?, penerbit=?, tahun_terbit=? WHERE id=?";
        Connection connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, buku.getJudulBuku());
        preparedStatement.setString(2, buku.getPengarang());
        preparedStatement.setString(3, buku.getPenerbit());
        preparedStatement.setInt(4, buku.getTahunTerbit());
        preparedStatement.setLong(5, buku.getId());
        
        preparedStatement.executeUpdate();
    }
    public void delete(Buku buku) throws SQLException {
        String sql = "DELETE FROM buku WHERE id=?";
        Connection connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setLong(1, buku.getId());
        
        preparedStatement.executeUpdate();
    }
    // java.util.List explanation: https://www.javatpoint.com/java-list
    public List<Buku> findAll() throws SQLException {
        String sql = "SELECT * FROM buku";
        Connection connection = ConnectionHelper.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        // creating a List
        List<Buku> bukuList = new ArrayList<>();
        // while resultSet when resultSet.next() is returning true value(means the data still exits in the next row)
        while (resultSet.next()){
            // create buku object
            Buku buku = new Buku();
            // use setter in buku object and fill parameter with result from resultSet operaion
            buku.setId(resultSet.getLong("id"));
            buku.setJudulBuku(resultSet.getString("judul"));
            buku.setPengarang(resultSet.getString("pengarang"));
            buku.setPenerbit(resultSet.getString("penerbit"));
            buku.setTahunTerbit(resultSet.getInt("tahun_terbit"));
            // add each buku object into bukuList
            bukuList.add(buku);
        }
        return bukuList;
    }
}
