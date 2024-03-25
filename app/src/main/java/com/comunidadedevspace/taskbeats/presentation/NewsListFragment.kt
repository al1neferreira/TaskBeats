package com.comunidadedevspace.taskbeats.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.News


/**
 * A simple [Fragment] subclass.
 * Use the [NewsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class NewsListFragment : Fragment() {

    private val adapter = NewsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvNewsList = view.findViewById<RecyclerView>(R.id.rv_news)
        rvNewsList.adapter = adapter

        //Fake list
        val newsList = listOf<News>(
            News(
                "The Morning After: How to claim your cut of Meta's $725 million class action settlement",
                "https://s.yimg.com/uu/api/res/1.2/QByqEHEf94bGVzDtL.iBrg--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2022-02/975d8ba0-9001-11ec-b9fc-389e6f099f77.cf.jpg"
            ),
            News(
                "How to make your HomePod alert you when your smoke alarms go off",
                "https://cdn.vox-cdn.com/thumbor/Z-GiXSyc1sTxrjFJDwH8-E4bNlM=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/24392606/Smart_Home_HT023_HomePod_Mini.jpg"
            ),
            News(
                "Earth Day 2023: green or greenwashed?",
                "https://cdn.vox-cdn.com/thumbor/_mqPWEXWnh0OQjACb7J3HqsH1Uk=/0x0:8060x5373/1200x628/filters:focal(4030x2687:4031x2688)/cdn.vox-cdn.com/uploads/chorus_asset/file/24598251/1251776516.jpg"
            ),
            News(
                "The Turtle Beach Stealth Pro Has the Best Noise Canceling on a Gaming Headset",
                "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/12e63a87a75c97ae430008cd2376dfb2.png"
            ),
            News(
                "Amazon introduces new feature to make dialogue in its TV shows intelligible",
                "https://cdn.arstechnica.net/wp-content/uploads/2023/04/amazon-dialogue-boost-760x380.png"
            ),
            News(
                "The Morning After: How to claim your cut of Meta's $725 million class action settlement",
                "https://s.yimg.com/uu/api/res/1.2/QByqEHEf94bGVzDtL.iBrg--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2022-02/975d8ba0-9001-11ec-b9fc-389e6f099f77.cf.jpg"
            ),
            News(
                "How to make your HomePod alert you when your smoke alarms go off",
                "https://cdn.vox-cdn.com/thumbor/Z-GiXSyc1sTxrjFJDwH8-E4bNlM=/0x0:2040x1360/1200x628/filters:focal(1020x680:1021x681)/cdn.vox-cdn.com/uploads/chorus_asset/file/24392606/Smart_Home_HT023_HomePod_Mini.jpg"
            ),
            News(
                "Earth Day 2023: green or greenwashed?",
                "https://cdn.vox-cdn.com/thumbor/_mqPWEXWnh0OQjACb7J3HqsH1Uk=/0x0:8060x5373/1200x628/filters:focal(4030x2687:4031x2688)/cdn.vox-cdn.com/uploads/chorus_asset/file/24598251/1251776516.jpg"
            ),
            News(
                "The Turtle Beach Stealth Pro Has the Best Noise Canceling on a Gaming Headset",
                "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/12e63a87a75c97ae430008cd2376dfb2.png"
            ),
            News(
                "Amazon introduces new feature to make dialogue in its TV shows intelligible",
                "https://cdn.arstechnica.net/wp-content/uploads/2023/04/amazon-dialogue-boost-760x380.png"
            )
        )

        adapter.submitList(newsList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment NewsListFragment.
         */

        @JvmStatic
        fun newInstance() = NewsListFragment()
    }
}
