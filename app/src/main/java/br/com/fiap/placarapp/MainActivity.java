package br.com.fiap.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //    DECLARAÇÃO DE VARIÁVEIS DE CADA TIPO
    private EditText etTimeCasa;
    private EditText etTimeVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        REFERENCIANDO UM ELEMENTO BASEADO-SE NO SEU ID
        etTimeCasa = (EditText) findViewById(R.id.etTimeCasa);
        etTimeVisitante = (EditText) findViewById(R.id.edTimeVisitante);
    }

    //    FUNÇÃO DO ONCLICK DO BOTAO COMEÇAR A JOGAR
    public void comecarJogo(View v) {

//        VERIFICA SE OS CAMPOS ESTÃO VAZIOS OU EM BRANCO
        if (etTimeCasa.getText().toString().isEmpty()) {

//            EXIBE UMA MENSAGEM PRO USUÁIO
            Toast.makeText(this, "Informe o time da casa", Toast.LENGTH_SHORT).show();
            return;
        }

//        VERIFICA SE OS CAMPOS ESTÃO VAZIOS OU EM BRANCO
        if (etTimeVisitante.getText().toString().isEmpty()) {
//            EXIBE UMA MENSAGEM PRO USUÁIO
            Toast.makeText(this, "Informe o time visitante", Toast.LENGTH_SHORT).show();
            return;
        }

//        CRIA UMA INTENT REFERENCIANDO ESSE ESCOPO E A NOVA TELA A SER CHAMADA
        Intent proxTela = new Intent(this, GameActivity.class);

//        SETA VALORES A SEREM PASSADOS PARA A NOVA TELA
        proxTela.putExtra("TIMECASA", etTimeCasa.getText().toString());
        proxTela.putExtra("TIMEVISITANTE", etTimeVisitante.getText().toString());

//        CHAMA A PRÓXIMA TELA
        startActivity(proxTela);
    }
}
