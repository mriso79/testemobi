package com.mobi.domain;

public enum Resposta {
    Sim (1), Nao(2);

    private int respostaVoto;

    Resposta(int b){
        respostaVoto = b;
    }

    public int getResposta(){
        return respostaVoto;
    }
}
