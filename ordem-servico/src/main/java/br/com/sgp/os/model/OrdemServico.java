package br.com.sgp.os.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity(name = "ordens_servico")
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dataAbertura;

	@Temporal(TemporalType.DATE)
	private Date dataFechamento;

	@NotNull
	@Column(nullable = false)
	private Long odometro;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoManutencao tipoDeManutencao;

	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "motorista_id", nullable = false)
	private Motorista motorista;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "veiculo_id", nullable = false)
	private Veiculo veiculo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "mecanico_id", nullable = false)
	private Mecanico mecanico;

	@Column(columnDefinition = "text")
	private String observacoes;

	@ManyToMany
	@JoinTable(name = "servicos_ordem_servico", joinColumns = @JoinColumn(name = "ordem_servico_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
	private List<Servico> servicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Long getOdometro() {
		return odometro;
	}

	public void setOdometro(Long odometro) {
		this.odometro = odometro;
	}

	public TipoManutencao getTipoDeManutencao() {
		return tipoDeManutencao;
	}

	public void setTipoDeManutencao(TipoManutencao tipoDeManutencao) {
		this.tipoDeManutencao = tipoDeManutencao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
