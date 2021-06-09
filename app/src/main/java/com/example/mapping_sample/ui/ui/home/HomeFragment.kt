package com.example.mapping_sample.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.WindowRecomposerFactory
import androidx.compose.ui.platform.compositionContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.example.mapping_sample.R
import com.example.mapping_sample.databinding.FragmentHomeBinding
import java.util.concurrent.atomic.AtomicReference

/**
 * FragmentとComposeの共存
 * https://github.com/takusan23/BottomFragmentComposeView
 *
 */
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @InternalComposeUiApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        ViewTreeLifecycleOwner.set(binding.composeView, binding.root.findViewTreeLifecycleOwner())

//        binding.composeView.apply {
//            ViewTreeLifecycleOwner.set(this, viewLifecycleOwner)
//            val newRecomposer = AtomicReference(WindowRecomposerFactory.LifecycleAware).get().createRecomposer(binding.root)
//            compositionContext = newRecomposer
//
//            setContent {
//                Text(text = "Hello world.")
//            }
//        }
//        ViewTreeLifecycleOwner.set(binding.root, viewLifecycleOwner)
//
//        binding.composeView.setContent {
//            Text(text = "Hello world.")
//        }

//        binding.root.findViewById<ComposeView>(R.id.composeView).setContent {
//            Text(text = "Hello world.")
//        }
        return root.apply {
            ViewTreeLifecycleOwner.set(this, viewLifecycleOwner)
            val newRecomposer = AtomicReference(WindowRecomposerFactory.LifecycleAware).get().createRecomposer(rootView)
            compositionContext = newRecomposer
            findViewById<ComposeView>(R.id.composeView).setContent {
                Text(text = "Hello world.")
            }
        }
//        return ComposeView(requireContext()).apply {
//
//            ViewTreeLifecycleOwner.set(this, viewLifecycleOwner)
//            val newRecomposer = AtomicReference(WindowRecomposerFactory.LifecycleAware).get().createRecomposer(this)
//            compositionContext = newRecomposer
//
//            setContent {
//                Text(
//                    text = "BottomSheetDialogFragment + ComposeView",
//                    modifier = Modifier.padding(10.dp)
//                )
//            }
//        }

//        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}