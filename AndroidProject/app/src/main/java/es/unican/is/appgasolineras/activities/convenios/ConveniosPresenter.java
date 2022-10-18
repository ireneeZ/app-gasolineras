package es.unican.is.appgasolineras.activities.convenios;

import android.database.sqlite.SQLiteException;

import java.util.List;

import es.unican.is.appgasolineras.model.Convenio;
import es.unican.is.appgasolineras.repository.db.ConvenioDao;
import es.unican.is.appgasolineras.repository.db.GasolineraDatabase;

public class ConveniosPresenter implements IConveniosContract.Presenter {

    private final IConveniosContract.View view;
    private List<Convenio> shownConvenios;

    public ConveniosPresenter(IConveniosContract.View view) {
        this.view = view;
    }

    @Override
    public void init() {
        final GasolineraDatabase db = view.getDatabase();
        final ConvenioDao conveniosDao = db.convenioDao();
        // Ejecutar solo primera vez que se lanza la app
        //insertaDatosTemp(conveniosDao);

        List<Convenio> data = null;

        // Fallo en el acceso a datos
        try {
            data = conveniosDao.getAll();
        } catch (SQLiteException e) {
            view.showLoadError();
        }

        if (data.size() != 0) {
            // Caso exito
            view.showConvenios(data);
            shownConvenios = data;
        } else {
            // No existen convenios para mostrar
            view.showListaConveniosVacia();
            shownConvenios = null;
        }
    }

    private void insertaDatosTemp(ConvenioDao conveniosDao) {
        Convenio c1 = new Convenio();
        c1.setMarca("Campsa");
        c1.setDescuento(20);
        Convenio c2 = new Convenio();
        c2.setMarca("Galp");
        c2.setDescuento(5);
        conveniosDao.insertConvenio(c1);
        conveniosDao.insertConvenio(c2);
    }
}
