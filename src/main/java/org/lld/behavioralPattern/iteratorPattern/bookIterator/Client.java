package org.lld.behavioralPattern.iteratorPattern.bookIterator;
import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
class Book {
    private String bookName;
    private String bookType;
    private String bookId;
}

interface Iterator{
    boolean hasNext();
    Object next();
}
class BookIterator implements Iterator{
 private final List<Book> bookList;
 int position;

 public BookIterator(List<Book> bookList){
     this.bookList = bookList;
     this.position = 0;
 }
 @Override
 public boolean hasNext(){
     return position < bookList.size();
 }

 @Override
 public Book next(){
     Book book =  bookList.get(position);
     position++;
     return book;
 }
}

interface Aggregator{
    Iterator getIterator();
}
class ConcreteAggregator implements Aggregator{
    public List<Book> bookList;
    public ConcreteAggregator(List<Book> bookList){
        this.bookList = bookList;
    }

    @Override
    public Iterator getIterator(){
        return new BookIterator(bookList);
    }
}

public class Client {
    public static void main(String[] args) {
        Book book1 = Book.builder()
                .bookName("Book1")
                .bookType("SCIFI")
                .bookId("1")
                .build();
        Book book2 = Book.builder().bookName("Book2").bookType("HORROR").bookId("2").build();
        Book book3 = Book.builder().bookName("Book3").bookType("FICTION").bookId("3").build();
        Book book4 = Book.builder().bookName("Book4").bookType("PSYCHOLOGY").bookId("4").build();

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        Aggregator aggregator = new ConcreteAggregator(bookList);
        Iterator iterator = aggregator.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
