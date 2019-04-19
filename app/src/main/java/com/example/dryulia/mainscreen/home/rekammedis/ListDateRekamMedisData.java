package com.example.dryulia.mainscreen.home.rekammedis;

import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;

public class ListDateRekamMedisData {
    public static String[] data = new String[]{"5/3/2019","6/3/2019","7/3/2019"};

    public static ArrayList<ListDateRekamMedisModel> getListData(){
        ListDateRekamMedisModel listDateRekamMedisModel = null;
        ArrayList<ListDateRekamMedisModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            listDateRekamMedisModel = new ListDateRekamMedisModel();
            listDateRekamMedisModel.setTanggal(data[i]);
            list.add(listDateRekamMedisModel);
        }
        return list;
    }
}
