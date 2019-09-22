package com.example.kotlin_mvvm_di_sample.data.db

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_di_sample.data.model.Quote

interface QuoteDao {

    fun addQuote(quote: Quote)

    fun getQuotes(): LiveData<List<Quote>>
}