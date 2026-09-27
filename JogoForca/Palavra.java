public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if (texto == null || texto.equals("")) {
            throw new Exception("O texto é nulo, ou vazio!");
        }

        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        int contador = 0;
        for (int i = 0; i < this.texto.length(); i++){
            if (letra == this.texto.charAt(i)) {
                contador++;
            }
        }

        return contador;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int ocorrenciasRegistradas = 0;

        for (int pos = 0; pos < this.texto.length(); pos++) {
            if (this.texto.charAt(pos) == letra) {
                if (ocorrenciasRegistradas == i) {
                    return pos;
                }
                ocorrenciasRegistradas++;
            }
        }

        throw new Exception("Ocorrencia nao encontrada");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Palavra p = (Palavra)obj;
        if (!p.texto.equals(this.texto)) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno = 1;
        retorno = retorno * 2 + this.texto.hashCode();

        if (retorno < 0) retorno = -retorno;
        return retorno;
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
