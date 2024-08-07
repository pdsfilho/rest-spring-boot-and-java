package br.com.paulo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.paulo.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
