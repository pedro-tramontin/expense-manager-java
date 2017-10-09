package br.com.pedront.expensemanager.api.endpoint

import br.com.pedront.expensemanager.api.converter.ConvertFromCategoryRequestToCategoryEntity
import br.com.pedront.expensemanager.api.request.CategoryRequest
import br.com.pedront.expensemanager.core.entity.CategoryEntity
import br.com.pedront.expensemanager.core.service.CategoryService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class Category {

    @Autowired
    private val categoryService: CategoryService? = null

    @RequestMapping(value = "/category", method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody categoryRequest: CategoryRequest): CategoryEntity {
        LOGGER.info("C=Category M=create step=start categoryRequest=%s", categoryRequest)

        val categoryEntity = categoryService!!.create(ConvertFromCategoryRequestToCategoryEntity.convert(
                request = categoryRequest))

        LOGGER.info("C=Category M=create step=end categoryEntity=%s", categoryEntity)

        return categoryEntity
    }

    @RequestMapping(value = "/category/{id}", method = arrayOf(RequestMethod.GET))
    fun select(@PathVariable id: String): CategoryEntity {
        LOGGER.info("C=Category M=get step=start id=%s", id)

        val categoryEntity = categoryService!!.select(id)

        LOGGER.info("C=Category M=get step=end categoryEntity=%s", categoryEntity)

        return categoryEntity
    }

    @RequestMapping(value = "/category/{id}", method = arrayOf(RequestMethod.PUT))
    fun update(@PathVariable id: String, @RequestBody categoryRequest: CategoryRequest): CategoryEntity {
        LOGGER.info("C=Category M=update step=start id=%s categoryRequest=%s", id, categoryRequest)

        var updatedCategory = ConvertFromCategoryRequestToCategoryEntity.convert(id, categoryRequest)

        updatedCategory = categoryService!!.update(updatedCategory)

        LOGGER.info("C=Category M=update step=end updatedCategory=%s", updatedCategory)

        return updatedCategory
    }

    @RequestMapping(value = "/category/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: String): ResponseEntity<*> {
        LOGGER.info("C=Category M=delete step=start id=%s", id)

        categoryService!!.delete(id)

        LOGGER.info("C=Category M=delete step=end status=ok")

        return ResponseEntity.ok().build<Any>()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(Category::class.java)
    }
}
