package com.mobi.services;

import com.mobi.domain.*;
import com.mobi.exceptions.SessaoException;
import com.mobi.exceptions.UserException;
import com.mobi.exceptions.VotoException;
import com.mobi.repositories.PautaRepo;
import com.mobi.repositories.SessaoRepo;
import com.mobi.repositories.UsersRepo;
import com.mobi.repositories.VotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class VotoService {
    @Autowired
    private VotoRepo votoRepo;

    @Autowired
    private UsersRepo userRepo;

    @Autowired
    private SessaoRepo sessaoRepo;

    @Autowired
    private PautaRepo pautaRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${cpf.url}")
    private String cpfUrl;

    /**
     *
     * Normalmente, coloco regras de negócio no service, mas poderiam estar em uma
     * camada à parte, dependendo da situação.
     *
     * Exceptions tratadas com RestControllerAdvice.
     *
     * Para aumentar a performance, eu usaria um gerenciador de eventos como
     * o Apache Kafka para receber cada evento de voto, e teria um microserviço
     * que processaria o voto, mas, como não tenho tempo hábil para este teste, fiz
     * da maneira mais simplória e funcional possível.
     *
     * @param voto
     * @return Retorno
     */
    public Retorno adicionarVotoService(Voto voto){
        Retorno retorno = new Retorno("");
        Optional<Users> userOpt = userRepo.findById(voto.getUsuarioid());

        Optional<Voto> userVoto = votoRepo.findByUsuarioid(voto.getUsuarioid());

        if(userOpt.isPresent()){
            if(userVoto.isPresent()) {
                throw new VotoException("Usuário já votou!", "Voto Inválido");
            }

            Optional<Sessao> sessao = sessaoRepo.findByPautaid(voto.getPauta_id());
            if(sessao.isPresent() && sessao.get().getFoi_aberta()){
                Users user = userOpt.get();
                Status status = restTemplate.getForObject(cpfUrl + user.getCpf(), Status.class);
                assert status != null;
                if(status.getStatus().equals("ABLE_TO_VOTE")) {
                    votoRepo.save(voto);
                    retorno.setMensagem("Voto computado com sucesso!");
                }else{
                    throw new VotoException("CPF não pode votar!", "CPF Inválido");
                }
            }else{
                throw new SessaoException("Não há sessão aberta para esta pauta!", "Pauta sem Sessão");
            }

        }else{
            throw new UserException("Usuário Inexistente!", "Usuário Inválido");
        }

        return retorno;
    }

    public List<Voto> listarVotos(){
        return votoRepo.findAll();
    }

    public Apuracao contabilizaVotos(Long pautaid) {
        Apuracao apuracao = new Apuracao();

        Optional<Pauta> pauta = pautaRepo.findById(pautaid);

        if(pauta.isPresent()){
            apuracao.setPauta(pauta.get().getDescricao());
        }

        apuracao.setSim(votoRepo.verificaSim());
        apuracao.setNao(votoRepo.verificaNao());

        return apuracao;
    }
}
