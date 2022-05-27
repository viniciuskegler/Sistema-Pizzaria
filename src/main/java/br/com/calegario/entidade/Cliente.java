package br.com.calegario.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author vinicius.kegler
 */
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Cliente extends Pessoa {

    @Column(nullable = false)
    private boolean cupom;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    
    public Cliente() {
    }

    public Cliente(boolean cupom, Long id, String nome, String email, String telefone) {
        super(id, nome, email, telefone);
        this.cupom = cupom;
    }

    public boolean isCupom() {
        return cupom;
    }

    public void setCupom(boolean cupom) {
        this.cupom = cupom;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
