package com.lamzone.mareunion.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.lamzone.mareunion.model.items.PlaceItem;

import java.util.List;

@Dao
public interface PlaceItemDao {

    @Query("SELECT * FROM PlaceItem WHERE placeItemColor = :placeItemId")
    LiveData<PlaceItem> getPlaceItems(long placeItemId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createPaceItem(PlaceItem placeItem);
}
