package br.com.pedront.expensemanager.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedront.expensemanager.core.entity.IncomeEntity;
import br.com.pedront.expensemanager.core.repository.IncomeRepository;

@Service
public class IncomeService {

    public static final IncomeEntity EARN_NULL = new IncomeEntity();

    private static final Logger LOGGER = LoggerFactory.getLogger(IncomeService.class);

    @Autowired
    private IncomeRepository repository;

    public IncomeEntity create(final IncomeEntity earn) {
        return repository.save(earn);
    }

    public IncomeEntity get(final String id) {
        final IncomeEntity foundEarn = repository.findOne(id);

        if (foundEarn == null) {
            return EARN_NULL;
        }

        return foundEarn;
    }

    public IncomeEntity update(final IncomeEntity earn) {
        IncomeEntity updatedEntity = earn;

        if (repository.exists(earn.getId())) {
            IncomeEntity incomeEntity = get(earn.getId());
            if ((incomeEntity != EARN_NULL) &&
                    updateIfOtherDifferentFrom(incomeEntity, earn)) {
                updatedEntity = repository.save(incomeEntity);
            }
        } else {
            // TODO Should throw some exception here indicating the updating didn't occur because of not founding by the
            // id provided

            LOGGER.error("C=EarnService M=update step=test-exists-fail id=%s", earn.getId());
        }

        return updatedEntity;
    }

    public void delete(final String id) {
        if (repository.exists(id)) {
            repository.delete(id);
        }
    }

    private int hashCoreExpenseFields(IncomeEntity earn) {
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

    public boolean updateIfOtherDifferentFrom(IncomeEntity earn, IncomeEntity other) {
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
