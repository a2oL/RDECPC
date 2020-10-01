package mx.org.ieem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.models.eventos.trdd_concurso_o_evento;

import static mx.org.ieem.RESTful.AsyncEventosConcursos.eventosServidor;


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
        return eventosServidor.size();
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
        trdd_concurso_o_evento eventoConcurso = eventosServidor.get(position);
        ImageView imagen = (ImageView) view.findViewById(R.id.imageViewEvento);
        TextView texto = (TextView) view.findViewById(R.id.textViewEvento);
        String imageUrl = eventoConcurso.getUrl_image();
        Picasso.get().load(imageUrl).into(imagen);
        texto.setText(eventoConcurso.getNombre());
        return view;
    }


    public void CargarBase64()
    {
        /* Metodo para cargar imagen base 64
        String base64String = ev.getImage();
        String base64Image = base64String.split(",")[1];
        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        Drawable drawable = new BitmapDrawable(context.getResources(), decodedByte);
        */
    }
}
