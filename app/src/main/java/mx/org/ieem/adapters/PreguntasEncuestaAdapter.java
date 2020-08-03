package mx.org.ieem.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
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
import mx.org.ieem.data.DataBaseAppRed;

import static mx.org.ieem.R.layout.list_preguntas_encuesta;

public class PreguntasEncuestaAdapter extends BaseAdapter
{  //PreguntasEncuestaAdapter (TOP)
    Context context;                                                    // Contiene el contexto de PreguntasEncuestaActivity.
    String[] questionsList;                                             // Contiene Las preguntas de la bd.
    public static ArrayList<String> selectedRespuestas;                 // Contiene las respuestas seleccionadas.
    public static ArrayList<String> selectedIndicador;                  // Contiene los indicadores de las respuestas.
    public static ArrayList<String> selectedIdRespuesta;                // Contiene el id de la respuesta seleccionada.
    public static ArrayList<String> selectedEstatus;                    // Contiene el estatus de las respuestas seleccionadas.
    public final boolean[][] isSelec = new boolean[50][50];             // Para mapear nuevamente las respuestas que ya habian sido seleccionadas.
    LayoutInflater inflter;                                             // Utilizado para poder cargar elementos de la ui.
    Drawable[] dar;                                                     // Contiene las imagenes que se utilizaran en las respuestas.
    RadioGroup radioGroupRespuestas;                                    // Contiene radiobuttons de las respuestas de cada pregunta.

    String[] stringArrayRespuestas;                                     // Contiene las respuestas de las preguntas.
    String[] stringArrayEstatusRespuestas;                              // Contiene el estatus de las respuestas de las preguntas.
    String[] stringArrayIdRespuestas;                                   // Contiene el id de las respuestas de las preguntas.
    String[] stringArrayIndicadoresRespuestas;                          // Contiene el indicador de las respuestas de las preguntas.

    DataBaseAppRed dataSource;                                          // Instancia de la bd para poder obtener las preguntas y sus respuestas.
    Cursor dataCursor;                                                  // Aloja el resultSet del querya la bd de las preguntas y las respuestas.

