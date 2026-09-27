public class Data implements Comparable<Data>, Cloneable
{
    private byte  dia, mes;
    private short ano;

    private static int qtd=0;

    public static int getQtd ()
    {
        return Data.qtd;
    }

    public static boolean isBissexto (short ano)
    {
        // Calendario Juliano
        if (ano<1582)
            if (ano%4==0)
                return true;
            else
                return false;

        // Calendario Gregoriano
        if (ano%400==0) return true;
        if (ano%  4==0 && ano%100!=0) return true;
        return false;
    }

    public static boolean isValida (byte dia, byte mes, short ano)
    {
        if (ano<-45) return false; // antes do Calendario Juliano
        if (ano== 0) return false; // nao existiu ano 0; do ano 1ac foi direto para o ano 1dc
        if (ano==1582 && mes==10 && dia>=5 && dia<=14) return false; // dias cortados dos calendario pelo Papa Gregorio

        if (dia<1 || dia>31 || mes<1 || mes>12) return false;

        if (dia>30 && (mes==4 || mes==6 || mes==9 || mes==11)) return false;
        if (dia>29 && mes==2) return false;
        if (dia>28 && mes==2 && !Data.isBissexto(ano)) return false;

        return true;
    }

    public /*void*/ Data (byte dia, byte mes, short ano) throws Exception
    {
        if (!Data.isValida(dia,mes,ano))
            throw new Exception ("Data invalida");

        this.dia=dia;
        this.mes=mes;
        this.ano=ano;

        Data.qtd++;
    }

    public void setDia (byte dia) throws Exception
    {
        if (!Data.isValida(dia,this.mes,this.ano))
            throw new Exception ("Dia invalido");

        this.dia=dia;
    }

    public byte getDia ()
    {
        return this.dia;
    }
    
    public void setMes (byte mes) throws Exception
    {
        if (!Data.isValida(this.dia,mes,this.ano))
            throw new Exception ("Mes invalido");

        this.mes=mes;
    }

    public byte getMes ()
    {
        return this.mes;
    }
    
    public void setAno (short ano) throws Exception
    {
        if (!Data.isValida(this.dia,this.mes,ano))
            throw new Exception ("Ano invalido");

        this.ano=ano;
    }

    public short getAno ()
    {
        return this.ano;
    }

    public void avanceUmDia () // altera o this
    {
        byte novoDia = (byte)(this.dia + 1);

        if (Data.isValida(novoDia, this.mes, this.ano)) {
            this.dia = novoDia;
        } 
        else {
            this.dia = 1;
            this.mes = (byte)(this.mes + 1);
            if(this.mes == 13){
                this.mes = 1;
                this.ano += 1;
            }
        }
    }

    public void avanceVariosDias (int qtd) throws Exception // altera o this
    {
        if (qtd < 0){
            throw new Exception("Quantidade invalida");
        }
        for (int i = 0; i < qtd; i++){
            this.avanceUmDia();
        }
    }

    public Data getDiaSeguinte () throws Exception // não altera o this
    {
        byte diaSeguinte = (byte)(this.dia + 1);
        byte mesSeguinte = (byte)(this.mes);
        short anoSeguinte = (short)(this.ano);

        if (!Data.isValida(diaSeguinte, this.mes, this.ano)) {
            diaSeguinte = 1;
            mesSeguinte += 1;
            if (mesSeguinte == 13) {
                mesSeguinte = 1;
                anoSeguinte += 1;
            }
        }
        return new Data(diaSeguinte, mesSeguinte, anoSeguinte);
    }

    public Data getVariosDiasAdiante (int qtd) throws Exception // não altera o this
    {
        if (qtd < 0) {
            throw new Exception("Quantidade invalida");
        }

        Data resultado = new Data(this.dia, this.mes, this.ano);

        for (int i = 0; i < qtd; i++) {
            resultado = resultado.getDiaSeguinte();
        }
        return resultado;
    }

    public void retrocedaUmDia () // altera o this
    {
        byte retrocederDia = (byte)(this.dia - 1);

        if (Data.isValida(retrocederDia, this.mes, this.ano)) {
            this.dia = retrocederDia;
        } else {
            byte mesAnterior = (byte)(this.mes - 1);
            short anoAnterior = this.ano;

            if (mesAnterior == 0) {
                mesAnterior = 12;
                anoAnterior -= 1;
            }

            byte ultimoDia = 31;
            for (byte i = 31; i >= 28; i--) {
                if (Data.isValida(i, mesAnterior, anoAnterior)) {
                    ultimoDia = i;
                    break;
                }
            }

            this.dia = ultimoDia;
            this.mes = mesAnterior;
            this.ano = anoAnterior;
        }
    }

    public void retrocedaVariosDias (int qtd) throws Exception // altera o this
    {
        if (qtd < 0){
            throw new Exception ("Quantidade invalida");
        }

        for (int i = 0; i < qtd; i++){
            this.retrocedaUmDia();
        }
    }

    public Data getDiaAnterior () throws Exception // não altera o this
    {
        byte diaAnterior = (byte)(this.dia - 1);
        byte mesAnterior = (byte)(this.mes);
        short anoAnterior = (short)(this.ano);

        if (!Data.isValida(diaAnterior, this.mes, this.ano)){
            mesAnterior = (byte)(this.mes - 1);
            if (mesAnterior == 0){
                mesAnterior = 12;
                anoAnterior -= 1;
            }
            for (byte i = 31; i >= 28; i--) {
                if (Data.isValida(i, mesAnterior, anoAnterior)) {
                    diaAnterior = i;
                    break;
                }
            }
        }

        return new Data (diaAnterior, mesAnterior, anoAnterior);
    }

    public Data getVariosDiasAtras (int qtd) throws Exception // não altera o this
    {
        if (qtd < 0) {
            throw new Exception("Quantidade invalida");
        }

        Data resultado = new Data(this.dia, this.mes, this.ano);

        for (int i = 0; i < qtd; i++) {
            resultado = resultado.getDiaAnterior();
        }
        return resultado;
    }

    @Override
    public String toString ()
    {
        return (this.dia<10?"0":"")+
                this.dia + "/" +
               (this.mes<10?"0":"")+
                this.mes + "/" +
               (this.ano<0?(-this.ano)+"ac":this.ano);
    }
    
    // compara this e obj
    @Override
    public boolean equals (Object obj)
    {
        if (obj==this) return true;
        if (obj==null) return false; // this nunca é null
        if (obj.getClass() != this.getClass()) return false; // sei que this.getClass() é Data
        Data d = (Data)obj;
        if (d.dia!=this.dia) return false;
        if (d.mes!=this.mes) return false;
        if (d.ano!=this.ano) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int retorno=1; /* um nº natural qualquer, menos o zero */

        retorno = retorno * 2 /* um nº primo qualquer */ + ((Byte) this.dia).hashCode();
        retorno = retorno * 2 /* um nº primo qualquer */ + ((Byte) this.mes).hashCode();
        retorno = retorno * 2 /* um nº primo qualquer */ + ((Short)this.ano).hashCode();

        if (retorno<0) retorno=-retorno;
        return retorno;
    }

    // compara this e dat e retorna:
    // um inteiro positivo se this for maior que dat;
    // zero se this for igual a dat; ou
    // um inteiro negativo se this for menor que dat.
    @Override
    public int compareTo (Data dat)
    {
        if (this.ano<dat.ano) return -666;
        if (this.ano>dat.ano) return  666;
        if (this.mes<dat.mes) return -666;
        if (this.mes>dat.mes) return  666;
        if (this.dia<dat.dia) return -666;
        if (this.dia>dat.dia) return  666;
        return 0;
    }

    // construtor de cópia
    public /*void*/ Data (Data modelo) throws Exception
    {
        if (modelo==null) throw new Exception ("Modelo ausente");

        this.dia=modelo.dia;
        this.mes=modelo.mes;
        this.ano=modelo.ano;
    }

    @Override
    public Object clone ()
    {
        Data retorno=null;

        try
        {
            retorno = new Data (this);
        }
        catch (Exception erro)
        {} // sei que nao vai dar exceção pq o construtor de copia só da erro 
           // quando recebe um null no parametro e está sendo fornecido o this
           // e o this nunca é null

        return retorno;
    }
}