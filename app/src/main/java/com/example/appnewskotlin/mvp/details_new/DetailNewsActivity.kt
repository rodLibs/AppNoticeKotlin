package com.example.appnewskotlin.mvp.details_new

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.appnewskotlin.R
import com.example.appnewskotlin.data.model.Item
import kotlinx.android.synthetic.main.activity_detail_news.*


class DetailNewsActivity : AppCompatActivity(), DetailsNewsInterface.View {


    var news: Item? = null
    var mPresenter: DetailsNewsInterface.Presenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }


        mPresenter = DetailsNewsPresenter(this@DetailNewsActivity,this@DetailNewsActivity)
        news = intent.getParcelableExtra("news")
        setDataInComponents()
    }



    fun setDataInComponents(){
        if (news != null){
            if (news?.image != null) {
                Glide.with(this@DetailNewsActivity).load(news?.image).centerCrop().placeholder(R.drawable.ic_placeholder).into(img)
            }
            txtTitle.text = news?.title
            txtDate.text = "${news?.category} - ${news?.pubDate?.replace(" -0000","")}"
            txtDescription.text = news?.description?.removeRange(0, news?.description?.indexOf(">")!! - 1)?.replace("/><br />","")

            if (news?.id != null){
                imgFavorite.setImageResource(R.drawable.ic_favorite)
            }
        }
    }



    fun btShare(v: View){
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT,"${news?.title}\n ${news?.link}")
        sendIntent.type = "text/plain"
        startActivity(sendIntent)
    }



    fun btFavorite(v: View){
        if (news?.id != null){
            mPresenter?.removeNewsDatabase(news)
        } else{
            mPresenter?.insertNewsDatabase(news)
        }
    }




    override fun showResult(news: Item?) {
        runOnUiThread {
            if (mPresenter != null){
                if (news?.id != null){
                    imgFavorite.setImageResource(R.drawable.ic_favorite)
                } else{
                    imgFavorite.setImageResource(R.drawable.ic_favorite_2)
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter = null
    }
}