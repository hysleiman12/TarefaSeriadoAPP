package edu.com.faculdadedelta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.com.faculdadedelta.dao.SeriadoDAO;
import edu.com.faculdadedelta.modelo.Seriado;

public class MainActivity extends AppCompatActivity {


    Date dataConvertida = new Date();
    Date atual = new Date();
    private EditText etGenero;
    private EditText etStatu;
    private EditText etNome;
    private EditText etComentario;
    private EditText etNota;
    private EditText etDataLan;
    private Seriado seriado = new Seriado();
    private SeriadoDAO dao = new SeriadoDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGenero = findViewById(R.id.etGenero);
        etStatu = findViewById(R.id.etStatu);
        etNome = findViewById(R.id.etNome);
        etComentario = findViewById(R.id.etComentario);
        etNota = findViewById(R.id.etNota);
        etDataLan = findViewById(R.id.etDataLan);

        Intent intent = getIntent();

        if(intent != null){
            Seriado seriadoSelecionado = (Seriado) intent.getSerializableExtra("seriadoSelecionado");
            if(seriadoSelecionado != null){

                popularFormulario(seriadoSelecionado);

            }

        }


    }
    private void popularFormulario(Seriado seriadoSelecionado ){

        etGenero.setText(seriadoSelecionado.getGenero());
        etStatu.setText(seriadoSelecionado.getStatus());
        etNome.setText(seriadoSelecionado.getNome());
        etComentario.setText(seriadoSelecionado.getComentario());
        etNota.setText(seriadoSelecionado.getNota());
        etDataLan.setText(seriadoSelecionado.getDataLan());
        seriado.setId(seriadoSelecionado.getId());


    }

    public void salvar(View view){


        popularModelo();



        if(seriado.getId() == null){
            String  paramGenero = seriado.getGenero();
            String paramStatu = seriado.getStatus();
            String paramNome = seriado.getNome();
            String paramComentario = seriado.getComentario();
            String paramNota = seriado.getNota();
            String paramDataLan = seriado.getDataLan();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            dataConvertida = null;

            try {
                dataConvertida = formato.parse(String.valueOf(paramDataLan));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(paramGenero.equals("") && paramStatu.equals("") && paramNome.equals("")
                    && paramComentario.equals("") && paramNota.equals("") && dataConvertida == null){

                Toast.makeText(getBaseContext(),
                        "Todos os campos estão vazios!", Toast.LENGTH_LONG).show();

            }else if(paramGenero.equals("") || paramStatu.equals("") || paramNome.equals("")
                    || paramComentario.equals("") || paramNota.equals("") || dataConvertida == null){

                if(paramGenero.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo genero não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramStatu.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo statu não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramNome.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo nome não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramComentario.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo comentario não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramNota.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo nota não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(dataConvertida == null){
                    Toast.makeText(getBaseContext(),
                            "O campo data não pode está vazio!", Toast.LENGTH_LONG).show();

                }

            }else if(dataConvertida.after(atual)) {
                Toast.makeText(getBaseContext(),
                        "O campo data não pode ser maior que a data atual!", Toast.LENGTH_LONG).show();
            }else {


                dao.incluir(seriado);
                Toast.makeText(getBaseContext(), "Inclusão realizada com sucesso!", Toast.LENGTH_LONG).show();
                limparCampos();
            }

        }else{
            String  paramGenero = seriado.getGenero();
            String paramStatu = seriado.getStatus();
            String paramNome = seriado.getNome();
            String paramComentario = seriado.getComentario();
            String paramNota = seriado.getNota();
            String paramDataLan = seriado.getDataLan();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            dataConvertida = null;

            try {
                dataConvertida = formato.parse(String.valueOf(paramDataLan));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(paramGenero.equals("") && paramStatu.equals("") && paramNome.equals("")
                    && paramComentario.equals("") && paramNota.equals("") && dataConvertida == null){

                Toast.makeText(getBaseContext(),
                        "Todos os campos estão vazios!", Toast.LENGTH_LONG).show();

            }else if(paramGenero.equals("") || paramStatu.equals("") || paramNome.equals("")
                    || paramComentario.equals("") || paramNota.equals("") || dataConvertida == null){

                if(paramGenero.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo genero não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramStatu.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo statu não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramNome.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo nome não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramComentario.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo comentario não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(paramNota.equals("")){

                    Toast.makeText(getBaseContext(),
                            "O campo nota não pode estar vazio!", Toast.LENGTH_LONG).show();

                }else if(dataConvertida == null){
                    Toast.makeText(getBaseContext(),
                            "O campo data não pode está vazio!", Toast.LENGTH_LONG).show();

                }

            }else if(dataConvertida.after(atual)) {
                Toast.makeText(getBaseContext(),
                        "O campo data não pode ser maior que a data atual!", Toast.LENGTH_LONG).show();
            }else {

                dao.alterar(seriado);
                Toast.makeText(getBaseContext(), "alteração realizada com sucesso!", Toast.LENGTH_LONG).show();

                limparCampos();
            }
        }



    }



    private void popularModelo(){


        seriado.setGenero(etGenero.getText().toString());
        seriado.setStatus(etStatu.getText().toString());
        seriado.setNome(etNome.getText().toString());
        seriado.setComentario(etComentario.getText().toString());
        seriado.setNota(etNota.getText().toString());
        seriado.setDataLan(etDataLan.getText().toString());






    }
    private void limparCampos(){
        etGenero.setText("");
        etStatu.setText("");
        etNome.setText("");
        etComentario.setText("");
        etNota.setText("");
        etDataLan.setText("");
        seriado = new Seriado();
    }
    public void limpar(View view){
        limparCampos();

    }

    public void listar(View view){
        Intent intent = new Intent(getBaseContext(), ListaActivity.class);
        startActivity(intent);
    }



}
