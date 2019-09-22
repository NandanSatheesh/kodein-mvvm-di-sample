package com.example.kotlin_mvvm_di_sample.data.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_di_sample.data.model.Quote

interface QuoteRepository {

    fun addQuote(quote: Quote)

    fun getQuotes() : LiveData<List<Quote>>

}