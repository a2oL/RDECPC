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

    Context context;                                                      // Contexto del que es llamado el adaptador en este caso desde PrimeraCiudadanoActivity.
    String[] questionsList;                                               // Contiene la lista de preguntas que llegan del servidor.
    LayoutInflater inflter;                                               // Layout que hospedara las preguntas y sus respuestas.

    RadioGroup rgp;                                                       // Contiene el radiogroup de el layout que mostrara las respuestas.
    Drawable image1,image2,image3;                                        // Image1 contiene el drawable de carita naranja, Image2 contiene el drawable de carita verde, image3 Contiene el drawable de carita Morada no utilizada por el momento.
    DataBaseAppRed dataSource;                                            // Instancia de la base de datos.
    Cursor dataCursor;                                                    // Cursor para poder obtener registros de la bd.

    public static ArrayList<String> selectedIdAnios;                      // Contiene las respuestas seleccionadas.
    public static ArrayList<String> selectedIdPreguntas;                  // COntiene el id de la pregunta seleccionada
    public static ArrayList<String> selectedIdRespuesta;                  // Contiene el id de la respuesta seleccionada.
    public static ArrayList<String> selectedIdEstatusRespuesta;           // Contiene el estatus de las respuestas seleccionadas.
    public static ArrayList<String> selectedRespuesta;                    // Contiene la respuesta seleccionada por el usuario.

    String[] stringArrayIdAnios;                                          // Contiene las respuestas de las preguntas.
    String[] stringArrayIdPreguntas;                                      // Contiene el estatus de las respuestas de las preguntas.
    String[] stringArrayIdRespuesta;                                      // Contiene el id de las respuestas de las preguntas.
    String[] stringArrayIdEstatusRespuesta;                               // Contiene el indicador de las respuestas de las preguntas.
    String[] stringArrayRespuesta;                                        // COntiene las respuestas seleccionadas.

    public final boolean[][] isSelec = new boolean[50][50];

    public PrimeraCiudadanoAdapter(Context applicationContext)
    {
        // Inicializacion de las variables (TOP)
        this.context = applicationContext;
        this.questionsList = Preguntas();
        selectedIdAnios = new ArrayList<>();
        selectedIdPreguntas = new ArrayList<>();
        selectedIdRespuesta  = new ArrayList<>();
        selectedIdEstatusRespuesta = new ArrayList<>();
        selectedRespuesta = new ArrayList<>();

        for(int filas = 0 ; filas < 50 ; filas++)
        {// Para repintar las respuestas seleccionadas cuando se haga scroll en la app (TOP).
            for(int columnas = 0 ; columnas < 50 ; columnas++){
                isSelec[filas][columnas] = false;
            }
        }// Para repintar las respuestas seleccionadas cuando se haga scroll en la app (BOTTOM).

        for (int i = 0; i < questionsList.length; i++)
        {// Para determinar si una pregunta fue respondida o no (TOP).
            selectedIdAnios.add("Not Attempted");
            selectedIdPreguntas.add("Not Attempted");
            selectedIdRespuesta.add("Not Attempted");
            selectedIdEstatusRespuesta.add("Not Attempted");
            selectedRespuesta.add("Not Attempted");
        }// Para determinar si una pregunta fue respondida o no (BOTTOM).
        inflter = (LayoutInflater.from(applicationContext));
        // Inicializacion de las variables (BOTTOM)
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
    public View getView(final int p, View view, ViewGroup parent)
    {// Colocar todas las preguntas con sus respectivas respuestas (TOP).
        view = inflter.inflate(R.layout.list_preguntas_ciudadano, null);                                    // Inicializacion del layout que mostrara las preguntas.
        TextView question = (TextView) view.findViewById(R.id.pregunta_preguntas_ciudadano);                     // Elemento del layout que mostrara las preguntas.
        final RadioButton[] rb = new RadioButton[questionsList.length];                                          // Radio buttons generados para las respuestas de cada pregunta
        rgp= (RadioGroup) view.findViewById(R.id.radioGroupCiudadano);                                           // Inicializacion del radio group que contendra las respuestas de las preguntas
        rgp.setOrientation(RadioGroup.HORIZONTAL);                                                               // Determina la horientzaion del radio group.

        Respuestas(questionsList[p]);                                                                            // Obtiene las respuestas de la pregunta seleccionada.

        // Inicializacion de las variables (TOP)
        image1  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_cara_naranja);
        image2  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_cara_verde);
        image3  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino_nina);
        int h = image2.getIntrinsicHeight();
        int w = image2.getIntrinsicWidth();
        image2.setBounds( 0, 0, w, h );
        int hh = image1.getIntrinsicHeight();
        int ww = image1.getIntrinsicWidth();
        image1.setBounds( 0, 0, ww, hh );
        // Inicializacion de las variables (BOTTOM)
        for (int i = 0; i < stringArrayRespuesta.length ; i++)                                              // i representa el numero de iteraciones que se dara para cada respuesta.
        {// Colocacion de las respuestas para cada pregunta (TOP).
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
        } // Colocacion de las respuestas para cada pregunta (BOTTOM).
        question.setText(questionsList[p]);
        return view;
    }// Colocar todas las preguntas con sus respectivas respuestas (BOTTOM).

    public String[] Preguntas()
    { // Preguntas (TOP)
        dataSource = new DataBaseAppRed(context);                                                   // Se inicializa la instancia de la bd.
        dataCursor=dataSource.getPreguntasCiudadanometroBD();                                       // Se obtienen las preguntas de la bd.
        String[] stringArrayAuxiliarPreguntas = new String[dataCursor.getCount()];                  // Auxiliar que contiene las preguntas de la bd.
        int intAuxiliar2 = 0;                                                                       // Auxiliar para posicionar los elementos dentro del vetor de Strings.

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

        String[] stringAuxiliarIdAnios = new String[dataCursor.getCount()];                         // Auxiliar que contiene el anio de las preguntas que esta en la bd.
        String[] stringAuxiliarIdPreguntas = new String[dataCursor.getCount()];                     // Auxiliar que contiene el id de la pregunta que esta en la bd.
        String[] stringAuxiliarIdRespuesta = new String[dataCursor.getCount()];                     // Auxiliar que contiene el id de la respuesta que esta en la bd.
        String[] stringAuxiliarIdEstatusRespuesta = new String[dataCursor.getCount()];              // Auxiliar que contiene los estatus de las respuestas en la bd.
        String[] stringAuxiliarRespuesta = new String[dataCursor.getCount()];                       // Auxiliar que contiene las respuestas en la bd.
        int intAuxiliar = 0;                                                                        // Auxiliar para posicionar los elementos dentro del vetor de Strings.

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
