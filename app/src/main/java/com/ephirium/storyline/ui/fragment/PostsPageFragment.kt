package com.ephirium.storyline.ui.fragment

import by.kirich1409.viewbindingdelegate.viewBinding
import com.ephirium.storyline.R

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import com.ephirium.common.log.log

import com.ephirium.storyline.databinding.FragmentPostsPageBinding;
import com.ephirium.storyline.presentation.PostsPageViewModel;
import com.ephirium.storyline.ui.recycler.post.PostAdapter;
import com.ephirium.storyline.ui.recycler.post.callback.PostCallback;

class PostsPageFragment : Fragment(R.layout.fragment_posts_page) {

    private val binding: FragmentPostsPageBinding by viewBinding()

    private val viewModel: PostsPageViewModel by lazy { ViewModelProvider(requireActivity())[PostsPageViewModel::class.java] }

    private val adapter = PostAdapter(PostCallback {

    }.addOnMoveCallback { from, to ->
        run {

        }
    }.addOnSwipeCallback { direction, position ->
        run {

        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter

        log("PostPageFragment")

        viewModel.postsList.observe(requireActivity(), adapter::setPosts)

        if (savedInstanceState != null) viewModel.observePosts()
    }
}