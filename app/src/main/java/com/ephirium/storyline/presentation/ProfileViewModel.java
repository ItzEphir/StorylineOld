package com.ephirium.storyline.presentation;

import static com.ephirium.common.log.LoggerKt.logError;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ephirium.common.delegate.DelegateItem;
import com.ephirium.data.repository.ProfileRepository;
import com.ephirium.data.repository.UserRepository;
import com.ephirium.data.storage.PostDto;
import com.ephirium.data.storage.UserDto;
import com.ephirium.domain.usecase.ProfileUseCase;

import java.util.List;

public class ProfileViewModel extends ViewModel {

    private ProfileUseCase<UserDto, PostDto> profileUseCase;

    private final MutableLiveData<List<DelegateItem>> mutDelegates = new MutableLiveData<>();
    public final LiveData<List<DelegateItem>> delegates = mutDelegates;

    public void observeDelegates(UserDto user){
        setProfile(user);

        profileUseCase.observePosts(value -> {
            mutDelegates.postValue(DelegateItemMapper.convert(value));
        }, exception -> {
            logError(exception.toString());
        });

    }

    private void setProfile(UserDto user){
        profileUseCase = new ProfileUseCase<>(user, new ProfileRepository(user, new UserRepository()));
    }
}
