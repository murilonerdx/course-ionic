package com.murilo.cursomc.service;

import com.murilo.cursomc.model.pagamento.entity.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class SlipService {

    public void fillPayment(PagamentoComBoleto pay, Date instant) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(instant);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        pay.setDataPagamento(cal.getTime());
    }
}
