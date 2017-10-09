package br.com.pedront.expensemanager.api.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedront.expensemanager.api.converter.ConvertFromIncomeRequestToIncomeEntity;
import br.com.pedront.expensemanager.api.request.IncomeRequest;
import br.com.pedront.expensemanager.core.entity.IncomeEntity;
import br.com.pedront.expensemanager.core.service.IncomeService;

@RestController
public class Income {

    private static final Logger LOGGER = LoggerFactory.getLogger(Income.class);

    @Autowired
    private IncomeService incomeService;

    @RequestMapping(value = "/income", method = RequestMethod.POST)
    public IncomeEntity create(@RequestBody IncomeRequest incomeRequest) {
        LOGGER.info("C=Income M=create step=start incomeRequest=%s", incomeRequest);

        IncomeEntity incomeEntity = incomeService.create(ConvertFromIncomeRequestToIncomeEntity.convert(incomeRequest));

        LOGGER.info("C=Income M=create step=end incomeEntity=%s", incomeEntity);

        return incomeEntity;
    }

    @RequestMapping(value = "/income/{id}", method = RequestMethod.GET)
    public IncomeEntity get(@PathVariable String id) {
        LOGGER.info("C=Income M=get step=start id=%s", id);

        IncomeEntity incomeEntity = incomeService.get(id);

        LOGGER.info("C=Income M=get step=end incomeEntity=%s", incomeEntity);

        return incomeEntity;
    }

    @RequestMapping(value = "/income/{id}", method = RequestMethod.PUT)
    public IncomeEntity update(@PathVariable String id,
            @RequestBody IncomeRequest incomeRequest) {

        LOGGER.info("C=Income M=update step=start id=%s incomeRequest=%s", id, incomeRequest);

        IncomeEntity updatedIncome = ConvertFromIncomeRequestToIncomeEntity.convert(id, incomeRequest);

        updatedIncome = incomeService.update(updatedIncome);

        LOGGER.info("C=Income M=update step=end updatedIncome=%s", updatedIncome);

        return updatedIncome;
    }

    @RequestMapping(value = "/income/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        LOGGER.info("C=Income M=delete step=start id=%s", id);

        incomeService.delete(id);

        LOGGER.info("C=Income M=delete step=end status=ok");

        return ResponseEntity.ok().build();
    }
}
