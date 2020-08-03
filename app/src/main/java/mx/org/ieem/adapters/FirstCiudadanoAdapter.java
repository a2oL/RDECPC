package mx.org.ieem.adapters;

import android.content.Context;
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

public class FirstCiudadanoAdapter extends BaseAdapter {



    // Adaptador que se modificara completamente con la inclusion de la bd del ciudadanometro











    Context context;
    String[] questionsList;
    LayoutInflater inflter;
    public static ArrayList<String> selectedAnswersCiudada;
    RadioGroup rgp;
    String[] respuestas;
    Drawable image1,image2,image3;

    public final boolean[][] isSelec = new boolean[50][50];

    public FirstCiudadanoAdapter(Context applicationContext, String[] questionsList) {
        this.context = applicationContext;
        this.questionsList = questionsList;
        for(int r = 0; r< 50;r++)
        {
            for(int y = 0; y< 50; y++){
                isSelec[r][y]=false;
            }
        }
        selectedAnswersCiudada = new ArrayList<>();
        for (int i = 0; i < questionsList.length; i++) {
            selectedAnswersCiudada.add("Not Attempted");
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
        int buttons;
        ArrayList respuestasArray = new ArrayList();
        String[] respuestas1= {"SI\t\t","NO\t\t"};
        String[] respuestas2= {"SI\t\t","NO\t\t"};
        String[] respuestas3= {"SI\t\t","NO\t\t"};
        String[] respuestas4= {"SI\t\t","NO\t\t"};
        String[] respuestas5= {"SI\t\t","NO\t\t"};
        String[] respuestas6= {"SI\t\t","NO\t\t"};
        String[] respuestas7= {"SI\t\t","NO\t\t"};
        String[] respuestas8= {"SI\t\t","NO\t\t"};
        respuestasArray.add(respuestas1);
        respuestasArray.add(respuestas2);
        respuestasArray.add(respuestas3);
        respuestasArray.add(respuestas4);
        respuestasArray.add(respuestas5);
        respuestasArray.add(respuestas6);
        respuestasArray.add(respuestas7);
        respuestasArray.add(respuestas8);

        respuestas = (String[]) respuestasArray.get(p);
        buttons = respuestas.length;

        image1  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_cara_naranja);
        image2  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_cara_verde);
        image3  = ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.btn_nino_nina);
        Drawable[] dar = {image1,image2,image3};

        for (int i = 0; i < buttons; i++) {
            final String respuestaz = respuestas[i];
            rb[i]  = new RadioButton(view.getContext());
            rb[i].setId(View.generateViewId());
            rb[i].setText(respuestas[i]);
            if(respuestas[i].equals("NO\t\t"))
            {
                int h = image2.getIntrinsicHeight();
                int w = image2.getIntrinsicWidth();
                image2.setBounds( 0, 0, w, h );
                rb[i].setCompoundDrawables(null,null,image2,null);
            }else{
                int h = image1.getIntrinsicHeight();
                int w = image1.getIntrinsicWidth();
                image1.setBounds( 0, 0, w, h );
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
                        selectedAnswersCiudada.set(p, respuestaz);
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
}
