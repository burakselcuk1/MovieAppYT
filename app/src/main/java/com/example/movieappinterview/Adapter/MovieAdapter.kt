package com.example.movieappinterview.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappinterview.R
import com.example.movieappinterview.Util.Constans.Companion.POSTER_MAIN_URL
import com.example.movieappinterview.model.Result
import com.example.movieappinterview.model.movie
import kotlinx.android.synthetic.main.single_movie_item.view.*


class MovieAdapter( val dataSet: movie) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView
        val movieName: TextView
        val posterImage: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            description = view.findViewById(R.id.movieDescription)
            movieName = view.findViewById(R.id.movieName)
            posterImage = view.findViewById(R.id.movieImage)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_movie_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        val result: Result = dataSet.results.get(position)

        viewHolder.description.text = result.overview
        viewHolder.movieName.text = result.original_title
        val url =POSTER_MAIN_URL +  dataSet.results.get(position).poster_path


        viewHolder.itemView.apply {
            Glide.with(this).load(url).into(viewHolder.itemView.movieImage)
        }

        viewHolder.itemView.setOnClickListener {

           val bundle = Bundle()
           bundle.putString("movieId", ""+result.id)

            //First method pass data throught arguments
          /*
           val fragment = MovieDetailsFragment()
           fragment.arguments = bundle
           val action = DashboardFragmentDirections.actionDashboardFragmentToMovieDetailsFragment()
           Navigation.findNavController().navigate(action, bundle)
        */

            val navigationController = Navigation.findNavController(viewHolder.itemView)
            navigationController.navigate(R.id.movieDetailsFragment,bundle!!)

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.results.size



}
