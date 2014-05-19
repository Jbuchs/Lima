/**
 * This class represent a book
 *
 * @package cpnv.jav1.lima
 * @author romain.lanz
 * @version 1.0, 19.05.14
 */

package cpnv.jav1.lima;

import java.util.ArrayList;
import java.util.Arrays;

import android.util.Log;

public class Book extends Article
{

/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
  /* Attributes */

    /**
     * SQL ID of the book
     */
    protected Integer _id;

    /**
     * ISBN of the book
     */
    protected String _isbn;

    /**
     * Author of the book
     */
    protected String _author;

    /**
     * Editor of the book
     */
    protected String _editor;

    /**
     * Date of the publication of the book
     */
    protected Integer _publicationYear;
    
    /**
     * ID of the article
     */
    private Integer _articleId;

/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
  /* SQL fields */

    /**
     * The name of the SQL table 
     */
    public static final String sqlTable = "bookdetail";
    
    /**
     * The name of the SQL field for the ID
     */
    public static final String sqlID = "idbookdetail";

    /**
     * The name of the SQL field for the ISBN
     */
    public static final String sqlIsbn = "ISBN";

    /**
     * The name of the SQL field for the author
     */
    public static final String sqlAuthor = "author";

    /**
     * The name of the SQL field for the editor
     */
    public static final String sqlEditor = "editor";

    /**
     * The name for the SQL field for the publication year
     */
    public static final String sqlPublicationYear = "publicationyear";
    
    /**
     * The name for the SQL field for the foreign key
     */
    public static final String sqlArticleId = "fk_article";

/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
  /* Constructor */

    /**
     * Class constructor
     */
    public Book() {}
    
    /**
     * Class constructor to instance a book with all attributes
     * 
     * @param id ID of the book
     * @param author Author of the book
     * @param editor Editor of the book
     * @param isbn ISBN of the book
     * @param publicationYear Year of the publication of the book
     * @param articleId ID of the article
     */
    public Book(Integer id, String author, String editor, String isbn, Integer publicationYear, Integer articleId, String name, String number, String supplier, Float price, Float TVA, Integer stock)
    {
    	setID(id);
    	setAuthor(author);
    	setEditor(editor);
    	setIsbn(isbn);
    	setPublicationYear(publicationYear);
    	setArticleId(articleId);
    	setName(name);
    	setNumber(number);
    	setSupplier(supplier);
    	setPrice(price);
    	setTVA(TVA);
    	setStock(stock);
    }

/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
  /* Methods */

    /**
     * Dump informations of this instance
     *
     * @return A dump of this instance
     */
    public String dump()
    {
    	String dump = "Object(Book)#" + hashCode() + " {";
    	dump += "\n\t ID = " + _id;
    	dump += "\n\t Name = " + super.getName();
    	dump += "\n\t Number = " + super.getNumber();
    	dump += "\n\t Supplier = " + super.getSupplier();
    	dump += "\n\t Price = " + super.getPrice();
    	dump += "\n\t TVA = " + super.getTVA();
    	dump += "\n\t Stock = " + super.getStock();
    	dump += "\n\t Author = " + _author;
    	dump += "\n\t Editor = " + _editor;
    	dump += "\n\t ISBN = " + _isbn;
    	dump += "\n\t PublicationYear = " + _publicationYear;
    	dump += "\n}";
    	
        return dump;
    }

/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
  /* Database methods */
    
    /**
     * Gets the database access object
     * 
     * @return The database access object
     */
    private static LimaDb getDao()
    {
    	return new LimaDb("http://192.168.0.4");
    }
    
    /**
     * Save the current object on the database
     */
    public void save()
    {
    	LimaDb dao = Book.getDao();
    	
    	if (null == _id) {
    		
    	} else {
    		
    	}
    }
    
    /**
     * Gets all book
     * 
     * @return ArrayList of book
     */
    public static ArrayList<Book> findAll()
    {
    	String query = "SELECT * FROM " + sqlTable + " b, " + Article.sqlTable + " a WHERE a." + Article.sqlId + " = b." + sqlArticleId;
    	Log.i("LIMA", "New query : " + query);
    	LimaDb dao = Book.getDao();
    	
    	dao.executeQuery(query);
    	
    	return Book.instanceWithDao(dao);
    }
    
    /**
     * Gets a book with an ID
     * 
     * @param id ID of the book
     * @return A book
     */
    public static Book findOneById(Integer id)
    {
    	String query = "SELECT * FROM " + sqlTable + " b, " + Article.sqlTable + " a WHERE b." + sqlID + " = " + id + " AND a." + Article.sqlId + " = b." + sqlArticleId;
    	Log.i("LIMA", "New query : " + query);
    	LimaDb dao = Book.getDao();
    	
    	dao.executeQuery(query);
    	
    	return Book.instanceOneWithDao(dao);
    }
    
