package com.lamzone.mareunion.model.services;

import androidx.lifecycle.LifecycleOwner;

import com.lamzone.mareunion.model.items.Meeting;
import com.lamzone.mareunion.view.recycler.MyMeetingAdapter;
import com.lamzone.mareunion.view.viewModel.MeetingViewModel;

import java.util.ArrayList;
import java.util.List;

public class LocalMeetingService implements LocalApiMeeting {

    private List<Meeting> mMeetings = new ArrayList<>();
    private MeetingViewModel meetingViewModel;
    private MyMeetingAdapter myMeetingAdapter;

   /*
   necessite de penser a l'archi pour plus tard: un tableau vide ne sera pas a remplacer alors qu'une ligne de code ciblee si dans le cas ou l'api change
    */

    @Override
    public List<Meeting> getMeeting() {
        return mMeetings;
    }

    @Override
    public List<Meeting> filteringOptions(String filteredOption) {
        List<Meeting> mMeetingFiltered = new ArrayList<>();
        for (Meeting meeting : mMeetings) {
            if (meeting.getMeetingDate().equals(filteredOption) || meeting.getMeetingPlaceName().equals(filteredOption))
                mMeetingFiltered.add(meeting);
        }
        return mMeetingFiltered;
    }

    /**modify method for data*/
    @Override
    public void deleteMeeting(Meeting meeting) {
        if (meeting == null) {
            throw new IllegalArgumentException("Meeting may not be null");
        }
        //mMeetings.remove(meeting);
        this.meetingViewModel.deleteMeetingDataItem(meeting.getPkMeetingId());

    }

    /**get all meetings for one placeItem with Id*/
    @Override
    public void getMeetingsForOnePlaceItem(int placeItemId) {
        this.meetingViewModel.getMeetingDataItem(placeItemId).observe((LifecycleOwner) this, this ::updateMeetingsList);
    }

    /**modify method for data*/
    @Override
    public void createDataMeeting(Meeting meeting) {
        if (meeting == null) {
            throw new IllegalArgumentException("Meeting may not be null");
        }
        //mMeetings.add(meeting);
        this.meetingViewModel.createMeetingDataItem(meeting);
    }

    /**add method update a meeting for data*/
    @Override
    public void updateDataMeeting(Meeting meeting) {
        this.meetingViewModel.updateMeetingDataItem(meeting);
    }

    /**add method update meeting List for data*/
    @Override
    public void updateMeetingsList(List<Meeting> meetings) {
        this.myMeetingAdapter.updateMeetings(meetings);
    }

}
