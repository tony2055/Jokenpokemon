package br.com.antoniohenrique.jokenpokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    val GRAMA = 1
    val AGUA = 2
    val FOGO = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivBulba.setOnClickListener {
            realizarJogada(GRAMA)
        }

        ivSquirtle.setOnClickListener {
            realizarJogada(AGUA)
        }

        ivCharmander.setOnClickListener {
            realizarJogada(FOGO)
        }
    }

    fun configuraImagemDaJogada(jogada: Int, imageView: ImageView){
        when(jogada){
            GRAMA-> (configuraImagem(R.drawable.bulba, imageView))
            AGUA-> (configuraImagem(R.drawable.squirtle, imageView))
            FOGO-> (configuraImagem(R.drawable.charmander, imageView))
        }
    }

    fun configuraImagem(resourceID: Int, imageView: ImageView){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, resourceID))
    }

    fun realizarJogada(jogadaUsuario: Int) {
        val jogadaAdversario = Random().nextInt(3) + 1

        configuraImagemDaJogada(jogadaUsuario, ivVoce)
        configuraImagemDaJogada(jogadaAdversario, ivAndroid)

        when (jogadaUsuario) {
            GRAMA -> {
                when (jogadaAdversario) {
                    GRAMA -> (empate())
                    AGUA -> (vitoria())
                    FOGO -> (derrota())
                }
            }
            FOGO -> {
                when (jogadaAdversario) {
                    GRAMA -> (vitoria())
                    AGUA -> (derrota())
                    FOGO -> (empate())
                }
            }
            AGUA -> {
                when (jogadaAdversario) {
                    GRAMA -> (derrota())
                    AGUA -> (empate())
                    FOGO -> (vitoria())
                }
            }
        }
    }

    fun vitoria() {
        tvResultado.text = "Você ganhou!"
    }

    fun derrota(){
        tvResultado.text = "Deu ruim!"

    }

    fun empate(){
        tvResultado.text = "Deu empate!"
    }
}
