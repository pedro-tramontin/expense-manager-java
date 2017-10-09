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

import br.com.pedront.expensemanager.api.converter.ConvertFromExpenseRequestToExpenseEntity;
import br.com.pedront.expensemanager.api.request.ExpenseRequest;
import br.com.pedront.expensemanager.core.entity.ExpenseEntity;
import br.com.pedront.expensemanager.core.service.ExpenseService;

@RestController
public class Expense {

    private static final Logger LOGGER = LoggerFactory.getLogger(Expense.class);

    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    public ExpenseEntity create(@RequestBody ExpenseRequest expenseRequest) {
        LOGGER.info("C=Expense M=create step=start expenseRequest=%s", expenseRequest);

        ExpenseEntity expenseEntity = expenseService
                .create(ConvertFromExpenseRequestToExpenseEntity.convert(expenseRequest));

        LOGGER.info("C=Expense M=create step=end expenseEntity=%s", expenseEntity);

        return expenseEntity;
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.GET)
    public ExpenseEntity get(@PathVariable String id) {
        LOGGER.info("C=Expense M=get step=start id=%s", id);

        ExpenseEntity expenseEntity = expenseService.get(id);

        LOGGER.info("C=Expense M=get step=end expenseEntity=%s", expenseEntity);

        return expenseEntity;
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.PUT)
    public ExpenseEntity update(@PathVariable String id, @RequestBody ExpenseRequest expenseRequest) {

        LOGGER.info("C=Expense M=update step=start id=%s expenseRequest=%s", id, expenseRequest);

        ExpenseEntity updatedExpense = ConvertFromExpenseRequestToExpenseEntity.convert(id, expenseRequest);

        updatedExpense = expenseService.update(updatedExpense);

        LOGGER.info("C=Expense M=update step=end updatedExpense=%s", updatedExpense);

        return updatedExpense;
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        LOGGER.info("C=Expense M=delete step=start id=%s", id);

        expenseService.delete(id);

        LOGGER.info("C=Expense M=delete step=end status=ok");

        return ResponseEntity.ok().build();
    }
}
