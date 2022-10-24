package IES.Lab3_3.repository;


import IES.Lab3_3.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findByTitle(String title);
}
