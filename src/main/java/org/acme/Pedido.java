package org.acme;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Pedido{
    private List<ItemPedido> itens;
    private DescontoService descontoService;
    private int chamadasCalcularDesconto;

    public Pedido(List<ItemPedido> itens, DescontoService descontoService) {
        this.itens = itens;
        this.descontoService = descontoService;
        this.chamadasCalcularDesconto = 0;
    }
    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubTotal() - descontoService.calcularDesconto(item.getSubTotal());
            chamadasCalcularDesconto++;
        }

        double desconto = descontoService.calcularDesconto(valorTotal);

        if ((valorTotal - desconto) < 0.0) {
            throw new IllegalArgumentException("Valor total não pode ser negativo");
        } else if (desconto > valorTotal) {
            return 0.0;
        }

        return valorTotal - desconto;
    }
}
