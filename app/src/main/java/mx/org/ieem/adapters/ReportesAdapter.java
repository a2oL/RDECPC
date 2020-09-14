package mx.org.ieem.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.models.eventos.trdd_concurso_o_evento;
import mx.org.ieem.data.sqllite.models.reportes.trdd_reporte;

import static mx.org.ieem.RESTful.AsyncEventosConcursos.eventosServidor;
import static mx.org.ieem.RESTful.AsyncReportes.reportesaMostrar;

public class ReportesAdapter extends BaseAdapter {

    private Context context;
    LayoutInflater inflter;

    public ReportesAdapter(Context context) {
        this.context = context;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return reportesaMostrar.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflter.inflate(R.layout.list_reportes, null);
        trdd_reporte reporteServidor = reportesaMostrar.get(position);
        TextView nombre = (TextView) view.findViewById(R.id.textView_Nombre_Reporte);
        TextView descripcion = (TextView) view.findViewById(R.id.textView_Descripcion_Reporte);
        nombre.setText(reporteServidor.getNombre());
        descripcion.setText(reporteServidor.getDescripcion());
        return view;
    }
}
