package br.com.pedront.expensemanager.core.service

import br.com.pedront.expensemanager.core.entity.CategoryEntity
import br.com.pedront.expensemanager.core.repository.CategoryRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService {

    @Autowired
    private val repository: CategoryRepository? = null

    fun create(category: CategoryEntity): CategoryEntity {

        return repository!!.save(category)

    }

    fun select(id: String): CategoryEntity {

        return repository!!.findOne(id) ?: return CATEGORY_NULL

    }

    fun update(category: CategoryEntity): CategoryEntity {
        var updatedCategory = category

        if (repository!!.exists(category.id)) {
            val categoryEntity = select(category.id ?: "0")
            if (categoryEntity !== CATEGORY_NULL && updateIfOtherDifferentFrom(categoryEntity, category)) {
                updatedCategory = repository.save(categoryEntity)
            }
        } else {
            // TODO Should throw some exception here indicating the updating didn't occur because of not founding by the id provided

            LOGGER.error("C=CategoryService M=update step=test-exists-fail id=%s", category.id)
        }

        return updatedCategory
    }

    fun delete(id: String) {
        if (repository!!.exists(id)) {
            repository.delete(id)
        }
    }

    private fun hashCoreExpenseFields(category: CategoryEntity): Int {
        var result = category.name.hashCode()

        var parentId = category.parentId ?: 0
        result = 31 * result + parentId.hashCode()

        return result
    }

    fun areDifferent(value1: String?, value2: String?): Boolean {
        if (value1 == null && value2 != null) {
            return true
        }

        if (value1 != null && value1 != value2) {
            return true
        }

        return false
    }

    fun updateIfOtherDifferentFrom(category: CategoryEntity, other: CategoryEntity?): Boolean {
        if (other == null) {
            return false
        }

        if (hashCoreExpenseFields(category) != hashCoreExpenseFields(other)) {
            if (areDifferent(category.name, other.name)) {
                category.name = other.name
            }

            if (areDifferent(category.parentId, other.parentId)) {
                category.parentId = other.parentId
            }

            return true
        }

        return false
    }

    companion object {
        val CATEGORY_NULL = CategoryEntity()

        private val LOGGER = LoggerFactory.getLogger(CategoryService::class.java)
    }
}
