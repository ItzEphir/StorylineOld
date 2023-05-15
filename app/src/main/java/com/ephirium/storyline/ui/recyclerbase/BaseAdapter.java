package com.ephirium.storyline.ui.recyclerbase;

import static com.ephirium.common.log.LoggerKt.logError;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListAdapter;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.ephirium.common.delegate.AdapterDelegate;
import com.ephirium.common.delegate.DelegateItem;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends ListAdapter<DelegateItem, ViewHolder> {

    private final List<AdapterDelegate> delegates = new ArrayList<>();

    public BaseAdapter() {
        super(new ItemCallback<>() {

            @Override
            public boolean areItemsTheSame(@NonNull DelegateItem oldItem, @NonNull DelegateItem newItem) {
                return oldItem.getDelegateId().equals(newItem.getDelegateId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull DelegateItem oldItem, @NonNull DelegateItem newItem) {
                return oldItem.getDelegateContent().equals(oldItem.getDelegateContent());
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return (viewType >= 0) ? delegates.get(viewType).onCreateViewHolder(parent) :
                new EmptyViewHolder(parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            delegates.get(getItemViewType(position)).onBindViewHolder(holder, getItem(position));
        } catch (IndexOutOfBoundsException exception) {
            logError(exception.toString(), "Delegate out of range");
        }
    }

    @Override
    public int getItemViewType(int position) {
        var iterator = delegates.listIterator();
        while(iterator.hasNext())
            if(iterator.next().isOfViewType(getCurrentList().get(position)))
                return iterator.previousIndex() + 1;
        return -1;
    }

    public void addDelegate(AdapterDelegate delegate) {
        delegates.add(delegate);
    }

}

class EmptyViewHolder extends ViewHolder {

    public EmptyViewHolder(Context context) {
        super(new View(context));
    }
}
