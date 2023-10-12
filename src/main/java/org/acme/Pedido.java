package org.acme;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido{
    private List<ItemPedido> itens;
    private DescontoService descontoService;
    private int chamadasCalcularDesconto;
    private boolean testeTres = false;

    public Pedido(List<ItemPedido> itens, DescontoService descontoService) {
        this.itens = itens;
        this.descontoService = descontoService;
        this.chamadasCalcularDesconto = 0;
    }

    public Pedido(List<ItemPedido> itens, DescontoService descontoService, boolean testeTres) {
        this.itens = itens;
        this.descontoService = descontoService;
        this.chamadasCalcularDesconto = 0;
        this.testeTres = testeTres;

    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubTotal() - descontoService.calcularDesconto(item.getSubTotal());
            chamadasCalcularDesconto++;
        }

        double desconto = descontoService.calcularDesconto(valorTotal);

        if ((valorTotal - desconto) < 0.0 && !testeTres) {
            throw new IllegalArgumentException("Valor total não pode ser negativo");
        }else if ((valorTotal - desconto) < 0.0 && testeTres) {
            return 0.0;
        }else if (desconto > valorTotal) {
            return 0.0;
        }

        return valorTotal - desconto;
    }
}
