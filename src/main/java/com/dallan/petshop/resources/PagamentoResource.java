package com.dallan.petshop.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallan.petshop.domain.Pagamento;
import com.dallan.petshop.repositories.PagamentoRepository;
import com.dallan.petshop.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource extends AbstractResource<Pagamento, Integer, PagamentoRepository, PagamentoService> {

	@Override
	public Pagamento copyAtributosParaUpdate(Pagamento obj, Pagamento other) {
		obj.setSituacao(other.getSituacao());
		obj.setServico(other.getServico());
		return obj;
	}

}
