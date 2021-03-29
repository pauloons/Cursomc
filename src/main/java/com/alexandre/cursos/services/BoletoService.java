package com.alexandre.cursos.services;

import com.alexandre.cursos.domain.Pagamento_Com_Boleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
//acrescenta uma data de vencimento 07 dias apos a data instante
public class BoletoService {
    public void preencherPagamentoComBoleto(Pagamento_Com_Boleto pgto, Date instateDoPedido) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pgto.setData_Vencimento(cal.getTime());
    }
}
