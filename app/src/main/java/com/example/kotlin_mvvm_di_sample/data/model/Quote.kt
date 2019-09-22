package com.example.kotlin_mvvm_di_sample.data.model

data class Quote(
    val quote: String,
    val author: String
) {
    override fun toString(): String {
        return "Quote(quote='$quote', author='$author')"
    }


}