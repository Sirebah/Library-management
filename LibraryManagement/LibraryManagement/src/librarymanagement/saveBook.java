/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

import java.util.Date;

/**
 *
 * @author bahsi
 */
public class saveBook {
    
    private final String title;
    private final  String author;
    private final  String genre;
    private final Date date;
    private final String image;
    
    
    public saveBook(String title, String author, String genre, String image, Date date){
        
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.date = date;
        
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getGenre(){
        
        return genre;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getImage(){
        
        return image;
    }
    
    
    
}
