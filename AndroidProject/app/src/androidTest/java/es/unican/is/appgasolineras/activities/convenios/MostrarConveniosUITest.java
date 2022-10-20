package es.unican.is.appgasolineras.activities.convenios;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.unican.is.appgasolineras.R;
import es.unican.is.appgasolineras.activities.main.MainView;
import es.unican.is.appgasolineras.repository.rest.GasolinerasServiceConstants;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.CoreMatchers.not;

import static es.unican.is.appgasolineras.utils.Matchers.hasElements;

@RunWith(AndroidJUnit4.class)
public class MostrarConveniosUITest {
    //Pruebas de interfaz realizadas para la muestra de convenios considerando que la base de datos está vacía
    @Rule
    public ActivityScenarioRule<MainView> activityRule =
            new ActivityScenarioRule(MainView.class);

    @BeforeClass
    public static void setUp() {
        GasolinerasServiceConstants.setStaticURL();
    }

    @AfterClass
    public static void clean() {
        GasolinerasServiceConstants.setMinecoURL();
    }

    @Test
    public void testConvenioVacioVolverAtras() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(anyOf(withText("Convenios"), withId(R.id.menuConvenios))).perform(click());
        onView(withId(R.id.lvConvenios)).check(matches(not(hasElements())));
        pressBack();
        onView(withId(R.id.lvGasolineras)).check(matches(hasElements()));
    }

    @Test
    public void testConvenioVacioVolverBotonInicio() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());
        onView(anyOf(withText("Convenios"), withId(R.id.menuConvenios))).perform(click());
        onView(withId(R.id.lvConvenios)).check(matches(not(hasElements())));
        onView(withId(R.id.ivLogo)).perform(click());
        onView(withId(R.id.lvGasolineras)).check(matches(isDisplayed()));
    }
}
