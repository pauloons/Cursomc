package com.alexandre.cursos.services.validation;

import com.alexandre.cursos.dto.ClienteNewDTO;
import com.alexandre.cursos.resources.exeption.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import com.alexandre.cursos.domain.enums.Tipo_Cliente;
import com.alexandre.cursos.services.validation.utils.Br;


public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
// inclua os testes aqui, inserindo erros na lista

        if(objDto.getTipo().equals(Tipo_Cliente.PESSOAFISICA.getCod()) && !Br.isValidCPF(objDto.getCpfOuCnpj()) )  {

            list.add(new FieldMessage("cpfOuCnpj","CPF Inválido"));
        }

        if(objDto.getTipo().equals(Tipo_Cliente.PESSOAJURIDICA.getCod()) && !Br.isValidCNPJ(objDto.getCpfOuCnpj()) )  {

            list.add(new FieldMessage("cpfOuCnpj","CNPJ Inválido"));
        }



        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}