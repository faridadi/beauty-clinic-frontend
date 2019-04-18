package com.example.dryulia.mainscreen.event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dryulia.R;
import com.example.dryulia.mainscreen.MainScreenActivity;
import com.example.dryulia.mainscreen.home.treatment.TreatmentAdapter;
import com.example.dryulia.mainscreen.home.treatment.TreatmentModel;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventItemViewHolder> {
    private Context context;
    private ArrayList<EventModel> eventModelArrayList;
    private View view;

    public EventAdapter(Context context) {
        this.context = context;
    }

    public EventAdapter(ArrayList<EventModel> events, int item_event, FragmentActivity activity) {
        this.context = context;
        this.eventModelArrayList = events;
        this.view = view;
    }


    @NonNull
    @Override
    public EventItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);

        return new EventAdapter.EventItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventItemViewHolder eventItemViewHolder, int position) {
        final EventModel eventModel = eventModelArrayList.get(position);
        Glide.with(MainScreenActivity.getInstance())
                .load(eventModel.getImage_url())
                .apply(new RequestOptions().override(300, 200))
                .into(eventItemViewHolder.imageEvent);

        eventItemViewHolder.headerEvent.setText(eventModel.getNamaEvent());
        eventItemViewHolder.captionEvent.setText(eventModel.getDetailEvent());

    }


    @Override
    public int getItemCount() {
        return eventModelArrayList.size();
    }

    public class EventItemViewHolder extends RecyclerView.ViewHolder {
        TextView headerEvent, captionEvent;
        ImageView imageEvent;
        public EventItemViewHolder(@NonNull View itemView) {
            super(itemView);
            headerEvent = itemView.findViewById(R.id.tv_event_header);
            captionEvent = itemView.findViewById(R.id.tv_event_caption);
            imageEvent = itemView.findViewById(R.id.img_event);
        }
    }
}
