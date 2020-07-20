package com.lamzone.mareunion.injections;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lamzone.mareunion.repository.MeetingDataRepository;
import com.lamzone.mareunion.repository.PlaceItemDataRepository;
import com.lamzone.mareunion.view.viewModel.MeetingViewModel;

import java.util.concurrent.Executor;

public class MeetingViewModelFactory implements ViewModelProvider.Factory {
    /**
     * add private final DataRepo(2)+executor for asyncTask
     */

    private final MeetingDataRepository meetingDataSource;
    private final PlaceItemDataRepository placeItemDataSource;
    private final Executor executor;

    /**
     * create constructor(same as MeetingViewModel
     */
    public MeetingViewModelFactory(MeetingDataRepository meetingDataSource, PlaceItemDataRepository placeItemDataSource, Executor executor) {
        this.meetingDataSource = meetingDataSource;
        this.placeItemDataSource = placeItemDataSource;
        this.executor = executor;
    }

    /**
     * implement method create class T, assignable from MeetingViewModel when implements (not extends!) ViewModelProvider.Factory  or ViewModelProviders with new Factory = (?)
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MeetingViewModel.class)) {
            return (T) new MeetingViewModel(meetingDataSource, placeItemDataSource, executor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
