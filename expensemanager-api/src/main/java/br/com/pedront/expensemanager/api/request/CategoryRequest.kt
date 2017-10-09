package br.com.pedront.expensemanager.api.request

data class CategoryRequest(var name: String = "",
                           var parentId: String? = null)
