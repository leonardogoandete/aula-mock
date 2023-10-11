package org.acme;

import java.util.List;

public class Pedido{
    private List<ItemPedido> itens;
    private DescontoService descontoService;

    public Pedido(List<ItemPedido> itens, DescontoService descontoService) {
        this.itens = itens;
        this.descontoService = descontoService;
    }
    public double calcularValorTotal() {
        double valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubTotal();
        }

        double desconto = descontoService.calcularDesconto(valorTotal);
        if (desconto > valorTotal){
            return 0.0;
        }

//        if (valorTotal < 0.0){
//            throw new IllegalArgumentException("Valor total não pode ser negativo");
//        }
        return valorTotal - desconto;
    }

}
