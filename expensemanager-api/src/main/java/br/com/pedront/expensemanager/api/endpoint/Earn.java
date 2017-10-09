package br.com.pedront.expensemanager.api.endpoint;

import br.com.pedront.expensemanager.api.converter.ConvertFromEarnRequestToEarnEntity;
import br.com.pedront.expensemanager.api.request.EarnRequest;
import br.com.pedront.expensemanager.core.entity.EarnEntity;
import br.com.pedront.expensemanager.core.service.EarnService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Earn {

    private static final Logger LOGGER = Logger.getLogger(Earn.class);

    @Autowired
    private EarnService earnService;

    @RequestMapping(value = "/earn", method = RequestMethod.POST)
    public EarnEntity create(@RequestBody EarnRequest earnRequest) {
        LOGGER
            .info(String.format("C=Earn M=create step=start earnRequest=%s", earnRequest));

        EarnEntity earnEntity = earnService
            .create(ConvertFromEarnRequestToEarnEntity.convert(earnRequest));

        LOGGER.info(String.format("C=Earn M=create step=end earnEntity=%s", earnEntity));

        return earnEntity;
    }

    @RequestMapping(value = "/earn/{id}", method = RequestMethod.GET)
    public EarnEntity get(@PathVariable String id) {
        LOGGER
            .info(String.format("C=Earn M=get step=start id=%s", id));

        EarnEntity earnEntity = earnService.get(id);

        LOGGER
            .info(String.format("C=Earn M=get step=end one=%s", earnEntity));

        return earnEntity;
    }

    @RequestMapping(value = "/earn/{id}", method = RequestMethod.PUT)
    public EarnEntity update(@PathVariable String id,
        @RequestBody EarnRequest earnRequest) {

        LOGGER.info(
            String.format("C=Earn M=update step=start id=%s earnRequest=%s", id, earnRequest));

        EarnEntity updatedEntity = ConvertFromEarnRequestToEarnEntity
            .convert(id, earnRequest);

        updatedEntity = earnService.update(updatedEntity);

        LOGGER
            .info(String.format("C=Earn M=update step=end updatedEntity=%s", updatedEntity));

        return updatedEntity;
    }

    @RequestMapping(value = "/earn/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        LOGGER
            .info(String.format("C=Earn M=delete step=start id=%s", id));

        earnService.delete(id);

        LOGGER.info("C=Earn M=delete step=end status=ok");

        return ResponseEntity.ok().build();
    }
}
