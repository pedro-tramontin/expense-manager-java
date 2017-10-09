package br.com.pedront.expensemanager.core.repository;

import br.com.pedront.expensemanager.core.entity.ExpenseEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<ExpenseEntity, String> {

    public List<ExpenseEntity> findByUser(String user);

}
