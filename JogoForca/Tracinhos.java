public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if (qtd <= 0){
            throw new Exception("Quantidade deve ser positiva!");
        }
        this.texto = new char[qtd];

        for (int i = 0; i < this.texto.length; i++){
            this.texto[i] = '_';
        }
    }

    public void revele (int posicao, char letra) throws Exception
    {
        if (posicao < 0 || posicao >= this.texto.length){
            throw new Exception("Posição inválida");
        }
        if (this.texto[posicao] != '_'){
            throw new Exception("Texto inválido");
        }

        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for (int i = 0; i < this.texto.length; i++){
            if (this.texto[i] == '_'){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString ()
    {
        String resultado = "";
        for (int i = 0; i < this.texto.length; i++){
            resultado += this.texto[i] + " ";
        }

        return resultado;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Tracinhos t = (Tracinhos)obj;

        if (t.texto.length != this.texto.length) return false;

        for (int i = 0; i < this.texto.length; i++) {
            if (t.texto[i] != this.texto[i]) return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno = 1;

        for (int i = 0; i < this.texto.length; i++) {
            retorno = retorno * 2 + ((Character)this.texto[i]).hashCode();
        }

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de cópia
    {
        if (t == null) {
            throw new Exception("Modelo ausente");
        }

        this.texto = new char[t.texto.length];

        for (int i = 0; i < t.texto.length; i++) {
            this.texto[i] = t.texto[i];
        }
    }

    @Override
    public Object clone ()
    {
        Tracinhos retorno = null;

        try {
            retorno = new Tracinhos(this);
        }
        catch (Exception erro) {}

        return retorno;
    }
}
