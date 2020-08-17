package mx.org.ieem.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;


import java.util.ArrayList;

import mx.org.ieem.R;
import mx.org.ieem.data.sqllite.DataBaseAppRed;

public class PrimeraCiudadanoAdapter extends BaseAdapter {

    Context context;
    String[] questionsList;
    LayoutInflater inflter;

    RadioGroup rgp;
    Drawable image1,image2,image3;
    DataBaseAppRed dataSource;
    Cursor dataCursor;

    public static ArrayList<String> selectedIdAnios;                 // Contiene las respuestas seleccionadas.
    public static ArrayList<String> selectedIdPreguntas;                  // Contiene los indicadores de las respuestas.
    public static ArrayList<String> selectedIdRespuesta;                // Contiene el id de la respuesta seleccionada.
    public static ArrayList<String> selectedIdEstatusRespuesta;                    // Contiene el estatus de las respuestas seleccionadas.
    public static ArrayList<String> selectedRespuesta;

    String[] stringArrayIdAnios;                                     // Contiene las respuestas de las preguntas.
    String[] stringArrayIdPreguntas;                              // Contiene el estatus de las respuestas de las preguntas.
    String[] stringArrayIdRespuesta;                                   // Contiene el id de las respuestas de las preguntas.
    String[] stringArrayIdEstatusRespuesta;                          // Contiene el indicador de las respuestas de las preguntas.
    String[] stringArrayRespuesta;

    public final boolean[][] isSelec = new boolean[50][50];

