package com.example.kotlin_mvvm_di_sample.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_mvvm_di_sample.R
import com.example.kotlin_mvvm_di_sample.data.model.Quote
import com.example.kotlin_mvvm_di_sample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        initializeUI()
    }

    fun initializeUI() {
        val viewModel: QuotesViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(QuotesViewModel::class.java)


        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("\'${quote.quote}\' - ${quote.author}\n\n")
            }
            quotesTextView.setText(stringBuilder)
        })


        addQuoteButton.setOnClickListener {
            if (editTextAuthor.text.toString().length != 0 && editTextQuote.text.toString().length != 0) {
                val quote = Quote(editTextQuote.text.toString(), editTextAuthor.text.toString())
                viewModel.addQuote(quote)
                editTextQuote.setText("")
                editTextAuthor.setText("")
            }
        }
    }
}
