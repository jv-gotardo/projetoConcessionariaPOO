/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import modelo.enums.StatusAgendamento;
import modelo.marca.Veiculo;
import modelo.pessoa.Cliente;
import modelo.pessoa.Vendedor;

/**
 *
 * @author jvito
 */
public class AgendamentoTestDrive {
    private static Venda venda;
    private Cliente cliente = venda.getCliente();
    private Veiculo veiculo = venda.getVeiculo();
    private Vendedor vendedor = venda.getVendedor();
    private LocalDate dataAgendamento;
    private LocalDateTime horarioPrevisto;
    private StatusAgendamento statusAgendamento;
}
