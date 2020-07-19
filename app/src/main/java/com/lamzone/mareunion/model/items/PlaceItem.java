package com.lamzone.mareunion.model.items;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlaceItem {

    /**
     * spinner java 1/ create a placeitem objet with reference in his layout
     */

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "placeItemColor")
    private long placeColorTag;
    private String PlaceName;

    public PlaceItem(){};

    public PlaceItem(long placeColorTag, String placeName) {
        this.placeColorTag = placeColorTag;
        this.PlaceName = placeName;
    }



    public String getPlaceName() {
        return "Salle " + PlaceName;
    }

    public long getPlaceColorTag() {
        return placeColorTag;
    }

    public void setPlaceColorTag(long placeColorTag) {
        this.placeColorTag = placeColorTag;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }
}
