package es.unican.is.appgasolineras.activities.convenios;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import es.unican.is.appgasolineras.R;
import es.unican.is.appgasolineras.activities.main.MainView;
import es.unican.is.appgasolineras.activities.toolbar.BarraHerramientasView;
import es.unican.is.appgasolineras.model.Convenio;
import es.unican.is.appgasolineras.repository.db.GasolineraDatabase;

public class ConveniosView extends AppCompatActivity implements  IConveniosContract.View {

    private IConveniosContract.Presenter presenter;
    private BarraHerramientasView barraHerramientasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convenios_view);

        // Toolbar
        barraHerramientasView = new BarraHerramientasView(findViewById(R.id.toolbar), this);

        presenter = new ConveniosPresenter(this);
        presenter.init();
    }

    /*
    Metodos referentes a la toolbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return barraHerramientasView.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return barraHerramientasView.onOptionsItemSelected(item);
    }

    /*
    Metodos referentes a IConveniosContract.View
     */
    @Override
    public GasolineraDatabase getDatabase() {
        return GasolineraDatabase.getDB(this);
    }

    @Override
    public void showConvenios(List<Convenio> convenios) {
        ConveniosArrayAdapter adapter = new ConveniosArrayAdapter(this, convenios);
        ListView list = findViewById(R.id.lvConvenios);
        list.setAdapter(adapter);
    }

    @Override
    public void showLoadError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.conveniosFalloAccesoDatos);
        builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                openMainView();
            }
        });
        builder.setNegativeButton(R.string.reintentar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                refresh();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showListaConveniosVacia() {
        TextView tv = findViewById(R.id.tvConveniosVacio);
        tv.setText(getResources().getString(R.string.conveniosListaVacia));
    }

    /*
    Metodos privados
     */

    /**
     * Abre la vista principal.
     */
    private void openMainView() {
        Intent intent = new Intent(this, MainView.class);
        startActivity(intent);
    }

    /**
     * Refresca la vista.
     */
    private void refresh() {
        this.recreate();
    }
}
