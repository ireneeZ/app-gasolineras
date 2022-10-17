package es.unican.is.appgasolineras.activities.historialRepostajes;


import static es.unican.is.appgasolineras.repository.db.GasolineraDatabase.getDB;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import es.unican.is.appgasolineras.common.Callback;
import es.unican.is.appgasolineras.model.Gasolinera;
import es.unican.is.appgasolineras.model.Repostaje;
import es.unican.is.appgasolineras.repository.IGasolinerasRepository;
import es.unican.is.appgasolineras.repository.db.GasolineraDatabase;
import es.unican.is.appgasolineras.repository.db.RepostajeDao;
import es.unican.is.appgasolineras.repository.db.RepostajeDao_Impl;

public class HistorialRepostajesPresenter implements IHistorialRepostajesContract.Presenter{

    private final IHistorialRepostajesContract.View view;

    List<Repostaje> shownRepostajes;


    public HistorialRepostajesPresenter(IHistorialRepostajesContract.View view) {
        this.view = view;
    }

    @Override
    public void init() {
        final GasolineraDatabase db = view.getGasolineraDb();
        final RepostajeDao repDao = db.repostajeDao();
        /*
        Repostaje rep = new Repostaje();
        rep.setId(0);
        rep.setFechaRepostaje("10/10/2022");
        rep.setPrecio("55.83");
        rep.setLocalizacion("mi casa");
        rep.setLitros("26");
        db.repostajeDao().insertRepostaje(rep);*/
        shownRepostajes = db.repostajeDao().getAll();

        if(shownRepostajes == null) {
            view.showLoadError();
        }else {
            view.showHistorialRepostajes(shownRepostajes);
        }

    }

    @Override
    public void onHomeClicked() {
        view.openMainView();

    }

    @Override
    public void onAceptarClicked() {
        view.openMainView();
    }

    @Override
    public void onReintentarClicked() {
        init();
    }
}
