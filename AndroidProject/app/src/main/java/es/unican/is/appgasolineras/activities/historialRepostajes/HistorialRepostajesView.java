package es.unican.is.appgasolineras.activities.historialRepostajes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import es.unican.is.appgasolineras.R;
import es.unican.is.appgasolineras.activities.main.GasolinerasArrayAdapter;
import es.unican.is.appgasolineras.activities.main.IMainContract;
import es.unican.is.appgasolineras.activities.main.MainPresenter;
import es.unican.is.appgasolineras.activities.toolbar.BarraHerramientasView;
import es.unican.is.appgasolineras.model.Repostaje;
import es.unican.is.appgasolineras.repository.db.GasolineraDatabase;

public class HistorialRepostajesView extends AppCompatActivity  implements IHistorialRepostajesContract.View{

    private BarraHerramientasView barraHerramientasView;
    private IHistorialRepostajesContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_repostajes_view);

        // Toolbar
        barraHerramientasView = new BarraHerramientasView(findViewById(R.id.toolbar), this);

        // Temporal
        //TextView tv = findViewById(R.id.tvHistorialRepostajeMessage);
        //tv.setText("HISTORIAL REPOSTAJES");

        presenter = new HistorialRepostajesPresenter(this);
        presenter.init();
        this.init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return barraHerramientasView.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return barraHerramientasView.onOptionsItemSelected(item);
    }

    @Override
    public void init() {
        //Vacio
    }

    @Override
    public void openMainView() {

    }

    @Override
    public void showLoadError() {

    }

    public GasolineraDatabase getGasolineraDb() {
        return GasolineraDatabase.getDB(this);
    }

    @Override
    public void showHistorialRepostajes(List<Repostaje> historialRepostajes) {
        HistorialRepostajesArrayAdapter adapter = new HistorialRepostajesArrayAdapter(this, historialRepostajes);
        ListView list = findViewById(R.id.lvHistoricoGasolineras);
        list.setAdapter(adapter);
    }
}
