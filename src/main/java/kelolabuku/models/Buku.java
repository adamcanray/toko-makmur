/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelolabuku.models;

/**
 *
 * @author User-1
 */
public class Buku {
    /**
     * POJO technique
     */
    
    // properties
    private long id;
    private String judulBuku;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
    
    // setter and getter
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getJudulBuku(){
        return judulBuku;
    }
    public void setJudulBuku(String judulBuku){
        this.judulBuku = judulBuku;
    }
    public String getPengarang(){
        return pengarang;
    }
    public void setPengarang(String pengarang){
        this.pengarang = pengarang;
    }
    public String getPenerbit(){
        return penerbit;
    }
    public void setPenerbit(String penerbit){
        this.penerbit = penerbit;
    }
    public int getTahunTerbit(){
        return tahunTerbit;
    }
    public void setTahunTerbit(int tahunTerbit){
        this.tahunTerbit = tahunTerbit;
    }
    
}
