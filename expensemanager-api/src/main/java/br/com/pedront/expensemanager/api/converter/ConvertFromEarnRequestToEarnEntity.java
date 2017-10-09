package br.com.pedront.expensemanager.api.converter;

import br.com.pedront.expensemanager.api.request.EarnRequest;
import br.com.pedront.expensemanager.core.entity.EarnEntity;
import br.com.pedront.expensemanager.core.entity.ExpenseEntity;

public class ConvertFromEarnRequestToEarnEntity {

    public static EarnEntity convert(EarnRequest request) {
        return new EarnEntity(request.getUser(), request.getCategory(), request.getPeriod(),
            request.getDatetime(), request.getOriginalDescription(), request.getUserDescription(),
            request.getValue());
    }

    public static EarnEntity convert(String id, EarnRequest request) {
        EarnEntity earnEntity = convert(request);
        earnEntity.setId(id);

        return earnEntity;
    }
}
