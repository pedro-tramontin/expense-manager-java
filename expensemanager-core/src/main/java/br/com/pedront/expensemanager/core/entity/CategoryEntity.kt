package br.com.pedront.expensemanager.core.entity

import org.springframework.data.annotation.Id

data class CategoryEntity(@Id var id: String? = null,
                          var name: String = "",
                          var parentId: String? = null)
