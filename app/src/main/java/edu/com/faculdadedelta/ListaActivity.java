package edu.com.faculdadedelta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.com.faculdadedelta.adapter.SeriadoAdapter;
import edu.com.faculdadedelta.dao.SeriadoDAO;
import edu.com.faculdadedelta.modelo.Seriado;

public class ListaActivity extends AppCompatActivity {

    private ListView lvLista;
    private SeriadoDAO dao = new SeriadoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvLista = findViewById(R.id.lvLista);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Seriado seriadoSelecionado = (Seriado) parent.getItemAtPosition(position);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("seriadoSelecionado", seriadoSelecionado);
                startActivity(intent);
            }
        });
        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Seriado seriadoSelecionado = (Seriado) parent.getItemAtPosition(position);
                dao.excluir(seriadoSelecionado);
                carregarLista();
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }
    private void carregarLista(){
        SeriadoAdapter adapter = new SeriadoAdapter(dao.listar(), getBaseContext());
        lvLista.setAdapter(adapter);

    }
}
