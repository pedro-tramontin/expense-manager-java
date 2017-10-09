package br.com.pedront.expensemanager.core.repository;

import br.com.pedront.expensemanager.core.entity.CategoryEntity;
import br.com.pedront.expensemanager.core.entity.EarnEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<CategoryEntity, String> {

    public List<CategoryEntity> findByParentId(String parentId);

}
