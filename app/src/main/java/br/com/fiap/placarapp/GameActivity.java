package br.com.fiap.placarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    //    DECLARAÇÃO DE VARIÁVEIS LOCAIS
    private String timeCasa;
    private String timeVisitante;
    private int contadorCasa;
    private int contadorVisitante;

    //    DECLARAÇÃO DE VARIÁVEIS DE CADA TIPO
    private TextView tvTimeCasa;
    private TextView tvTimeVisitante;
    private TextView tvContadorCasa;
    private TextView tvContadorVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

//        REFERENCIANDO UM ELEMENTO BASEADO-SE NO SEU ID
        tvTimeCasa = (TextView) findViewById(R.id.tvTimeCasa);
        tvTimeVisitante = (TextView) findViewById(R.id.tvTimeVisitante);
        tvContadorCasa = (TextView) findViewById(R.id.tvContadorGolCasa);
        tvContadorVisitante = (TextView) findViewById(R.id.tvContadorGolVisitante);

//        CASO VENHA VALORES DE OUTRA INTENT (VIEW) ELE ATRIBUI A VARIÁVEL LOCAL
        if (getIntent() != null) {

//            ATRIBUI A VARIÁVEIS OS VALORES JÁ EXISTENTES NA INTENT, ATRAVÉS DE SEUS RESPECTIVOS NOMES
            timeCasa = getIntent().getStringExtra("TIMECASA");
            timeVisitante = getIntent().getStringExtra("TIMEVISITANTE");

//            SETANDO VALORES NO ELEMENTO NA TELA
            tvTimeCasa.setText(timeCasa);
            tvTimeVisitante.setText(timeVisitante);
        }

//        VERIFICA SE TEM ALGUM VALOR SALVO NO STATUS DA INSTÂNCIA
        if (savedInstanceState != null) {

//            ATRIBUI A VARIÁVEIS OS VALORES EXISTENTES NO STATUS DA INSTÂNCIA
            contadorCasa = savedInstanceState.getInt("CONTADORCASA");
            contadorVisitante = savedInstanceState.getInt("CONTADORVISITANTE");

//            SETANDO VALORES NO ELEMENTO NA TELA
            tvContadorCasa.setText(String.valueOf(contadorCasa));
            tvContadorVisitante.setText(String.valueOf(contadorVisitante));
        }
    }

    //    FUNÇÃO DO ONCLICK DO BOTAO GOL CASA
    public void golCasa(View v) {
        contadorCasa++;
//            SETANDO VALORES NO ELEMENTO NA TELA
        tvContadorCasa.setText(String.valueOf(contadorCasa));
    }

    //    FUNÇÃO DO ONCLICK DO BOTAO GOL VISITANTE
    public void golVisitante(View v) {
        contadorVisitante++;
//            SETANDO VALORES NO ELEMENTO NA TELA
        tvContadorVisitante.setText(String.valueOf(contadorVisitante));
    }

    //    MÉTODO QUE SALVA VARIÁVEIS NA STATUS DA INSTÂNCIA
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

//        ATRIBUI VALORES NOS ELEMENTOS DA INSTÂNCIA
        outState.putInt("CONTADORCASA", contadorCasa);
        outState.putInt("CONTADORVISITANTE", contadorVisitante);
    }
}
