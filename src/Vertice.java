import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO dado;
    private ArrayList<Aresta<TIPO>> arestasEntrada;
    private ArrayList<Aresta<TIPO>> arestasSaida;

    /*
     * MÉTODO CONSTRUTOR QUE RECEBE UM VALOR,
     * E INICIALIZAR AS LISTAS DE ARESTAS DE ENTRADAS E SAIDAS
     * QUE SERVEM PARA DAR AS INFORMAÇÕES DO QUE ENTRA E SAI
     * DOS VERTICES
     */
    public Vertice(TIPO valor) {
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<TIPO>>();
        this.arestasSaida = new ArrayList<Aresta<TIPO>>();
    }

    // MÉTODOS ACESSORES DOS VERTICES
    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    public ArrayList<Aresta<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Aresta<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    /*
     * MÉTODO QUE PERMITE QUE NÓS ADICIONEMOS AS ARESTAS AOS VERTICES
     * TANTO DE ENTRADA QUANTO DE SAIDA
     */
    public void adicionarArestaEntrada(Aresta<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Aresta<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }
}
