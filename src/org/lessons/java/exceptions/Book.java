package org.lessons.java.exceptions;

public class Book {

	private String title;
	private int nPage;
	private String author;
	private String editor;
	
	public Book(String title, int nPage, String author, String editor ) throws Exception {
		
		setTitle(title);
		setnPage(nPage);
		setAuthor(author);
		setEditor(editor);
		
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws Exception {
		
		if(title == null || title.isEmpty() || title.length() <= 3 )
			throw new Exception("title must be longer then 3 characters");
		
		this.title = title;
	}
	
	
	public int getnPage() {
		return nPage;
	}
	public void setnPage(int nPage) {
		
		if(nPage <= 0)
		this.nPage = nPage;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception {
		
		if(author == null || author.isEmpty())
			throw new Exception("author must be longer then 3 characters");
			
		this.author = author;
	}
	
	
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) throws Exception {
		
		if(editor == null || editor.isEmpty() || editor.length() <= 3)
			throw new Exception("editor must be longer then 3 characters");
		
		this.editor = editor;
	}
	
	@Override
	public String toString() {
		
		return "Titolo: " + getTitle() + "\n"
				+ "Autore: " + getAuthor() + "\n"
				+ "Editore: " + getEditor() + "\n"
				+ "Numero di pagine: " + getnPage() + "\n";
	}
	
	
}