    /**
     * Gets a book with an ISBN
     * 
     * @param isbn ISBN of the book
     * @return A book
     */
    public static Book findOneByIsbn(String isbn)
    {
    	String query = "SELECT * FROM " + sqlTable + " b, " + Article.sqlTable + " a WHERE b." + sqlIsbn + " = " + isbn + " AND a." + Article.sqlId + " = b." + sqlArticleId;
    	Log.i("LIMA", "New query : " + query);
    	LimaDb dao = Book.getDao();
    	
    	dao.executeQuery(query);
    	
    	return Book.instanceOneWithDao(dao);
    }
    
    /**
     * Instance a book with a database access object
     * 
     * @param dao Database access object
     * @return A Book
     */
    private static Book instanceOneWithDao(LimaDb dao)
    {
    	try {
    		while(dao.moveNext()) {
        		return new Book(
        				(null == dao.getField(dao.getField(sqlID)) ? null : Integer.parseInt(dao.getField(sqlID))),
        				dao.getField(sqlAuthor),
        				dao.getField(sqlEditor),
        				dao.getField(sqlIsbn),
        				(null == dao.getField(sqlPublicationYear) ? null : Integer.parseInt(dao.getField(sqlPublicationYear))),
        				(null == dao.getField(sqlArticleId) ? null : Integer.parseInt(dao.getField(sqlArticleId))),
        				dao.getField(Article.sqlName),
        				dao.getField(Article.sqlNumber),
        				dao.getField(Article.sqlSupplier),
        				(null == dao.getField(sqlPrice) ? null : Float.parseFloat(dao.getField(sqlPrice))),
        				(null == dao.getField(sqlTVA) ? null : Float.parseFloat(dao.getField(sqlTVA))),
        				(null == dao.getField(sqlStock) ? null : Integer.parseInt(dao.getField(sqlStock)))
        		);
        	}
    	} catch (Exception e) {
    		Log.i("LIMA", "Can't instance Book object. Error is \"" + e.getMessage() + "\"");
    	}
    	
    	return new Book();
    }
    
    /**
     * Instance books with a database access object
     * 
     * @param dao Database access object
     * @return Books
     */
    private static ArrayList<Book> instanceWithDao(LimaDb dao)
    {
    	ArrayList<Book> books = new ArrayList<Book>();
    	
    	try {
    		while(dao.moveNext()) {
        		 books.add(new Book(
        				(null == dao.getField(dao.getField(sqlID)) ? null : Integer.parseInt(dao.getField(sqlID))),
        				dao.getField(sqlAuthor),
        				dao.getField(sqlEditor),
        				dao.getField(sqlIsbn),
        				(null == dao.getField(sqlPublicationYear) ? null : Integer.parseInt(dao.getField(sqlPublicationYear))),
        				(null == dao.getField(sqlArticleId) ? null : Integer.parseInt(dao.getField(sqlArticleId))),
        				dao.getField(Article.sqlName),
        				dao.getField(Article.sqlNumber),
        				dao.getField(Article.sqlSupplier),
        				(null == dao.getField(sqlPrice) ? null : Float.parseFloat(dao.getField(sqlPrice))),
        				(null == dao.getField(sqlTVA) ? null : Float.parseFloat(dao.getField(sqlTVA))),
        				(null == dao.getField(sqlStock) ? null : Integer.parseInt(dao.getField(sqlStock)))
        		));
        	}
    	} catch (Exception e) {
    		Log.i("LIMA", "Can't instance Book object. Error is \"" + e.getMessage() + "\"");
    	}
    	
    	return books;
    }
    
/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
  /* Getters & Setters */

    /**
     * Sets the SQL ID of the book
     *
     * @param id The SQL ID of the book
     */
    public void setID(Integer id) { _id = id; }

    /**
     * Gets the SQL ID of the book
     *
     * @return The SQL ID of the book
     */
    public Integer getID() { return _id; }

    /**
     * Sets the ISBN of the book
     *
     * @param isbn ISBN of the book
     */
    public void setIsbn(String isbn) { _isbn = isbn; }

    /**
     * Gets the ISBN of the book
     *
     * @return The ISBN of the book
     */
    public String getIsbn() { return _isbn; }

    /**
     * Sets the author of the book
     *
     * @param author Author of the book
     */
    public void setAuthor(String author) { _author = author; }

    /**
     * Gets the author of the book
     *
     * @return The author of the book
     */
    public String getAuthor() { return _author; }

    /**
     * Sets the editor of the book
     *
     * @param editor Editor of the book
     */
    public void setEditor(String editor) { _editor = editor; }

    /**
     * Gets the editor of the book
     *
     * @return The editor of the book
     */
    public String getEditor() { return _editor; }

    /**
     * Sets the publication year of the book
     *
     * @param publicationYear Publication year of the book
     */
    public void setPublicationYear(Integer publicationYear) { _publicationYear = publicationYear; }

    /**
     * Gets the publication year of the book
     *
     * @return The publication year of the book
     */
    public Integer getPublicationYear() { return _publicationYear; }
    
    /**
     * Sets the article ID of the book
     * 
     * @param id Article ID of the book
     */
    private void setArticleId(Integer id) { _articleId = id; }
    
    /**
     * Gets the article ID of the book
     * 
     * @return The article ID of the book
     */
    private Integer getArticleId() { return _articleId; }

}
