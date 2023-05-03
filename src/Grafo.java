import java.util.ArrayList;

public class Grafo<TIPO> {

    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    // MÉTODO CONTRUTOR VAZIO PARA INCIALIZAÇÃO DAS LISTAS
    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    // MÉTODO PARA ADICIONAR AS VERTICES QUE RECEBE UM DADO
    public void adicionarVertice(TIPO dado) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    /*
     * MÉTODO PARA ADICIONAR AS ARESTAR QUE RECEBE:
     * UM PESO QUE INDICA O QUÃO FORTE É A RELAÇÃO ENTRE OS VERTICES,
     * UM DADO INICIAL QUE SERIA A PONTA INICIAL DA ARESTA,
     * E O DADO FIM É A PONTA FINAL
     */
    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        // CRIAÇÃO DA ARESTA
        Aresta<TIPO> aresta = new Aresta<>(peso, inicio, fim);
        // ADICIONANDO UMA ARESTA DE SAIDA NO VERTICE INICIAL
        inicio.adicionarArestaSaida(aresta);
        // ADICIONANDO UMA ARESTA DE ENTRADA AO VERTICE DE DESTINO
        fim.adicionarArestaEntrada(aresta);
        // PARA ARMAZENAR A ARESTA NO GRAFO
        this.arestas.add(aresta);
    }

    // MÉTODO PARA ACESSAR INFORMAÇÕES DAS VERTICES
    private Vertice<TIPO> getVertice(TIPO dado) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            /*
             * VALIDAÇÃO QUE SERVE PARA VERIFICAR
             * SE O VALOR NA POSIÇÃO i É IGUAL AO dado;
             */
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    /*
     * MÉTODO DE BUSCA DE LARGURA QUE SERVE PARA PODERMOS VIZUALIZAR O NOSSO GRAFO
     * A BUSCA EM LARGURA PEGA O VERTICE INICIAL E VISITA PARA ONDE ELE APONTA
     * VISITA TODAS AS ARESTAS VINCULADAS AO VERTICE E DEPOIS PULA PARA O PRIMEIRO VERTICE QUE VISITOU
     * E FAZ NOVAMENTE A MESMA COISA MARCANDO OS JÁ VISITADOS
     */
    public void BuscaEmLargura() {
        //INICILIALIZAÇÃO DE UMA LISTA PARA MARCAR OS QUE JÁ FORAM VISITADOS
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        
        //LISTA PARA GUARDAR EM UMA FILA OS VERTICES PARA PODER VISITA-LOS
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        
        //PEGA UM VERTICE DE UMA POSIÇÃO X DO GRAFO PARA PODER INICIALIZAR A BUSCA
        Vertice<TIPO> atual = this.vertices.get(4);
        
        //MARCANDO O VERTICE VISITADO
        marcados.add(atual);
        System.out.println(atual.getDado());
        
        //ADICIONANDO NA FILA DE MARCAÇÃO DE BUSCA
        fila.add(atual);
        
        //ENQUANTO TIVER VERTICES NA FILA ELE RODA
        while (fila.size() > 0) {
            
            //VARIAVEL PARA PERCORRER AS ARESTAS DE SAIDA DOS VERTICES
            Vertice<TIPO> visitado = fila.get(0);
            
            //LOOP PARA PERCORRER AS ARESTAS E ANDAR NO GRAFO
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                //VARIAVEL QUE SEMPRE VAI APONTAR O VERTICE NO FIM ARESTA
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                //VALIDAÇÃO PARA VER SE O VERTICE NÃO FOI MARCADO
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo); //ADICIONANDO ELE AOS MARCADOS
                    System.out.println(proximo.getDado());
                    fila.add(proximo); //ADICIONANDO ELE A FILA DE ELEMENTOS A SER VISITADOS
                }
            }
            fila.remove(0); //REMOVENDO O ELEMENTO QUE FOI VISITADO
        }
    }

}
