package com.lamzone.mareunion.database.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lamzone.mareunion.model.items.Meeting;
import com.lamzone.mareunion.model.items.PlaceItem;

import java.util.List;

@Dao
public interface MeetingDao {

    @Query("SELECT * FROM Meeting WHERE placeItemId = :placeItemId")
    LiveData<List<Meeting>> getMeetings(long placeItemId);

    /**select all task too ?*/
    @Query("SELECT * FROM Meeting WHERE placeItemId = :placeItemId")
    Cursor getMeetingssWithCursor(long placeItemId);

    @Insert
    long insertMeeting(Meeting meeting);

    @Update
    int updateMeeting(Meeting meeting);

    @Query("DELETE FROM Meeting WHERE pkMeetingId = :meetingId")
    int deleteMeeting(long meetingId);
}

