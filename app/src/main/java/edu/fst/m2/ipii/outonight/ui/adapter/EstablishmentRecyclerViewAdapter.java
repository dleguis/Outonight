package edu.fst.m2.ipii.outonight.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.fst.m2.ipii.outonight.R;
import edu.fst.m2.ipii.outonight.model.Establishment;
import edu.fst.m2.ipii.outonight.ui.adapter.cell.EstablishmentItemViewHolder;


public class EstablishmentRecyclerViewAdapter extends RecyclerView.Adapter<EstablishmentItemViewHolder> {



    private List<Establishment> datasource;
    private Context context;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public EstablishmentRecyclerViewAdapter(final Context context) {
        this.context = context;
    }

    public EstablishmentRecyclerViewAdapter(List<Establishment> datasource, final Context context) {
        this.datasource = datasource;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (datasource.get(position).isFeatured()) {
            return TYPE_HEADER;
        }
        else {
            return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return datasource.size();
    }

    @Override
    public EstablishmentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                return new EstablishmentItemViewHolder(view, context) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                return new EstablishmentItemViewHolder(view, context) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(EstablishmentItemViewHolder holder, int position) {
        holder.updateView(datasource.get(position));
    }

    public List<Establishment> getDatasource() {
        return datasource;
    }
}