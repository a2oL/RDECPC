package mx.org.ieem.activity.eventos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import mx.org.ieem.R;
import mx.org.ieem.activity.main.MainActivity;
import mx.org.ieem.adapters.EventosAdapter;

import static mx.org.ieem.RESTful.AsyncEventosConcursos.eventosServidor;

public class EventosActivity extends AppCompatActivity
{
    EventosAdapter customAdapter;
    ListView listEventos;
    Button atras;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        atras = (Button) findViewById(R.id.button_regresar_eventos);

        customAdapter = new EventosAdapter(this);
        listEventos = (ListView)findViewById(R.id.listView_eventos);
        listEventos.setAdapter(customAdapter);

        listEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (eventosServidor.get(position).getId_estatus_coneve() == 2)
                {
                    Toast.makeText(getApplicationContext(), "El evento deseado ha expirado intenta con otro", Toast.LENGTH_LONG).show();
                }else
                {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(eventosServidor.get(position).getUrl()));
                    startActivity(browserIntent);
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent =  new Intent(v.getContext(), MainActivity.class);
                startActivity(browserIntent);
            }
        });
    }


}
