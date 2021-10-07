package com.mobi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Este Objeto de resposta poderia ter muito mais informação, mas para fins deste teste
 * foi muito simplificado.
 */

@Getter
@Setter
@AllArgsConstructor
public class Retorno {
    public String mensagem;
}
