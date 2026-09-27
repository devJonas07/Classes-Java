public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax <= 0){
            throw new Exception("Quantidade máxima deve ser positiva");
        }

        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr == this.qtdMax) {
            throw new Exception("Quantidade máxima de erros atingida");
        }
        else {
            this.qtdErr++;
        }
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr == this.qtdMax){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + " de " + this.qtdMax;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        ControladorDeErros c = (ControladorDeErros)obj;

        if (c.qtdMax != this.qtdMax) return false;
        if (c.qtdErr != this.qtdErr) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno = 1;

        retorno = retorno * 2 + ((Integer) this.qtdMax).hashCode();
        retorno = retorno * 2 + ((Integer) this.qtdErr).hashCode();
        
        if (retorno < 0){
            retorno = -retorno;
        }

        return retorno;
    }  

    public ControladorDeErros (ControladorDeErros c) throws Exception
    {
        if (c == null) {
            throw new Exception("Modelo ausente!");
        }

        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }

    @Override
    public Object clone ()
    {
        ControladorDeErros retorno = null;

        try{
            retorno = new ControladorDeErros(this);
        }
        catch (Exception erro){}
            return retorno;
    }
}
