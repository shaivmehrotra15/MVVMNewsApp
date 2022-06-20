package com.androiddevs.mvvmnewsapp.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        binding2 = ItemArticlePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)



        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())





    }
}
