package co.ke.biofit.myrestaurants.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ke.biofit.myrestaurants.R;
import co.ke.biofit.myrestaurants.adapters.RestaurantPagerAdapter;
import co.ke.biofit.myrestaurants.models.Business;
import co.ke.biofit.myrestaurants.models.YelpBusinessesSearchResponse;
import retrofit2.Call;


public class RestaurantDetailActivity extends AppCompatActivity {
    public static final String TAG = RestaurantDetailActivity.class.getSimpleName();
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private RestaurantPagerAdapter adapterViewPager;
    List<Business> mRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);

        mRestaurants = Parcels.unwrap(getIntent().getParcelableExtra("restaurants"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new RestaurantPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mRestaurants);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);


    }

    public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {
        Log.e(TAG, "onFailure: ", t);
    }
}
