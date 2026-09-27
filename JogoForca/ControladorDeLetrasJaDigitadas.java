public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++){
            if (this.letrasJaDigitadas.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
        if (this.isJaDigitada(letra)) {
            throw new Exception("Letra já digitada!");
        }
        
        this.letrasJaDigitadas += letra;
    }

    @Override
    public String toString ()
    {
        String letrasSepa = "";
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++){
            letrasSepa += this.letrasJaDigitadas.charAt(i) + ",";
        }
        return letrasSepa;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        
        ControladorDeLetrasJaDigitadas l = (ControladorDeLetrasJaDigitadas)obj;

        if (!l.letrasJaDigitadas.equals(this.letrasJaDigitadas)) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno = 1;
        retorno = retorno * 2 + this.letrasJaDigitadas.hashCode();
        if (retorno < 0) retorno = -retorno;

        return retorno;
    }

    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas) throws Exception
    {
        if (controladorDeLetrasJaDigitadas == null) {
            throw new Exception("Controlador nulo!");
        }

        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    @Override
    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas retorno = null;

        try {
            retorno = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception erro){}
            return retorno;
    }
}