    public PrimeraCiudadanoAdapter(Context applicationContext) {
        this.context = applicationContext;
        this.questionsList = Preguntas();

        selectedIdAnios = new ArrayList<>();
        selectedIdPreguntas = new ArrayList<>();
        selectedIdRespuesta  = new ArrayList<>();
        selectedIdEstatusRespuesta = new ArrayList<>();
        selectedRespuesta = new ArrayList<>();

        for(int r = 0; r< 50;r++)
        {
            for(int y = 0; y< 50; y++){
                isSelec[r][y]=false;
            }
        }

        for (int i = 0; i < questionsList.length; i++) {
            selectedIdAnios.add("Not Attempted");
            selectedIdPreguntas.add("Not Attempted");
            selectedIdRespuesta.add("Not Attempted");
            selectedIdEstatusRespuesta.add("Not Attempted");
            selectedRespuesta.add("Not Attempted");
        }
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return questionsList.length;
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
    public View getView(final int p, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.list_preguntas_ciudadano, null);
        TextView question = (TextView) view.findViewById(R.id.pregunta_preguntas_ciudadano);

        final RadioButton[] rb = new RadioButton[8];
        rgp= (RadioGroup) view.findViewById(R.id.radioGroupCiudadano);
        rgp.setOrientation(RadioGroup.HORIZONTAL);

        Respuestas(questionsList[p]);

        image1  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_cara_naranja);
        image2  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_cara_verde);
        image3  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino_nina);
        int h = image2.getIntrinsicHeight();
        int w = image2.getIntrinsicWidth();
        image2.setBounds( 0, 0, w, h );
        int hh = image1.getIntrinsicHeight();
        int ww = image1.getIntrinsicWidth();
        image1.setBounds( 0, 0, ww, hh );


        for (int i = 0; i < stringArrayRespuesta.length ; i++) {

            rb[i]  = new RadioButton(view.getContext());
            rb[i].setId(View.generateViewId());
            rb[i].setText(stringArrayRespuesta[i]);
            rb[i].setGravity(View.TEXT_ALIGNMENT_CENTER);
            if(stringArrayIdEstatusRespuesta[i].equals("2"))
            {
                rb[i].setCompoundDrawables(null,null,image2,null);
            }else{
                rb[i].setCompoundDrawables(null,null,image1,null);
            }
            rb[i].setTextColor(0xffbdbdbd);
            final int finalI = i;
            rb[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        for(int l = 0; l<50; l++){
                            isSelec[p][l]=false;
                        }
                        selectedIdAnios.set(p,stringArrayIdAnios[finalI]);
                        selectedIdPreguntas.set(p,questionsList[p]);
                        selectedIdRespuesta.set(p,stringArrayIdRespuesta[finalI]);
                        selectedIdEstatusRespuesta.set(p,stringArrayIdEstatusRespuesta[finalI]);
                        selectedRespuesta.set(p,stringArrayRespuesta[finalI]);
                        isSelec[p][finalI] = true;
                    }
                }
            });
            rb[i].setChecked(isSelec[p][i]);
            rgp.addView(rb[i]);
        }


        question.setText(questionsList[p]);
        return view;
    }

    public String[] Preguntas()
    { // Preguntas (TOP)
        dataSource = new DataBaseAppRed(context);
        dataCursor=dataSource.getPreguntasCiudadanometroBD();

        String[] stringArrayAuxiliarPreguntas = new String[dataCursor.getCount()];           // Auxiliar que contiene las preguntas de la bd.
        int intAuxiliar2 = 0;                                                                 // Auxiliar para posicionar los elementos dentro del vetor de Strings.

        if (dataCursor.getCount() > 0)
        { // Si existen preguntas en la bd (TOP)
            while (dataCursor.moveToNext())
            { // Se guardan en preguntas[] (TOP)
                stringArrayAuxiliarPreguntas[intAuxiliar2] = dataCursor.getString(1);
                intAuxiliar2++;
            } // Se guardan en preguntas[] (BOTTOM)
        } // Si existen preguntas en la bd (BOTTOM)

        return stringArrayAuxiliarPreguntas;
    } // Preguntas (BOTTOM)

    /**
     * Método que regresa las preguntas que estan asociadas a una pregunta.
     */
    public void Respuestas(String pos)
    { // Respuestas (TOP)
        dataSource = new DataBaseAppRed(context);
        dataCursor=dataSource.getRespuestasCiudadanometroBD(pos);

        String[] stringAuxiliarIdAnios = new String[dataCursor.getCount()];               // Auxiliar que contiene las respues que se encuentran en la bd.
        String[] stringAuxiliarIdPreguntas = new String[dataCursor.getCount()];                  // Auxiliar que contiene el estatus de las respuestas de la bd.
        String[] stringAuxiliarIdRespuesta = new String[dataCursor.getCount()];              // Auxiliar que contiene el id de la respuesta que esta en la bd.
        String[] stringAuxiliarIdEstatusRespuesta = new String[dataCursor.getCount()];                // Auxiliar que contiene los indicadores de las respuestas de la bd.
        String[] stringAuxiliarRespuesta = new String[dataCursor.getCount()];
        int intAuxiliar = 0;                                                                 // Auxiliar para posicionar los elementos dentro del vetor de Strings.

        if (dataCursor.getCount() > 0)
        { // Si existen respuestas asociadas a la pregunta (TOP)
            while (dataCursor.moveToNext())
            { // Se guardan los datos de la bd en los Array String auxiliares (TOP)
                stringAuxiliarIdAnios[intAuxiliar] = dataCursor.getString(0);
                stringAuxiliarIdPreguntas[intAuxiliar] = dataCursor.getString(1);
                stringAuxiliarIdRespuesta[intAuxiliar] = dataCursor.getString(2);
                stringAuxiliarIdEstatusRespuesta[intAuxiliar] = dataCursor.getString(3);
                stringAuxiliarRespuesta[intAuxiliar] = dataCursor.getString(4);
                intAuxiliar++;
            } // Se guardan los datos de la bd en los Array String auxiliares (BOTTOM)
        } // Si existen respuestas asociadas a la pregunta (BOTTOM)

        // Regresando a las variables globales los valores de las respuestas encontrados (TOP)
        this.stringArrayIdAnios = stringAuxiliarIdAnios;
        this.stringArrayIdPreguntas = stringAuxiliarIdPreguntas;
        this.stringArrayIdRespuesta = stringAuxiliarIdRespuesta;
        this.stringArrayIdEstatusRespuesta = stringAuxiliarIdEstatusRespuesta;
        this.stringArrayRespuesta = stringAuxiliarRespuesta;
        // Regresando a las variables globales los valores de las respuestas encontrados (BOTTOM)
    } // Respuestas (BOTTOM)
}
