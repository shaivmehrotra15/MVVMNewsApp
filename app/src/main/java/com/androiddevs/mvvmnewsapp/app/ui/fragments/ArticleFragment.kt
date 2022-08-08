package com.androiddevs.mvvmnewsapp.app.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.app.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.app.ui.NewsViewModel
import com.androiddevs.mvvmnewsapp.databinding.FragmentArticleBinding

class ArticleFragment: Fragment(R.layout.fragment_article) {

    private lateinit var binding: FragmentArticleBinding
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        binding = FragmentArticleBinding.bind(view)
    }

}