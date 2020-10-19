package com.example.academy.data

data class ModuleEntity(
        var moduleId: String,
        var courseId: String,
        var titile: String,
        var posisition: Int,
        var read: Boolean = false
) {
    var contentEntity:ContentEntity? = null
}