package com.example.recyclerviewdemo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements Filterable {

    ArrayList<Contries> countriesList;
    ArrayList<Contries> countriesListFull;
    Drawable icon;

    public CustomAdapter(ArrayList<Contries> countries, Drawable icon){
        this.countriesList = countries;
        countriesListFull = new ArrayList<>(countriesList);
        this.icon = icon;
    }

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    private Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            ArrayList<Contries> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                filteredList.addAll(countriesListFull);
            }else {
                String filterPatern = charSequence.toString().toLowerCase(Locale.ROOT).trim();

                for (Contries contries: countriesListFull){
                    if (contries.getContryName().toLowerCase(Locale.ROOT).startsWith(filterPatern)) {

                        filteredList.add(contries);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            countriesList.clear();
            countriesList.addAll((ArrayList) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView countryName;
        ImageView myImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.tvContryName);
            myImage = itemView.findViewById(R.id.myicon);
        }
        public TextView getCountryName(){
            return countryName;
        }
        public ImageView getIcon(){
            return myImage;
        }
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

    holder.getCountryName().setText(countriesList.get(position).contryName);
    holder.getIcon().setBackground(icon);
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }
}

