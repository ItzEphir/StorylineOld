package com.ephirium.storyline.presentation;

import static com.ephirium.common.log.LoggerKt.logError;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ephirium.data.repository.PostRepository;
import com.ephirium.data.storage.PostDto;
import com.ephirium.domain.usecase.PostUseCase;
import com.ephirium.storyline.model.Post;

import java.util.List;

public class PostsPageViewModel extends ViewModel {

    private final PostUseCase<PostDto> postUseCase = new PostUseCase<>(new PostRepository());

    private final MutableLiveData<List<Post>> mutPostsList = new MutableLiveData<>();
    public final LiveData<List<Post>> postsList = mutPostsList;

    public void observePosts() {
        postUseCase.observePosts(value -> mutPostsList.postValue(PostsMapper.convert(value)),
                exception -> logError(exception.toString()));
    }
}