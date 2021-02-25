package com.alexandre.cursos.resources.exeption;

import java.util.ArrayList;
import java.util.List;

public class ValidationError  extends StandartError  {

    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(int status, String msg, Long timeStemp) {
        super(status, msg, timeStemp);
    }
    public List<FieldMessage> getErrors(){
        return  errors;
    }
    public void addError(String fielname, String messagem){
        errors.add(new FieldMessage(fielname, messagem));
    }

}