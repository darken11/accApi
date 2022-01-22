package org.cap.account.metier;

import org.cap.account.constants.ApiConstants;
import org.cap.account.custumException.ProductException;
import org.cap.account.entities.Category;
import org.cap.account.repository.CategoryRestApiRepository;
import org.cap.account.repository.ProductRestApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryApiServiceImpl  implements CategoryApiService{
    @Autowired
    private CategoryRestApiRepository categoryRestApiRepository;
    @Autowired
    private ProductRestApiRepository productRestApi;
    @Override
    public List<Category> findAll() {
        return categoryRestApiRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        Category category = categoryRestApiRepository.findById(id).orElse(null);

        if (category == null) throw new ProductException(ApiConstants.productNotFound);
        return category;
    }

    @Override
    public Category save(Category category) {
        List<Category> categoryFind=categoryRestApiRepository.findCategory(category.getName());
        if(!categoryFind.isEmpty()){
            throw new ClassCastException(ApiConstants.categoryAlreadyExist);
        }
        else {
            return categoryRestApiRepository.save(category);
        }
    }

    @Override
    public Category update(Category category) {
        Category categoryToUpdate=categoryRestApiRepository.findById(category.getId()).orElse(null);

        return categoryRestApiRepository.save(categoryToUpdate);
    }

    @Override
    public void delete(Category category) {
        this.categoryRestApiRepository.delete(category);

    }
}
