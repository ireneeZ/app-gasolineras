package es.unican.is.appgasolineras.activities.prefs;

import android.location.Location;
import android.os.Build;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import es.unican.is.appgasolineras.common.GasolineraUbicacionComparator;
import es.unican.is.appgasolineras.model.Gasolinera;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class GasolineraUbicacionComparatorTestIT {

    private GasolineraUbicacionComparator sut;

    @Before
    public void setUp() {
        //Creamos la ubicacion actual
        Location locActual = new Location("");
        locActual.setLatitude(33.46472);
        locActual.setLongitude(-3.80444);
        sut = new GasolineraUbicacionComparator(locActual);
    }

    @Test
    public void primeraMasCercaTest() {

        //Creamos la primera gasolinera e indicamos su ubicación.
        Gasolinera gasolinera1 = new Gasolinera();
        gasolinera1.setLatitud("43,46472");
        gasolinera1.setLongitud("-3,80444");

        //Creamos la segunda gasolinera e indicamos su ubicación.
        Gasolinera gasolinera2 = new Gasolinera();
        gasolinera2.setLatitud("23,68477");
        gasolinera2.setLongitud("-15,95798");





        //Debería devolver "-1" puesto que la gasolinera 1 está más cerca.
        Assert.assertEquals(-1, sut.compare(gasolinera1, gasolinera2));
    }

    @Test
    public void segundaMasCercaTest() {

        //Creamos la primera gasolinera e indicamos su ubicación.
        Gasolinera gasolinera1 = new Gasolinera();
        gasolinera1.setLatitud("23,68477");
        gasolinera1.setLongitud("-15,95798");

        //Creamos la segunda gasolinera e indicamos su ubicación.
        Gasolinera gasolinera2 = new Gasolinera();
        gasolinera2.setLatitud("43,46472");
        gasolinera2.setLongitud("-3,80444");

        //Debería devolver "1" puesto que la gasolinera 2 está más cerca.
        Assert.assertEquals(1, sut.compare(gasolinera1, gasolinera2));
    }

    @Test
    public void dosMismaDistanciaTest() {

        //Creamos la primera gasolinera e indicamos su ubicación.
        Gasolinera gasolinera1 = new Gasolinera();
        gasolinera1.setLatitud("23,68477");
        gasolinera1.setLongitud("-15,95798");


        //Creamos la segunda gasolinera e indicamos su ubicación.
        Gasolinera gasolinera2 = new Gasolinera();
        gasolinera2.setLatitud("23,68477");
        gasolinera2.setLongitud("-15,95798");

        //Debería devolver "0" porque están las dos a la msima distancia
        Assert.assertEquals(0, sut.compare(gasolinera1, gasolinera2));
    }

}
