package com.example.dryulia.mainscreen.home.produk;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProdukData {
    public static String[][] data = new String[][]{
            {"Garnier","Garnier adalah sabun penucui muka yang sangat bagus untuk kesehatan kulit wajah anda","https://s3-ap-southeast-1.amazonaws.com/img-sociolla/img/p/1/6/9/2/5/16925-large_default.jpg",
            "20000"    , "1"},
            {"Gatsby Face Wash","Gatsyby Face Wash membantu mencerahkan kulit para pria zaman now","https://rukminim1.flixcart.com/image/704/704/jmux18w0/face-wash/u/4/z/100-cooling-face-wash-clear-whitening-gatsby-original-imaf9z4ekzq7tb7s.jpeg?q=70",
            "15000","1"},
            {"Gatsby Face Wash","Gatsyby Face Wash membantu mencerahkan kulit para pria zaman now","https://rukminim1.flixcart.com/image/704/704/jmux18w0/face-wash/u/4/z/100-cooling-face-wash-clear-whitening-gatsby-original-imaf9z4ekzq7tb7s.jpeg?q=70",
                    "15000","1"},
            {"Gatsby Face Wash","Gatsyby Face Wash membantu mencerahkan kulit para pria zaman now","https://rukminim1.flixcart.com/image/704/704/jmux18w0/face-wash/u/4/z/100-cooling-face-wash-clear-whitening-gatsby-original-imaf9z4ekzq7tb7s.jpeg?q=70",
                    "15000","1"},
            {"Gatsby Face Wash","Gatsyby Face Wash membantu mencerahkan kulit para pria zaman now","https://rukminim1.flixcart.com/image/704/704/jmux18w0/face-wash/u/4/z/100-cooling-face-wash-clear-whitening-gatsby-original-imaf9z4ekzq7tb7s.jpeg?q=70",
                    "15000","1"},
            {"Gatsby Face Wash","Gatsyby Face Wash membantu mencerahkan kulit para pria zaman now","https://rukminim1.flixcart.com/image/704/704/jmux18w0/face-wash/u/4/z/100-cooling-face-wash-clear-whitening-gatsby-original-imaf9z4ekzq7tb7s.jpeg?q=70",
                    "15000","1"}

    };

    public static ArrayList<ProdukModel> getListData(){
        ProdukModel produkModel = null;
        ArrayList<ProdukModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            produkModel = new ProdukModel();
            produkModel.setNamaProduk(data[i][0]);
            produkModel.setDetailProduk(data[i][1]);
            produkModel.setImage_url(data[i][2]);
            produkModel.setHargaProduk(Integer.parseInt(data[i][3]));
            produkModel.setJumlahOrder(Integer.parseInt(data[i][4]));
            produkModel.setIndex(i);

            list.add(produkModel);

        }
        return list;
    }
}
