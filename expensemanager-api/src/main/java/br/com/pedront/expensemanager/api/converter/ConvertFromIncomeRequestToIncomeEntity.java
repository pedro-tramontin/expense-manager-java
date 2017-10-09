package br.com.pedront.expensemanager.api.converter;

import br.com.pedront.expensemanager.api.request.IncomeRequest;
import br.com.pedront.expensemanager.core.entity.IncomeEntity;

public class ConvertFromIncomeRequestToIncomeEntity {

    public static IncomeEntity convert(IncomeRequest request) {
        return new IncomeEntity(request.getUser(), request.getCategory(), request.getPeriod(),
                request.getDatetime(), request.getOriginalDescription(), request.getUserDescription(),
                request.getValue());
    }

    public static IncomeEntity convert(String id, IncomeRequest request) {
        IncomeEntity incomeEntity = convert(request);
        incomeEntity.setId(id);

        return incomeEntity;
    }
}
