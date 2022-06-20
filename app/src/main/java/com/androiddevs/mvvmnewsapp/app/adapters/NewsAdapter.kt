package com.androiddevs.mvvmnewsapp.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
//import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.app.models.Article
import com.androiddevs.mvvmnewsapp.databinding.ActivityNewsBinding
import com.androiddevs.mvvmnewsapp.databinding.FragmentArticleBinding
import com.androiddevs.mvvmnewsapp.databinding.ItemArticlePreviewBinding
import com.bumptech.glide.Glide
import okhttp3.internal.http2.Http2Connection


class NewsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder >()  {

    inner class ArticleViewHolder(val binding : ActivityNewsBinding ) : RecyclerView.ViewHolder(binding.root)
    inner class ArticleViewHolder2(val binding2: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding2.root)

    private val differcCallback = object : DiffUtil.ItemCallback<Article>(){

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this , differcCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ActivityNewsBinding.inflate(LayoutInflater.from(parent.context),parent,true)
        val binding2 = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context),parent,true)

        return ArticleViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = differ.currentList[position]
        with(differ.currentList[position]) {
            (holder as ArticleViewHolder).binding.apply {
                Glide.with(holder.itemView.context).load(article.urlToImage)
                    .into((holder as ArticleViewHolder2).binding2.ivArticleImage)
            }

        }
        (holder as ArticleViewHolder2)
        holder.binding2.tvSource.text = article.source.name
        holder.binding2.tvTitle.text = article.title
        holder.binding2.tvDescription.text = article.description
        holder.binding2.tvPublishedAt.text = article.publishedAt
        onItemClickListener?.let { it(article) }
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setonItemClickListener(listener: (Article) -> Unit){
        onItemClickListener = listener
    }



//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        with(){
//            with(differ.currentList[position]){
//                val article = differ.currentList[position]
//                holder.binding.apply {
//                    Glide.with(holder.itemView.context).load(urlToImage).into(tv)
//                }
//            }
//        }
//    }

}