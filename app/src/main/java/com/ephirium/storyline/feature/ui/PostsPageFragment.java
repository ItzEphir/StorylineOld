package com.ephirium.storyline.feature.ui;

import static com.ephirium.storyline.StorylineLog.error;
import static com.ephirium.storyline.StorylineLog.logError;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ephirium.storyline.databinding.FragmentPostsPageBinding;
import com.ephirium.storyline.feature.model.Post;
import com.ephirium.storyline.feature.presentation.PostsPageViewModel;
import com.ephirium.storyline.feature.ui.recycler.PostsAdapter;
import com.ephirium.storyline.feature.ui.recycler.PostsCallback;
import com.ephirium.storyline.feature.ui.recycler.PostsCallbackBuilder;

import org.jetbrains.annotations.Contract;

public class PostsPageFragment extends Fragment {

    private FragmentPostsPageBinding binding;

    private PostsPageViewModel viewModel;

    private final PostsAdapter adapter = new PostsAdapter(new PostsCallbackBuilder()
            .addOnClickCallback(post -> {

            })
            .addOnLikeCallback(post -> {

            }).build());

    public PostsPageFragment() {
    }

    @NonNull
    public static PostsPageFragment newInstance() {
        return new PostsPageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostsPageBinding.inflate(getLayoutInflater());
        binding.recycler.setAdapter(adapter);

        if (getActivity() != null) {
            viewModel = new ViewModelProvider(getActivity()).get(PostsPageViewModel.class);
            viewModel.postsList.observe(getActivity(), adapter::setPosts);
        }
        else{
            error("Activity does not exist", PostsPageFragment.class);
            throw new RuntimeException("Activity does not exist");
        }
        viewModel.observePosts();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}