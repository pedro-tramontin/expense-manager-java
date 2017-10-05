package br.com.pedront.expensemanager.api;

import br.com.pedront.expensemanager.api.request.ExpenseRequest;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Expense {

    private static final Logger LOGGER = Logger.getLogger(Expense.class);

    @RequestMapping(value = "/expense", method = RequestMethod.POST)
    public ResponseEntity insert(ExpenseRequest request) {
        LOGGER.info("insert");

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable int id) {
        LOGGER.info("get");

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable int id) {
        LOGGER.info("update");

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/expense/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int id) {
        LOGGER.info("delete");

        return new ResponseEntity(HttpStatus.OK);
    }
}
