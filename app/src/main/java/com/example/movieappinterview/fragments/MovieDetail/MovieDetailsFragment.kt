package com.example.movieappinterview.fragments.MovieDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieappinterview.R

import com.example.movieappinterview.api.MovieDbApi
import com.example.movieappinterview.api.MovieDbInterface
import com.example.movieappinterview.model.movie

import com.example.movieappinterview.viewmodel.MovieDetailViewModel
import kotlinx.android.synthetic.main.fragment_movie_details.*
import java.text.NumberFormat
import java.util.*


class MovieDetailsFragment : Fragment() {

    private lateinit var viewModel: MovieDetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

}