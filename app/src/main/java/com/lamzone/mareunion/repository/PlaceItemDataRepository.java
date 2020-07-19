package com.lamzone.mareunion.repository;

import androidx.lifecycle.LiveData;

import com.lamzone.mareunion.database.dao.PlaceItemDao;
import com.lamzone.mareunion.model.items.PlaceItem;

public class PlaceItemDataRepository {

    private final PlaceItemDao placeItemDao;

    public PlaceItemDataRepository(PlaceItemDao placeItemDao) {
        this.placeItemDao = placeItemDao;
    }

    public LiveData<PlaceItem> getPlaceItem_placeItemDataRepository(long placeItemId) {return this.placeItemDao.getPlaceItems(placeItemId);}
}
