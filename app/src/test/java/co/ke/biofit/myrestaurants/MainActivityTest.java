package co.ke.biofit.myrestaurants;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

//import static org.junit.Assert.assertTrue;
import co.ke.biofit.myrestaurants.ui.MainActivity;
import co.ke.biofit.myrestaurants.ui.RestaurantListActivity;

import static junit.framework.TestCase.assertTrue;


@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

//    @BeforeClass
//    public static void setupClass(){
//        throw new RuntimeException ("Test run error");
//    }
    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);

    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
        assertTrue("MyRestaurants".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(activity, RestaurantsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
