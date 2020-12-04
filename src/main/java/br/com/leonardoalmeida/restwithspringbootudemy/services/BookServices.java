package br.com.leonardoalmeida.restwithspringbootudemy.services;

import br.com.leonardoalmeida.restwithspringbootudemy.converter.DozerConverter;
import br.com.leonardoalmeida.restwithspringbootudemy.data.model.Book;
import br.com.leonardoalmeida.restwithspringbootudemy.data.vo.BookVO;
import br.com.leonardoalmeida.restwithspringbootudemy.exception.ResourceNotFoundException;
import br.com.leonardoalmeida.restwithspringbootudemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    private BookRepository repository;

    public BookVO create(BookVO book) {
        var entity = DozerConverter.parseObject(book, Book.class);
        return DozerConverter.parseObject(repository.save(entity), BookVO.class);
    }

    public List<BookVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
    }

    public BookVO findById(Long id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public BookVO update(BookVO book) {

        Book entity = repository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());
        repository.save(entity);

        return DozerConverter.parseObject(entity, BookVO.class);
    }

    public void delete(Long id) {
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }


}
