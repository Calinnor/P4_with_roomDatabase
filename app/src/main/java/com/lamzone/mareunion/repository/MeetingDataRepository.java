package com.lamzone.mareunion.repository;

import androidx.lifecycle.LiveData;

import com.lamzone.mareunion.database.dao.MeetingDao;
import com.lamzone.mareunion.model.items.Meeting;

import java.util.List;

public class MeetingDataRepository {

    private final MeetingDao meetingDao;

    public MeetingDataRepository(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    public void createMeeting_meetingDataRepository(Meeting meeting) { meetingDao.insertMeeting(meeting);}

    /**Read = get meetings*/
    public LiveData<List<Meeting>> getMeetings_meetingDataRepository(long placeItemId) {return this.meetingDao.getMeetings(placeItemId);}

    /**Update = update meeting*/
    public void updateMeeting_meetingDataRepository(Meeting meeting) { meetingDao.updateMeeting(meeting);}

    /**Delete = delete meeting*/
    public void deleteMeeting_meetingDataRepository(long meetingId) {meetingDao.deleteMeeting(meetingId);}
}
