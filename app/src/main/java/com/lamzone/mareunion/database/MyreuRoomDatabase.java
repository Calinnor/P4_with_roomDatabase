package com.lamzone.mareunion.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lamzone.mareunion.database.dao.MeetingDao;
import com.lamzone.mareunion.database.dao.PlaceItemDao;
import com.lamzone.mareunion.model.items.Meeting;
import com.lamzone.mareunion.model.items.PlaceItem;

@Database(entities = {Meeting.class, PlaceItem.class}, version = 1, exportSchema = false)
//exportSchema is for ? I dont uderstand. When not implemented do a warning at line 15 (20 with warning text):
//warning: Schema export directory is not provided to the annotation processor so we cannot export the schema.
// You can either provide `room.schemaLocation` annotation processor argument OR set exportSchema to false.
//public abstract class MyreuRoomDatabase extends RoomDatabase {
//                ^
//1 warning

public abstract class MyreuRoomDatabase extends RoomDatabase {

    //singleton
    private static volatile MyreuRoomDatabase INSTANCE;

    //dao
    public abstract MeetingDao meetingDao();
    public abstract PlaceItemDao placeItemDao();

    //MyreuRoomDatabase instance
    public static MyreuRoomDatabase getInstance(Context context) {
        //si l'instance est nulle
        if(INSTANCE == null) {
            //on synchornise avec une instance de MyreuRommDatabase
            synchronized (MyreuRoomDatabase.class) {
                //ensuite si il n'y a rien
                if (INSTANCE==null) {
                    //on crée une data base
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),MyreuRoomDatabase.class, "MyReuDatabase").build();
                }
            }
        }
        return INSTANCE;
    }
}
