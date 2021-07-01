package com.example.compose_study.ui.screen.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.compose_study.databinding.FragmentAnimationBinding
import com.example.compose_study.ui.screen.animation.sample.DotLoading

class AnimationFragment : Fragment() {

    private lateinit var animationViewModel: AnimationViewModel
    private var _binding: FragmentAnimationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        animationViewModel =
            ViewModelProvider(this).get(AnimationViewModel::class.java)

        _binding = FragmentAnimationBinding.inflate(inflater, container, false)

        binding.apply {
            composeView.setContent {
                DotLoading(modifier = Modifier
                    .size(30.dp, 30.dp)
                    .wrapContentSize(Alignment.Center)
                )
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
