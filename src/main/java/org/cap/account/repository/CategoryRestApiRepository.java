package org.cap.account.repository;

import org.cap.account.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRestApiRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where  c.name like :cat")
    public List<Category> findCategory(@Param("cat") String category);
}
