package com.example.dryulia.mainscreen.event;

import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;

public class EventData {
    public static String[][] data = new String[][]{
            {"Selama Bulan Februari [Promo Februari]", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2", "Promo Februari. Dapatkakan promo semenarik mungkin dengan membeli salah satu produk kita"},
            {"Selama Bulan Februari [Promo Februari]", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2", "Promo Februari. Dapatkakan promo semenarik mungkin dengan membeli salah satu produk kita"},
            {"Selama Bulan Februari [Promo Februari]", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2", "Promo Februari. Dapatkakan promo semenarik mungkin dengan membeli salah satu produk kita"},
            {"Selama Bulan Februari [Promo Februari]", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2", "Promo Februari. Dapatkakan promo semenarik mungkin dengan membeli salah satu produk kita"},
            {"Selama Bulan Februari [Promo Februari]", "https://scontent-lhr3-1.cdninstagram.com/vp/e345817bacb43ea1de2f0bce7b6f938e/5CF8E766/t51.2885-15/sh0.08/e35/s750x750/36149088_203477010362473_2417627788019236864_n.jpg?_nc_ht=scontent-lhr3-1.cdninstagram.com&ig_cache_key=MTgxOTUwNDQ1NjA2NTUzNDc3OQ%3D%3D.2", "Promo Februari. Dapatkakan promo semenarik mungkin dengan membeli salah satu produk kita"},
    };

    public static ArrayList<EventModel> getListData(){
        EventModel eventModel = null;
        ArrayList<EventModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            eventModel = new EventModel();
            eventModel.setNamaEvent(data[i][0]);
            eventModel.setImage_url(data[i][1]);
            eventModel.setDetailEvent(data[i][2]);
            eventModel.setIndex(i);

            list.add(eventModel);

        }
        return list;
    }
}
