package com.lamzone.mareunion.model.items;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = PlaceItem.class, parentColumns = "placeItemColor", childColumns = "placeItemId"))
public class Meeting {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int pkMeetingId;

    private int meetingColorTag;
    private String meetingSubject;
    private String meetingStartHour;
    private String meetingEndHour;
    private String meetingPlaceName;
    private String meetingParticipantsInformations;
    private String meetingDate;
    private long meetingDateDisponibility;

    @ColumnInfo(name = "placeItemId", index = true)
    private long placeItemId;

    public Meeting(long placeItemId, int pkMeetingId, int meetingColorTag, String meetingSubject,
                   String meetingStartHour, String meetingEndHour, String meetingPlaceName,
                   String meetingParticipantsInformations, String meetingDate, long meetingDateDisponibility) {
        this.placeItemId = placeItemId;
        this.pkMeetingId = pkMeetingId;
        this.meetingColorTag = meetingColorTag;
        this.meetingSubject = meetingSubject;
        this.meetingStartHour = meetingStartHour;
        this.meetingEndHour = meetingEndHour;
        this.meetingPlaceName = meetingPlaceName;
        this.meetingParticipantsInformations = meetingParticipantsInformations;
        this.meetingDate = meetingDate;
        this.meetingDateDisponibility = meetingDateDisponibility;
    }


    /**getters*/
    public long getPlaceItemId() {
        return placeItemId;
    }

    public int getMeetingColorTag() {
        return meetingColorTag;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public String getMeetingStartHour() {
        return meetingStartHour;
    }

    public String getMeetingEndHour() {
        return meetingEndHour;
    }

    public String getMeetingPlaceName() {
        return meetingPlaceName;
    }

    public String getMeetingParticipantsInformations() {
        return meetingParticipantsInformations;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public long getMeetingDateDisponibility() { return meetingDateDisponibility; }

    public int getPkMeetingId() {
        return pkMeetingId;
    }




    /**setters*/
    public void setPlaceItemId(long placeItemId) {
        this.placeItemId = placeItemId;
    }

    public void setPkMeetingId(int pkMeetingId) {
        this.pkMeetingId = pkMeetingId;
    }

    public void setMeetingColorTag(int meetingColorTag) {
        this.meetingColorTag = meetingColorTag;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }

    public void setMeetingStartHour(String meetingStartHour) {
        this.meetingStartHour = meetingStartHour;
    }

    public void setMeetingEndHour(String meetingEndHour) {
        this.meetingEndHour = meetingEndHour;
    }

    public void setMeetingPlaceName(String meetingPlaceName) {
        this.meetingPlaceName = meetingPlaceName;
    }

    public void setMeetingParticipantsInformations(String meetingParticipantsInformations) {
        this.meetingParticipantsInformations = meetingParticipantsInformations;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public void setMeetingDateDisponibility(long meetingDateDisponibility) {
        this.meetingDateDisponibility = meetingDateDisponibility;
    }
}
