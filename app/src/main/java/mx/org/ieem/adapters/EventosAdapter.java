package mx.org.ieem.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.core.content.ContextCompat;

import mx.org.ieem.R;

import static mx.org.ieem.R.layout.list_eventos;

public class EventosAdapter extends BaseAdapter
{
    Context context;                                                    // Contiene el contexto de PreguntasEncuestaActivity.
    LayoutInflater inflter;                                             // Utilizado para poder cargar elementos de la ui.


    public EventosAdapter(Context context) {
        this.context = context;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = inflter.inflate(list_eventos, null);

        Drawable imageNino = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino);                   // Contiene la imagen ninio Azul
        Drawable imageNina = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nina);                   // Contiene la imagen ninia rosa.
        Drawable imageOtra = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino_nina);
        return null;
    }
}
