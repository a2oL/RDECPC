package mx.org.ieem.RESTful;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncLoadPage extends AsyncTask<Integer, Integer, String> {


    // Falta por documentar ya que aun no hace nada solo usa un contador para simular un envio de datos















    private ProgressBar progressBar;
   private TextView txt;
   private int count;
   private Button btn;


    public AsyncLoadPage(ProgressBar progressBar, TextView txt, int count, Button btn) {
        this.progressBar = progressBar;
        this.txt = txt;
        this.count = count;
        this.btn = btn;
    }

    @Override
    protected String doInBackground(Integer... params) {
        for (; count <= params[0]; count++) {
            try {
                Thread.sleep(1000);
                publishProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Task Completed.";
    }
    @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(View.GONE);
        btn.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onPreExecute() {
        txt.setText("Task Starting...");
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        txt.setText("Enviando..."+ values[0]);
        progressBar.setProgress(values[0]);
    }
}
