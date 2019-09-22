package com.example.kotlin_mvvm_di_sample.data.db

class DatabaseFakeImpl : Database {
    override val quotesDao: QuoteDao = QuoteDaoFakeImpl()
}