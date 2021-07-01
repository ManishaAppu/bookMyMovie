package com.assessment.Repository;

import com.assessment.Entity.BookTheMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTheMovieRepository extends JpaRepository<BookTheMovie, Integer> {
}
