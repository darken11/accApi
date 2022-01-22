package org.cap.account.metier;



import org.cap.account.entities.Category;

import java.util.List;

public interface CategoryApiService {
    List<Category> findAll();

    public Category findOne(Long id);
    Category save(Category category);

    Category update(Category category);
    void delete(Category id);
}
