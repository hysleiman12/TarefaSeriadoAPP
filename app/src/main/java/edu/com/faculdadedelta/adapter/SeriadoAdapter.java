package edu.com.faculdadedelta.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.com.faculdadedelta.R;
import edu.com.faculdadedelta.modelo.Seriado;

public class SeriadoAdapter extends BaseAdapter {

    private List<Seriado>listaSeriados;
    private Context context;

    public SeriadoAdapter(List<Seriado> listaSeriados, Context context) {
        this.listaSeriados = listaSeriados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaSeriados.size();//tamanho da lista
    }

    @Override
    public Object getItem(int position) {
        return listaSeriados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Seriado seriado = (Seriado) getItem(position);

       View viewRetorno =  convertView.inflate(context, R.layout.item_lista, null);

       TextView tvGenero = viewRetorno.findViewById(R.id.tvGenero);
       tvGenero.setText("Genero: "+ seriado.getGenero());

        TextView tvStatu = viewRetorno.findViewById(R.id.tvStatu);
        tvStatu.setText("Status: "+ seriado.getStatus());

        TextView tvNome = viewRetorno.findViewById(R.id.tvNome);
        tvNome.setText("Nome: "+ seriado.getNome());

        TextView tvComentario = viewRetorno.findViewById(R.id.tvComentario);
        tvComentario.setText("Comentario: "+ seriado.getComentario());

        TextView tvNota = viewRetorno.findViewById(R.id.tvNota);
        tvNota.setText("Nota: "+ seriado.getNota());

        TextView tvDataLan = viewRetorno.findViewById(R.id.tvDataLan);
        tvDataLan.setText("Data lançamento: "+ seriado.getDataLan());

        if (position % 2 == 0) {

            viewRetorno.setBackgroundColor(R.color.colorPrimary);
        }


        return viewRetorno;


    }
}
