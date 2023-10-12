package org.acme;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;





@ExtendWith(MockitoExtension.class)
class SimularDescontoTest {
    @Mock
    DescontoService descontoService;

    @InjectMocks
    Pedido pedido;

    @InjectMocks
    Pedido pedidoTesteTres;
    //Antes de cada teste, cria um novo pedido;
    @BeforeEach
    public void setUp() {
        pedido = new Pedido(new ArrayList<>(), descontoService);
    }

    //Criado para simular o teste 3
    @BeforeEach
    public void setUpTres() {
        pedidoTesteTres = new Pedido(new ArrayList<>(), descontoService,true);
    }


    //1 - Crie um teste unitário para a classe Pedido que configure um mock do DescontoService para simular um desconto
    // de 10% e verifique se o método calcularValorTotal retorna o valor correto após aplicar o desconto.
    @Test
    void simularDescontoComDezPorCento() {
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(50.0));
        pedido.setItens(itens);
        pedido.setDescontoService(descontoService);
        when(descontoService.calcularDesconto(50.0)).thenReturn(5.0);
        assertEquals(45.0, pedido.calcularValorTotal());
    }


    //2- Crie um teste unitário para a classe Pedido que simule um cenário em que o desconto seja zero e verifique
    // se o método calcularValorTotal retorna o valor correto sem desconto.
    @Test
    void simularDescontoComDescontoZero() {
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(54.35));
        pedido.setItens(itens);
        pedido.setDescontoService(descontoService);
        when(descontoService.calcularDesconto(54.35)).thenReturn(0.0);
        assertEquals(54.35, pedido.calcularValorTotal());
    }

    //3 - Crie outro teste unitário que simule um cenário em que o desconto seja maior que o valor total do pedido
    // e verifique se o método calcularValorTotal retorna 0.0, ou seja, o valor total não pode ser negativo.
    @Test
    void simularDescontoComDescontoMaiorQueValorTotal() {
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(54.35));
        pedidoTesteTres.setItens(itens);
        pedidoTesteTres.setDescontoService(descontoService);
        pedidoTesteTres.setTesteTres(true);
        when(descontoService.calcularDesconto(54.35)).thenReturn(60.0);
        assertEquals(0.0, pedidoTesteTres.calcularValorTotal());
    }


    //4 - Adicione uma validação no método calcularValorTotal da classe Pedido para lançar uma exceção
    // IllegalArgumentException se o valor total for negativo após aplicar o desconto. Crie um teste
    // unitário que verifique se essa exceção é lançada corretamente.
    @Test()
    void simularSeValorTotalForNegativoComDescontoLancaExcessao() {
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(54.35));
        pedido.setItens(itens);
        pedido.setDescontoService(descontoService);
        when(descontoService.calcularDesconto(54.35)).thenReturn(60.0);
        assertThrows(IllegalArgumentException.class, () -> pedido.calcularValorTotal());
    }

    //5 - Modifique a classe Pedido para aceitar uma lista vazia de itens.
    // Crie um teste unitário que simule esse cenário e verifique se o método calcularValorTotal retorna 0.0
    // quando não há itens no pedido.
    @Test
    void simularSeListaDeItensForVazia() {
        List<ItemPedido> itens = new ArrayList<>();
        pedido.setItens(itens);
        pedido.setDescontoService(descontoService);
        when(descontoService.calcularDesconto(0.0)).thenReturn(0.0);
        assertEquals(0.0, pedido.calcularValorTotal());
    }

    //6 - Crie um teste unitário que envolva a classe Pedido e dois mocks de DescontoService diferentes.
    // Configure esses mocks para simular diferentes valores de desconto para diferentes itens do pedido
    // e verifique se o método calcularValorTotal calcula o valor total corretamente com base nos
    // descontos de cada item.

    @Test
    void simularDescontoComDoisMocks() {
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(50.0));
        itens.add(new ItemPedido(30.0));
        when(descontoService.calcularDesconto(50.0)).thenReturn(5.0); // 10% de desconto
        when(descontoService.calcularDesconto(30.0)).thenReturn(0.9); // 3% de desconto
        pedido.setItens(itens);
        pedido.setDescontoService(descontoService);
        assertEquals(74.1, pedido.calcularValorTotal());
    }

    //7 - Modifique a classe Pedido para registrar o número de vezes que o método calcularDesconto
    // do DescontoService é chamado. Crie um teste unitário que verifique se o método calcularValorTotal
    // chama o método calcularDesconto exatamente uma vez.
    @Test
    void simularQuantidadeDeVezesQueMetodoCalcularDescontoEhChamado() {
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido(50.0));
        pedido.setItens(itens);
        pedido.setDescontoService(descontoService);
        when(descontoService.calcularDesconto(50.0)).thenReturn(5.0);
        pedido.calcularValorTotal();
        verify(descontoService, times(1)).calcularDesconto(50.0);
        assertEquals(1, pedido.getChamadasCalcularDesconto());
    }
}


