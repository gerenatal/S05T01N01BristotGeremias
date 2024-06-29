package cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.exceptions;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(String message){
        super(message);
    }
}