    public PreguntasEncuestaAdapter(Context applicationContext)
    { // Constructor e inicializador de las variables (TOP)
        // Inicializacion de las variables (TOP)
        this.context = applicationContext;
        this.questionsList = Preguntas();
        selectedRespuestas = new ArrayList<>();
        selectedIndicador  = new ArrayList<>();
        selectedIdRespuesta  = new ArrayList<>();
        selectedEstatus = new ArrayList<>();

        // Rellena una matriz para poder definir que botones estan marcado (TOP)
        for (int columnas = 0; columnas< 50;columnas++)
           {
               for (int filas = 0; filas< 50; filas++)
                  {
                      isSelec[columnas][filas]=false;
                  }
           }
        // Rellena una matriz para poder definir que botones estan marcado (BOTTOM)

        // Respuesta por default para una pregunta no respondida (TOP)
        for (int i = 0; i < questionsList.length; i++)
           {
               selectedRespuestas.add("Not Attempted");
               selectedIndicador.add("Not Attempted");
               selectedIdRespuesta.add("Not Attempted");
               selectedEstatus.add("Not Attempted");
           }
        // Respuesta por default para una pregunta no respondida (BOTTOM)

        inflter = (LayoutInflater.from(applicationContext));
        // Inicializacion de las variables (BOTTOM)
    } // Constructor e inicializador de las variables (BOTTOM)

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
    public View getView(final int posicion, View view, ViewGroup parent)
    { // View de las respuestas (TOP)
        // Inicializacion de las variables (TOP)
        view = inflter.inflate(list_preguntas_encuesta, null);
        TextView pregunta = (TextView) view.findViewById(R.id.textView_pregunta_preguntas_encuesta);
        radioGroupRespuestas = (RadioGroup) view.findViewById(R.id.radioGroup_respuestas_preguntas_encuesta);
        final RadioButton[] rb = new RadioButton[50];                                                                           // Contiene los radioButtons que se mostraran para las respuestas de la bd.
        Drawable imageNino = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino);                   // Contiene la imagen ninio Azul
        Drawable imageNina = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nina);                   // Contiene la imagen ninia rosa.
        Drawable imageOtra = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino_nina);              // Contiene la imagen persona verde.
        radioGroupRespuestas.setOrientation(RadioGroup.HORIZONTAL);                                                             // Configuracion del radio gropu para que asi muestre los radiobuttons de manera horizontal.
        imageNino.setBounds( 0, 0, imageNino.getIntrinsicWidth(), imageNino.getIntrinsicHeight() );                   // Propiedades de la imagen del boton.
        imageNina.setBounds( 0, 0, imageNina.getIntrinsicWidth(), imageNina.getIntrinsicHeight() );                   // Propiedades de la imagen del boton.
        imageOtra.setBounds( 0, 0, imageOtra.getIntrinsicWidth(), imageOtra.getIntrinsicHeight() );                   // Propiedades de la imagen del boton.
        dar = new Drawable[]{imageNino, imageNina, imageOtra};
        // Inicializacion de las variables (BOTTOM)

        // Regresa las respuestas de la pregunta seleccionada
        Respuestas(posicion+1);

        if (posicion == 0)
          { // Si es la primera pregunta que se mostrara cambiara la respuesta por las imagenes (TOP)
              for (int i = 0; i < stringArrayRespuestas.length; i++)
                { // Carga las imagenes en los radio buttons (TOP)
                    rb[i]  = new RadioButton(view.getContext());
                    rb[i].setId(View.generateViewId());
                    rb[i].setLeft(100);
                    rb[i].setCompoundDrawables(null,null,dar[i],null);
                    final int finalI = i;
                    rb[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked)
                              { // Si algun radio button es seleccionado (TOP)
                                  for (int l = 0; l<50; l++)
                                    { // Si algun boton habia sido seleccionado lo vuelve a desmarcar para poder marcar el nuevo (TOP)
                                        isSelec[posicion][l]=false;
                                    } // Si algun boton habia sido seleccionado lo vuelve a desmarcar para poder marcar el nuevo (BOTTOM)
                                  selectedRespuestas.set(posicion, stringArrayRespuestas[finalI]);
                                  selectedEstatus.set(posicion, stringArrayEstatusRespuestas[finalI]);
                                  selectedIdRespuesta.set(posicion,stringArrayIdRespuestas[finalI]);
                                  selectedIndicador.set(posicion,String.valueOf(posicion + 1));
                                  isSelec[posicion][finalI] = true;
                              } // Si algun radio button es seleccionado (BOTTOM)
                    }
                });
                    rb[i].setChecked(isSelec[posicion][i]);
                    radioGroupRespuestas.addView(rb[i]);
                }// Carga las imagenes en los radio buttons (BOTTOM)
          } // Si es la primera pregunta que se mostrara cambiara la respuesta por las imagenes (BOTTOM)
        else
          { // Estas respuestas ya no contienen imagenes (TOP)
            for (int i = 0; i < stringArrayRespuestas.length; i++)
              {
                  rb[i]  = new RadioButton(view.getContext());
                  rb[i].setId(View.generateViewId());
                  rb[i].setText(stringArrayRespuestas[i]);
                  rb[i].setTextColor(0xffbdbdbd);
                  final int finalI = i;
                  rb[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                          if (isChecked)
                            { // Si algun radio button es seleccionado (TOP)
                                for (int l = 0; l<50; l++)
                                   { // Si algun boton habia sido seleccionado lo vuelve a desmarcar para poder marcar el nuevo (TOP)
                                       isSelec[posicion][l]=false;
                                   } // Si algun boton habia sido seleccionado lo vuelve a desmarcar para poder marcar el nuevo (BOTTOM)
                                selectedRespuestas.set(posicion, stringArrayRespuestas[finalI]);
                                selectedEstatus.set(posicion, stringArrayEstatusRespuestas[finalI]);
                                selectedIdRespuesta.set(posicion,stringArrayIdRespuestas[finalI]);
                                selectedIndicador.set(posicion,String.valueOf(posicion + 1));
                                isSelec[posicion][finalI] = true;
                            } // Si algun radio button es seleccionado (BOTTOM)
                    }
                });
                  rb[i].setWidth(250);
                  rb[i].setGravity(Gravity.CENTER_HORIZONTAL);
                  rb[i].setChecked(isSelec[posicion][i]);
                  radioGroupRespuestas.addView(rb[i]);
              }
          } // Estas respuestas ya no contienen imagenes (BOTTOM)
        pregunta.setText(questionsList[posicion]);
        return view;
    } // View de las respuestas (BOTTOM)

    /**
     * Método que regresa todas las preguntas de la bd.
     */
    public String[] Preguntas()
    { // Preguntas (TOP)
        dataSource = new DataBaseAppRed(context);
        dataCursor=dataSource.getPreguntasEncuestaBD();

        String[] stringArrayAuxiliarPreguntas = new String[dataCursor.getCount()];           // Auxiliar que contiene las preguntas de la bd.
        int intAuxiliar = 0;                                                                 // Auxiliar para posicionar los elementos dentro del vetor de Strings.

        if (dataCursor.getCount() > 0)
          { // Si existen preguntas en la bd (TOP)
              while (dataCursor.moveToNext())
                { // Se guardan en preguntas[] (TOP)
                    stringArrayAuxiliarPreguntas[intAuxiliar] = dataCursor.getString(4);
                    intAuxiliar++;
                } // Se guardan en preguntas[] (BOTTOM)
          } // Si existen preguntas en la bd (BOTTOM)

        return stringArrayAuxiliarPreguntas;
    } // Preguntas (BOTTOM)

    /**
     * Método que regresa las preguntas que estan asociadas a una pregunta.
     */
    public void Respuestas(int pos)
    { // Respuestas (TOP)
        dataSource = new DataBaseAppRed(context);
        dataCursor=dataSource.getRespuestasEncuestaBD(pos);

        String[] stringAuxiliarRespuestas = new String[dataCursor.getCount()];               // Auxiliar que contiene las respues que se encuentran en la bd.
        String[] stringAuxiliarEstatus = new String[dataCursor.getCount()];                  // Auxiliar que contiene el estatus de las respuestas de la bd.
        String[] stringAuxiliarIdRespuesta = new String[dataCursor.getCount()];              // Auxiliar que contiene el id de la respuesta que esta en la bd.
        String[] stringAuxiliarIndicador = new String[dataCursor.getCount()];                // Auxiliar que contiene los indicadores de las respuestas de la bd.
        int intAuxiliar = 0;                                                                 // Auxiliar para posicionar los elementos dentro del vetor de Strings.

        if (dataCursor.getCount() > 0)
          { // Si existen respuestas asociadas a la pregunta (TOP)
              while (dataCursor.moveToNext())
                { // Se guardan los datos de la bd en los Array String auxiliares (TOP)
                    stringAuxiliarIndicador[intAuxiliar] = dataCursor.getString(3);
                    stringAuxiliarIdRespuesta[intAuxiliar] = dataCursor.getString(4);
                    stringAuxiliarEstatus[intAuxiliar] = dataCursor.getString(5);
                    stringAuxiliarRespuestas[intAuxiliar] = dataCursor.getString(6);
                    intAuxiliar++;
                } // Se guardan los datos de la bd en los Array String auxiliares (BOTTOM)
          } // Si existen respuestas asociadas a la pregunta (BOTTOM)

        // Regresando a las variables globales los valores de las respuestas encontrados (TOP)
        this.stringArrayEstatusRespuestas = stringAuxiliarEstatus;
        this.stringArrayRespuestas = stringAuxiliarRespuestas;
        this.stringArrayIdRespuestas = stringAuxiliarIdRespuesta;
        this.stringArrayIndicadoresRespuestas = stringAuxiliarIndicador;
        // Regresando a las variables globales los valores de las respuestas encontrados (BOTTOM)
    } // Respuestas (BOTTOM)
} //PreguntasEncuestaAdapter (BOTTOM)
