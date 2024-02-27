package model.exceptions;

public class DomainException extends Exception{

    private static final long serialVersionUID = 1L;
    //Quando temos uma classe serilizabled, precisamos ter um serial version

    public DomainException (String msg){
        super(msg);
    }
}
