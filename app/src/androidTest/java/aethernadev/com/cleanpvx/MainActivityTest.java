package aethernadev.com.cleanpvx;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.aethernadev.main.MainPresenter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;


/**
 * Created by Marta on 09/11/2015.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity_> activityTestRule = new ActivityTestRule<>(MainActivity_.class);

    @Mock
    private MainPresenter presenter;

    @Test
    public void testShouldBeOk() {
        Espresso.onView(ViewMatchers.withId(R.id.main_searchResult)).perform(ViewActions.click());
        Mockito.verify(presenter, times(1)).findProduct("");

    }
}
