package com.example.dryulia.mainscreen.event;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dryulia.R;
import com.example.dryulia.mainscreen.home.treatment.TreatmentAdapter;
import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;


public class EventFragment extends Fragment {
    //product
    private RecyclerView eventRecyclerView;
    //private RecyclerView.Adapter produkAdapter;
    private EventAdapter adapter;
    private ArrayList<EventModel> events = new ArrayList<>();
    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event, container, false);
        return view; }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        eventRecyclerView = view.findViewById(R.id.rv_event);
        eventRecyclerView.setHasFixedSize(true);
        events.addAll(EventData.getListData());
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new EventAdapter(events,R.layout.item_event,getActivity());
        eventRecyclerView.setAdapter(adapter);


    }
}

