package br.com.pedront.expensemanager.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.pedront.expensemanager.core.entity.IncomeEntity;

public interface IncomeRepository extends MongoRepository<IncomeEntity, String> {

    public List<IncomeEntity> findByUser(String user);

}
