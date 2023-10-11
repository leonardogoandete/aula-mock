package org.acme;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
;


@Slf4j
@ExtendWith(MockitoExtension.class)
public class SimularDesconto {
    @Mock
    DescontoService descontoService;
//    @InjectMocks
//    Pedido pedido;


    @Test
    public void simularDescontoComDezPorCento() {
        lenient().when(descontoService.calcularDesconto(50.0)).thenReturn(5.0);

//        descontoService = new DescontoService() {
//            @Override
//            public double calcularDesconto(double valorTotal) {
//                return valorTotal * 0.1;
//            }
//        };
//
//        List<ItemPedido> itens = new ArrayList<>();
//        itens.add(new ItemPedido(50.0));
//        log.info("Itens: {}", itens);
//        pedido = new Pedido(itens, descontoService);
//        assertEquals(45.0, pedido.calcularValorTotal());
//        log.info("Valor total: {}", pedido.calcularValorTotal());
    }


//    @Test
//    public void simularDescontoComDescontoZero() {
//
//        descontoService = new DescontoService() {
//            @Override
//            public double calcularDesconto(double valorTotal) {
//                return valorTotal * 0.0;
//            }
//        };
//
//        List<ItemPedido> itens = new ArrayList<>();
//        itens.add(new ItemPedido(54.35));
//        log.info("Itens: {}", itens);
//        pedido = new Pedido(itens, descontoService);
//        assertEquals(54.35, pedido.calcularValorTotal());
//        log.info("Valor total: {}", pedido.calcularValorTotal());
//    }


//    @Test
//    public void simularDescontoComDescontoMaiorQueValorTotal() {
//
//        descontoService = new DescontoService() {
//            @Override
//            public double calcularDesconto(double valorTotal) {
//                return valorTotal * 1.1;
//            }
//        };
//
//        List<ItemPedido> itens = new ArrayList<>();
//        itens.add(new ItemPedido(54.35));
//        log.info("Itens: {}", itens);
//        pedido = new Pedido(itens, descontoService);
//        assertEquals(0.0, pedido.calcularValorTotal());
//        log.info("Valor total: {}", pedido.calcularValorTotal());
//    }



//    @Test
//    public void simularSeValorTotalForNegativoComDesconto() {
//        descontoService = new DescontoService() {
//            @Override
//            public double calcularDesconto(double valorTotal) {
//                return valorTotal * 1.1;
//            }
//        };
//
//        List<ItemPedido> itens = new ArrayList<>();
//        itens.add(new ItemPedido(54.35));
//        log.info("Itens: {}", itens);
//        pedido = new Pedido(itens, descontoService);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            pedido.calcularValorTotal();
//        });

        //log.info("Valor total: {}", pedido.calcularValorTotal());

//    }
}


