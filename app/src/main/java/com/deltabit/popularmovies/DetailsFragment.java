package com.deltabit.popularmovies;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deltabit.popularmovies.databinding.FragmentMovieDetailsBinding;
import com.deltabit.popularmovies.model.MovieModel;

import org.parceler.Parcels;


public class DetailsFragment extends Fragment {

    private static final String LOG_TAG = DetailsFragment.class.getSimpleName();

    public DetailsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMovieDetailsBinding mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false);
        View view = mBinding.getRoot();

        MovieModel mMovieModel = Parcels.unwrap(
                this.getArguments().getParcelable(DetailActivity.MOVIE_MODEL_BUNDLE));

        mBinding.releaseDate.setText(mMovieModel.getReleaseDate());
        mBinding.materialRatingBarMovieDetail.setRating(mMovieModel.getVoteAverage().floatValue() / 2f);
        mBinding.textviewPlotMoviedetails.setText(mMovieModel.getOverview());

        return view;
    }

}
