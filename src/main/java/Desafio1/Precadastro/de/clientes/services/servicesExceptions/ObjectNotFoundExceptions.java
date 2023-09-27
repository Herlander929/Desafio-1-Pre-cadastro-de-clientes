package Desafio1.Precadastro.de.clientes.services.servicesExceptions;

public class ObjectNotFoundExceptions extends  RuntimeException {

    public ObjectNotFoundExceptions(String msg)
    {

        super(msg);
    }
    public ObjectNotFoundExceptions(String msg, Throwable cause)
    {
        super(msg, cause);
    }
}
