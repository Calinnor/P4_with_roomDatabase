package com.lamzone.mareunion.view.viewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lamzone.mareunion.model.items.Meeting;
import com.lamzone.mareunion.model.items.PlaceItem;
import com.lamzone.mareunion.repository.MeetingDataRepository;
import com.lamzone.mareunion.repository.PlaceItemDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class MeetingViewModel extends ViewModel {

    /**
     * repository and for "asyncTask" class var
     */
    private final MeetingDataRepository meetingDataSource;
    private final PlaceItemDataRepository placeItemDataSource;
    private final Executor executor;

    /**
     * placeItem data
     */
    @Nullable
    private LiveData<PlaceItem> currentPlaceItem;

    /**
     * constructor
     */
    public MeetingViewModel(MeetingDataRepository meetingDataSource, PlaceItemDataRepository placeItemDataSource, Executor executor) {
        this.meetingDataSource = meetingDataSource;
        this.placeItemDataSource = placeItemDataSource;
        this.executor = executor;
    }
    /**use for initialise ViewModel in activity*/
    public void init(long placeItemId) {
        if(this.currentPlaceItem !=null) {
            return;
        }
        currentPlaceItem = placeItemDataSource.getPlaceItem_placeItemDataRepository(placeItemId);
    }

    /**Data source for PLACEITEM obtains from PlaceItemDataRepository
     *
     * PLACEITEM
     * read placeItem
     */
    public LiveData<PlaceItem>getPlaceItemDataItem(long placeItemId){
        return this.currentPlaceItem;
    }

    /**Data source for MEETINGS obtains from MeetingDataRepository
     *
     * MEETING
     * create meeting
     */
    public void createMeetingDataItem(Meeting meeting){
        executor.execute(()->{
            meetingDataSource.createMeeting_meetingDataRepository(meeting);
        });
    }

    /**Read meeting*/
    public LiveData<List<Meeting>> getMeetingDataItem(long placeItemId){
        return meetingDataSource.getMeetings_meetingDataRepository(placeItemId);
    }

    /**update meeting*/
    public void updateMeetingDataItem(Meeting meeting){
        executor.execute(()->{
            meetingDataSource.updateMeeting_meetingDataRepository(meeting);
        });
    }

    /**delete meeting from Id*/
    public void deleteMeetingDataItem(long meetingId){
        executor.execute(()->{
            meetingDataSource.deleteMeeting_meetingDataRepository(meetingId);
        });
    }
}
