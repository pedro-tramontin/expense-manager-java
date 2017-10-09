package br.com.pedront.expensemanager.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedront.expensemanager.core.entity.ExpenseEntity;
import br.com.pedront.expensemanager.core.repository.ExpenseRepository;

@Service
public class ExpenseService {

    public static final ExpenseEntity EXPENSE_NULL = new ExpenseEntity();

    private static final Logger LOGGER = LoggerFactory.getLogger(ExpenseService.class);

    @Autowired
    private ExpenseRepository repository;

    public ExpenseEntity create(final ExpenseEntity expense) {
        return repository.save(expense);
    }

    public ExpenseEntity get(final String id) {
        final ExpenseEntity foundExpense = repository.findOne(id);

        if (foundExpense == null) {
            return EXPENSE_NULL;
        }

        return foundExpense;
    }

    public ExpenseEntity update(final ExpenseEntity expense) {
        ExpenseEntity updatedEntity = expense;

        if (repository.exists(expense.getId())) {
            ExpenseEntity expenseEntity = get(expense.getId());
            if ((expenseEntity != EXPENSE_NULL) &&
                    updateIfOtherDifferentFrom(expenseEntity, expense)) {
                updatedEntity = repository.save(expenseEntity);
            }
        } else {
            // TODO Should throw some exception here indicating the updating didn't occur because of not founding by the
            // id provided

            LOGGER.error("C=ExpenseService M=update step=test-exists-fail id=%s", expense.getId());
        }

        return updatedEntity;
    }

    public void delete(final String id) {
        if (repository.exists(id)) {
            repository.delete(id);
        }
    }

    private int hashCoreExpenseFields(ExpenseEntity expense) {
        int result = expense.getUser().hashCode();
        result = 31 * result + expense.getCategory().hashCode();
        result = 31 * result + expense.getPeriod().hashCode();
        result = 31 * result + expense.getDatetime().hashCode();
        result = 31 * result + expense.getOriginalDescription().hashCode();
        result = 31 * result + (expense.getUserDescription() != null ? expense.getUserDescription()
                .hashCode() : 0);
        result = 31 * result + expense.getValue().hashCode();
        return result;
    }

    public boolean areDifferent(String value1, String value2) {
        if ((value1 == null) && (value2 != null)) {
            return true;
        }

        if ((value1 != null) && !value1.equals(value2)) {
            return true;
        }

        return false;
    }

    public boolean updateIfOtherDifferentFrom(ExpenseEntity expense, ExpenseEntity other) {
        if (other == null) {
            return false;
        }

        if (hashCoreExpenseFields(expense) != hashCoreExpenseFields(other)) {
            if (areDifferent(expense.getUser(), other.getUser())) {
                expense.setUser(other.getUser());
            }

            if (areDifferent(expense.getCategory(), other.getCategory())) {
                expense.setCategory(other.getCategory());
            }

            if (areDifferent(expense.getPeriod(), other.getPeriod())) {
                expense.setPeriod(other.getPeriod());
            }

            if (areDifferent(expense.getDatetime(), other.getDatetime())) {
                expense.setDatetime(other.getDatetime());
            }

            if (areDifferent(expense.getOriginalDescription(), other.getOriginalDescription())) {
                expense.setOriginalDescription(other.getOriginalDescription());
            }

            if (areDifferent(expense.getUserDescription(), other.getUserDescription())) {
                expense.setUserDescription(other.getUserDescription());
            }

            if (areDifferent(expense.getValue(), other.getValue())) {
                expense.setValue(other.getValue());
            }

            return true;
        }

        return false;
    }
}
