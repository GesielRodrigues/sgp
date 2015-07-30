package br.com.pedreirascontagem.model;

public enum TipoServico {

	CAIXA("Caixa e Diferencial"),
	ELETRICA("Elétrica"),
	FREIO("Freio"),
	HIDRAULICO("Sistemas Hidráulicos"),
	LUBRIFICACAO("Lavagem e Lubrificação"),
	MOTOR("Motor"),
	PNEUS("Pneus"),
	REFORMA("Reforma"),
	SUSPENSAO("Suspensão"),
	TANQUE("Tanque"),
	VALVULA("Válvula de Bloqueio"),
	DIVERSOS("Diversos");

	private String descricao;

	private TipoServico(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
