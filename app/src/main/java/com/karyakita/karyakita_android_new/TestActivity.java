package com.karyakita.karyakita_android_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.karyakita.karyakita_android_new.activity.MainActivity;
import com.karyakita.karyakita_android_new.adapter.MovieAdapter;
import com.karyakita.karyakita_android_new.base_class_interface.BaseModel;
import com.karyakita.karyakita_android_new.base_class_interface.IMainView;
import com.karyakita.karyakita_android_new.model.MovieResponse;
import com.karyakita.karyakita_android_new.presenter.TestPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements IMainView {
    @BindView(R.id.rvMovies)
    RecyclerView rvMovies;

    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    TestPresenter testPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        ButterKnife.bind(this);

        //rvMovies = (RecyclerView) findViewById(R.id.rvMovies);

        setupMVP();
        setupViews();
        getMovieList();
    }

    private void setupMVP() {
        testPresenter = new TestPresenter(this);
    }

    private void setupViews(){
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getMovieList() {
        testPresenter.get();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(TestActivity.this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void display(MovieResponse movieResponse) {
        if(movieResponse!=null) {
            Log.d(TAG,movieResponse.getResults().get(1).getTitle());
            adapter = new MovieAdapter.MoviesAdapter(movieResponse.getResults(), TestActivity.this);
            rvMovies.setAdapter(adapter);
        }else{
            Log.d(TAG,"Movies response null");
        }   
    }

    @Override
    public void displayError(String e) {

        showToast(e);

    }
}
