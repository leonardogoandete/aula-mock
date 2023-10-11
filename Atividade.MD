Exercícios:

1 - Crie um teste unitário para a classe Pedido que configure um mock do DescontoService para simular um desconto de 10% e verifique se o método calcularValorTotal retorna o valor correto após aplicar o desconto.

2- Crie um teste unitário para a classe Pedido que simule um cenário em que o desconto seja zero e verifique se o método calcularValorTotal retorna o valor correto sem desconto.

3 - Crie outro teste unitário que simule um cenário em que o desconto seja maior que o valor total do pedido e verifique se o método calcularValorTotal retorna 0.0, ou seja, o valor total não pode ser negativo.

4 - Adicione uma validação no método calcularValorTotal da classe Pedido para lançar uma exceção IllegalArgumentException se o valor total for negativo após aplicar o desconto. Crie um teste unitário que verifique se essa exceção é lançada corretamente.

5 - Modifique a classe Pedido para aceitar uma lista vazia de itens. Crie um teste unitário que simule esse cenário e verifique se o método calcularValorTotal retorna 0.0 quando não há itens no pedido.

6 - Crie um teste unitário que envolva a classe Pedido e dois mocks de DescontoService diferentes. Configure esses mocks para simular diferentes valores de desconto para diferentes itens do pedido e verifique se o método calcularValorTotal calcula o valor total corretamente com base nos descontos de cada item.

7 - Modifique a classe Pedido para registrar o número de vezes que o método calcularDesconto do DescontoService é chamado. Crie um teste unitário que verifique se o método calcularValorTotal chama o método calcularDesconto exatamente uma vez.