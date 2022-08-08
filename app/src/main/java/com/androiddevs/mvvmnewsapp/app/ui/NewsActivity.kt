package com.androiddevs.mvvmnewsapp.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.app.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.app.repository.NewsRepository
//import androidx.navigation.ui.setupWithNavController
//import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.databinding.ActivityNewsBinding
import com.androiddevs.mvvmnewsapp.databinding.FragmentArticleBinding
import com.androiddevs.mvvmnewsapp.databinding.ItemArticlePreviewBinding
import kotlinx.android.synthetic.main.activity_news.*

//import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    private lateinit var binding2: ItemArticlePreviewBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        binding2 = ItemArticlePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this , viewModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())





    }
}
