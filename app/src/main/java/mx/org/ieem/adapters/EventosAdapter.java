package mx.org.ieem.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.models.eventos.eventos;

import static mx.org.ieem.R.layout.list_eventos;
import static mx.org.ieem.activity.eventos.EventosActivity.listapersonas;

public class EventosAdapter extends BaseAdapter
{
    Context context;                                                    // Contiene el contexto de PreguntasEncuestaActivity.
    LayoutInflater inflter;
    AppCompatActivity appCompatActivity;                    // Utilizado para poder cargar elementos de la ui.


    public EventosAdapter(Context context) {
        this.context = context;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return listapersonas.size();
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
        View view = inflter.inflate(R.layout.list_eventos, null);
        eventos ev = listapersonas.get(position);
        ImageView imagen = (ImageView) view.findViewById(R.id.imageViewEvento);
        TextView texto = (TextView) view.findViewById(R.id.textViewEvento);
        String base64String = ev.getImage();
        String base64Image = base64String.split(",")[1];
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        Drawable drawable = new BitmapDrawable(context.getResources(), decodedByte);
        imagen.setImageDrawable(drawable);
        texto.setText(ev.getNombre());
        return view;
    }
}
