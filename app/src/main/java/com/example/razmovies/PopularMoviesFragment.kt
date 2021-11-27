package com.example.razmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.razmovies.adapter.MoviesAdapter
import com.example.razmovies.databinding.FragmentPopularMoviesBinding
import com.example.razmovies.model.MovieViewModel


class PopularMoviesFragment : Fragment() {
private val viewModel: MovieViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPopularMoviesBinding.inflate(inflater)

        //val image = view?.findViewById<ImageView>(R.id.image)
        binding.statusImage.setOnClickListener {

         findNavController().navigate(R.id.action_popularMoviesFragment_to_detailsFragment)
        }


        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this
        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel
        binding.photosGrid.adapter = MoviesAdapter()
        return binding.root

    }
}

