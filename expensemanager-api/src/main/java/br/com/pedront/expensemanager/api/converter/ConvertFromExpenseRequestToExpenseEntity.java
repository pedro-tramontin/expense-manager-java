package br.com.pedront.expensemanager.api.converter;

import br.com.pedront.expensemanager.api.request.ExpenseRequest;
import br.com.pedront.expensemanager.core.entity.ExpenseEntity;

public class ConvertFromExpenseRequestToExpenseEntity {

    public static ExpenseEntity convert(ExpenseRequest request) {
        return new ExpenseEntity(request.getUser(), request.getCategory(), request.getPeriod(),
            request.getDatetime(), request.getOriginalDescription(), request.getUserDescription(),
            request.getValue());
    }

    public static ExpenseEntity convert(String id, ExpenseRequest request) {
        ExpenseEntity expenseEntity = convert(request);
        expenseEntity.setId(id);

        return expenseEntity;
    }
}
