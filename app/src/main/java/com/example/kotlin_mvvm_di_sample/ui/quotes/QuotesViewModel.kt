package com.example.kotlin_mvvm_di_sample.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.kotlin_mvvm_di_sample.data.model.Quote
import com.example.kotlin_mvvm_di_sample.data.repository.QuoteRepository

class QuotesViewModel (private val quoteRepository: QuoteRepository) : ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}