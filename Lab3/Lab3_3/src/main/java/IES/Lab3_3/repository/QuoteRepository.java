package IES.Lab3_3.repository;

import IES.Lab3_3.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Integer> {
    Quote findByAvaliacao(String title);
}
