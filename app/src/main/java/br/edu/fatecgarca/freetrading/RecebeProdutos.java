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

public class RecebeProdutos extends AsyncTask<Void, Void, String> {

    private String string_json;
    private Context context;
    private ProgressDialog dialog;

    @Override
    protected String doInBackground(Void... voids) {
        String url_json = "http://192.168.0.101/ws/produto/listaProdutos";

        try {
            URL url = new URL(url_json);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while ((string_json = bufferedReader.readLine())!=null){
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

    public RecebeProdutos(Context context){
        super();
        this.context = context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            inserirProdutos(s);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(context);
        dialog.setTitle("Carregando Produtos");
        dialog.setMessage("Aguarde, Por Favor");
        dialog.setCancelable(false);
        dialog.show();
    }

    private void inserirProdutos(String retorno) throws JSONException {
        JSONArray jsonArray = new JSONArray(retorno);
        DAO dao = new DAO(context);
        String mensagem = "";
        //deleta todos produtos pra não deixar vestigios
        dao.deletaTudoProduto();
        for (int i=0; i< jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Produto produto = new Produto();
            produto.setCodigo(jsonObject.getInt("codigo"));
            produto.setDescricao(jsonObject.getString("descricao"));
            produto.setPreco(jsonObject.getDouble("valor"));
            produto.setQuantidade(jsonObject.getInt("quantidade"));
            if(dao.incluirProduto(produto)){
                mensagem = "Produtos Recebidos com Sucesso";
            }else{
                mensagem = "Ops! Falha ao Carregar";
            }
        }
        if (dialog !=null){
            if(dialog.isShowing()){
                dialog.dismiss();
            }
        }
    }
}
