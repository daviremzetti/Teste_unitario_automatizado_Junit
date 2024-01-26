package davi.testesUnitarios.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cadastro_funcionarios")
public class Funcionario {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
        
        public int getId(){
            return id;
        }

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}
        
        public void setId(int id){
            this.id = id;
        }
        
        public void setNome(String nome){
            this.nome = nome;
        }
        
        public void setDataAdmissao(LocalDate data){
            this.dataAdmissao = data;
        }
        
        public void setSalario(BigDecimal salario){
            this.salario = salario;
        }

}
