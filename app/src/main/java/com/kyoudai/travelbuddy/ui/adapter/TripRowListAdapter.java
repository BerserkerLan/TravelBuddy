package com.kyoudai.travelbuddy.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kyoudai.travelbuddy.R;
import com.kyoudai.travelbuddy.models.Trip;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class TripRowListAdapter extends RecyclerView.Adapter<TripRowListAdapter.ViewHolder> {

    private List<Trip> tripList;

    public TripRowListAdapter(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getRowNameTextView().setText(tripList.get(position).getName());
        holder.getRowDescriptionTextView().setText(tripList.get(position).getShortDescription());
        Picasso.get()
                .load(tripList.get(position).getCoverImageUrl())
                .fit()
                .into(holder.getTripImageView());
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static TextView rowNameTextView;
        private static TextView rowDescriptionTextView;
        private static ImageView tripImageView;

        public ViewHolder(View view) {
            super(view);

            rowNameTextView = view.findViewById(R.id.trip_name);
            tripImageView = view.findViewById(R.id.trip_image_view);
            rowDescriptionTextView = view.findViewById(R.id.trip_short_description);
        }

        public TextView getRowNameTextView() {
            return rowNameTextView;
        }

        public ImageView getTripImageView() {
            return tripImageView;
        }

        public TextView getRowDescriptionTextView() {
            return this.rowDescriptionTextView;
        }
    }
}
