package br.com.pedront.expensemanager.core.service;

import br.com.pedront.expensemanager.core.entity.EarnEntity;
import br.com.pedront.expensemanager.core.entity.EarnEntity;
import br.com.pedront.expensemanager.core.repository.EarnRepository;
import br.com.pedront.expensemanager.core.repository.ExpenseRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarnService {

    public static final EarnEntity EARN_NULL = new EarnEntity();

    private static final Logger LOGGER = Logger.getLogger(EarnService.class);

    @Autowired
    private EarnRepository repository;

    public EarnEntity create(final EarnEntity earn) {
        final EarnEntity newEarn = repository.save(earn);

        return newEarn;
    }

    public EarnEntity get(final String id) {
        final EarnEntity foundEarn = repository.findOne(id);

        if (foundEarn == null) {
            return EARN_NULL;
        }

        return foundEarn;
    }

    public EarnEntity update(final EarnEntity earn) {
        EarnEntity updatedEntity = earn;

        if (repository.exists(earn.getId())) {
            EarnEntity earnEntity = get(earn.getId());
            if ((earnEntity != EARN_NULL) &&
                updateIfOtherDifferentFrom(earnEntity, earn)) {
                updatedEntity = repository.save(earnEntity);
            }
        } else {
            // TODO Should throw some exception here indicating the updating didn't occur because of not founding by the id provided

            LOGGER.error(String
                .format("C=EarnService M=update step=test-exists-fail id=%s", earn.getId()));
        }

        return updatedEntity;
    }

    public void delete(final String id) {
        if (repository.exists(id)) {
            repository.delete(id);
        }
    }

    private int hashCoreExpenseFields(EarnEntity earn) {
        int result = earn.getUser().hashCode();
        result = 31 * result + earn.getCategory().hashCode();
        result = 31 * result + earn.getPeriod().hashCode();
        result = 31 * result + earn.getDatetime().hashCode();
        result = 31 * result + earn.getOriginalDescription().hashCode();
        result = 31 * result + (earn.getUserDescription() != null ? earn.getUserDescription()
            .hashCode() : 0);
        result = 31 * result + earn.getValue().hashCode();
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

    public boolean updateIfOtherDifferentFrom(EarnEntity earn, EarnEntity other) {
        if (other == null) {
            return false;
        }

        if (hashCoreExpenseFields(earn) != hashCoreExpenseFields(other)) {
            if (areDifferent(earn.getUser(), other.getUser())) {
                earn.setUser(other.getUser());
            }

            if (areDifferent(earn.getCategory(), other.getCategory())) {
                earn.setCategory(other.getCategory());
            }

            if (areDifferent(earn.getPeriod(), other.getPeriod())) {
                earn.setPeriod(other.getPeriod());
            }

            if (areDifferent(earn.getDatetime(), other.getDatetime())) {
                earn.setDatetime(other.getDatetime());
            }

            if (areDifferent(earn.getOriginalDescription(), other.getOriginalDescription())) {
                earn.setOriginalDescription(other.getOriginalDescription());
            }

            if (areDifferent(earn.getUserDescription(), other.getUserDescription())) {
                earn.setUserDescription(other.getUserDescription());
            }

            if (areDifferent(earn.getValue(), other.getValue())) {
                earn.setValue(other.getValue());
            }

            return true;
        }

        return false;
    }
}
