package com.lamzone.mareunion.injections;

import android.content.Context;

import com.lamzone.mareunion.database.MyreuRoomDatabase;
import com.lamzone.mareunion.repository.MeetingDataRepository;
import com.lamzone.mareunion.repository.PlaceItemDataRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DataInjection {

    /**provide new item placeItemDataRepository using singleton*/
    public static PlaceItemDataRepository providePlaceItemDataSource(Context context){
        MyreuRoomDatabase database = MyreuRoomDatabase.getInstance(context);
        return new PlaceItemDataRepository(database.placeItemDao());
    }

    /**provide new item meetingDataRepository using singleton*/
    public static MeetingDataRepository provideMeetingDataSource(Context context){
        MyreuRoomDatabase database = MyreuRoomDatabase.getInstance(context);
        return new MeetingDataRepository(database.meetingDao());
    }

    /**provide new item executor*/
    public static Executor provideExecutor(){
        return Executors.newSingleThreadExecutor();//there's another 'executor: executor without 's'(java.util.concurent)
    }

    /**provide new MeetingViewModelFactory using items providers in param*/
    public static MeetingViewModelFactory provideMeetingViewModelFactory(Context context){
        MeetingDataRepository meetingDataSource = provideMeetingDataSource(context);
        PlaceItemDataRepository placeItemDataSource = providePlaceItemDataSource(context);
        Executor executor = provideExecutor();
        /** may be implemented in the same order as the MeetingViewModelFactory constructor else create error (!)*/
        return new MeetingViewModelFactory(meetingDataSource, placeItemDataSource, executor );
    }

}
