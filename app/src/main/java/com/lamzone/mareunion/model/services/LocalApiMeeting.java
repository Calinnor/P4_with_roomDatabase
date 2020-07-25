package com.lamzone.mareunion.model.services;

import com.lamzone.mareunion.model.items.Meeting;

import java.util.List;

public interface LocalApiMeeting {

    List<Meeting> getMeeting();

    /**
     * @param meeting dont forget to put param for methods !(
     */

    void deleteMeeting(Meeting meeting);

    void getMeetingsForOnePlaceItem(int placeItemId);

    void createDataMeeting(Meeting meeting);

    void updateDataMeeting(Meeting meeting);

    void updateMeetingsList(List<Meeting> meetings);

    List<Meeting> filteringOptions(String filteredOption);

}

