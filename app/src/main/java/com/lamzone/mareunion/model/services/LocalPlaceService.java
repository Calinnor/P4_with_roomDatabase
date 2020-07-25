package com.lamzone.mareunion.model.services;

import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lamzone.mareunion.R;
import com.lamzone.mareunion.model.items.PlaceItem;
import com.lamzone.mareunion.view.recycler.PlaceAdapter;
import com.lamzone.mareunion.view.viewModel.MeetingViewModel;

import java.util.List;

import butterknife.BindView;

public class LocalPlaceService implements LocalApiPlace {

    @BindView(R.id.place_choice)
    TextView placeChoice;
    private long clickedColorPlaceTag;

    private List<PlaceItem> mPlaceItems = PlaceGenerator.generatePlace();
    private List<String> mPlaceNames = PlaceGenerator.generatePlaceNames();
    private PlaceAdapter placeAdapter;
    private MeetingViewModel meetingViewModel;

    @Override
    public List<PlaceItem> getPlaceItem() {
        return mPlaceItems;
    }

    @Override
    public void getCurrentPlaceItem(int placeItemId) {
        this.meetingViewModel.getPlaceItemDataItem(placeItemId).observe((LifecycleOwner) this, new Observer<PlaceItem>() {
            @Override
            public void onChanged(@Nullable PlaceItem placeItem) {
                updateHeader(placeItem);
            }
        });
    }

    @Override
    public void updateHeader(PlaceItem placeItem){
        this.placeChoice.setText(placeItem.getPlaceName());
        this.clickedColorPlaceTag = placeItem.getPlaceColorTag();
    }

    @Override
    public List<String> getPlaceNames() {
        return mPlaceNames;
    }


}
