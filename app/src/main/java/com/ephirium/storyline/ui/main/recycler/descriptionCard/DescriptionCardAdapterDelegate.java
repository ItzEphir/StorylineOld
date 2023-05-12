package com.ephirium.storyline.ui.main.recycler.descriptionCard;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.ephirium.storyline.common.recycler.delegate.AdapterDelegate;
import com.ephirium.storyline.common.recycler.delegate.DelegateItem;
import com.ephirium.storyline.databinding.ViewDescriptionCardBinding;
import com.ephirium.storyline.model.DescriptionCard;

public class DescriptionCardAdapterDelegate implements AdapterDelegate {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        var binding = ViewDescriptionCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DescriptionCardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, DelegateItem item) {
        ((DescriptionCardViewHolder) holder).bind((DescriptionCard) item);
    }

    @Override
    public Boolean isOfViewType(DelegateItem item) {
        return item instanceof DescriptionCard;
    }
}

class DescriptionCardViewHolder extends ViewHolder {
    private final ViewDescriptionCardBinding binding;

    public DescriptionCardViewHolder(ViewDescriptionCardBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(DescriptionCard item) {
        binding.name.setText(item.getName());
        binding.biography.setText(item.getDescription());
        // TODO: Сделать загрузку аватарки пользователя
    }
}
