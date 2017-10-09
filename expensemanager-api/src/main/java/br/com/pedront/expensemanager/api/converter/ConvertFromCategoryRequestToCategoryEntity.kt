package br.com.pedront.expensemanager.api.converter

import br.com.pedront.expensemanager.api.request.CategoryRequest
import br.com.pedront.expensemanager.core.entity.CategoryEntity

class ConvertFromCategoryRequestToCategoryEntity {
    companion object {
        fun convert(id: String? = null, request: CategoryRequest): CategoryEntity {
            return CategoryEntity(id, request.name, request.parentId)
        }
    }
}