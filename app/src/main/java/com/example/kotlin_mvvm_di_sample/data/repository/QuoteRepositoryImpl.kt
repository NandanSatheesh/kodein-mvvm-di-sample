package com.example.kotlin_mvvm_di_sample.data.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_mvvm_di_sample.data.db.QuoteDao
import com.example.kotlin_mvvm_di_sample.data.model.Quote

class QuoteRepositoryImpl(private val quoteDao: QuoteDao) : QuoteRepository {

    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> = quoteDao.getQuotes()

}
