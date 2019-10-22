package br.edu.fatecgarca.freetrading;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RecebePendencias extends AsyncTask<Void, Void, String> {

    private String string_json;
    private Context context;
    private ProgressDialog dialog;

    @Override
    protected String doInBackground(Void... voids) {
        String json_url = "http://192.168.0.101/ws/pendencias/listarPendencias";

        try {
            URL url = new URL(json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((string_json = bufferedReader.readLine())!= null){
                stringBuilder.append(string_json);
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString().trim();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public RecebePendencias(Context context){
        super();
        this.context = context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            inserirPendencias(s);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setTitle("Carregando pendências");
        dialog.setMessage("Aguarde, Por Favor");
        dialog.setCancelable(false);
        dialog.show();

    }

    private void inserirPendencias(String retorno) throws JSONException{
        JSONArray jsonArray = new JSONArray();
        DAO dao = new DAO(context);
        String mensagem = "";
        //deleta todos vestígios de pendencias
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Venda venda = new Venda();


            if(dao.incluirVenda(venda)){
                mensagem= "Venda Recebida com sucesso!";
            }else {
                mensagem="Ops! Ocorreu um erro";
            }
        }

        if(dialog!=null){
            if (dialog.isShowing()){
                dialog.dismiss();
            }
        }

    }
}
