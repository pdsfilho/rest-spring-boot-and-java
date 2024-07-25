package br.com.paulo.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.paulo.data.vo.v1.BookVO;
import br.com.paulo.models.Book;

public class MockBook {
	
	public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookVO mockVO() {
        return mockVO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> persons = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<BookVO> mockVOList() {
        List<BookVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public Book mockEntity(Integer number) {
        Book Book = new Book();
        Book.setId(number.longValue());
        Book.setAuthor("Author Test" + number);
        Book.setLaunchDate(new Date());
        Book.setPrice(25D);
        Book.setTitle("Title Test" + number);
        return Book;
    }

    public BookVO mockVO(Integer number) {
        BookVO Book = new BookVO();
        Book.setKey(number.longValue());
        Book.setAuthor("Author Test" + number);
        Book.setLaunchDate(new Date());
        Book.setPrice(25D);
        Book.setTitle("Title Test" + number);
        return Book;
    }


}
