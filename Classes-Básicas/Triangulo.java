public class Triangulo
{
    private double ladoA, ladoB, ladoC;

    public Triangulo (double ladoA, double ladoB, double ladoC) throws Exception
    {
        if ((ladoA + ladoB) <= ladoC){
            throw new Exception("Triângulo inválido");
        }
        if ((ladoA + ladoC) <= ladoB) {
            throw new Exception("Triângulo inválido");
        }
        if ((ladoC + ladoB) <= ladoA) {
            throw new Exception("Triângulo inválido");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public String getTipo ()
    {
        if (ladoA == ladoB && ladoA == ladoC){
            return "O triângulo é equilátero";
        }
        if (ladoA == ladoB && ladoA != ladoC || ladoB == ladoC && ladoB != ladoA){
            return "O triângulo é isósceles";
        }
        if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC) {
            return "O triângulo é escaleno!";
        }
        
        return "Erro: tipo nao identificado";
    }

    public double getPerimetro ()
    {
        double perimetro = 0.0;
        perimetro = (this.ladoA) + (this.ladoB) + (this.ladoC);

        return perimetro;
    }
}