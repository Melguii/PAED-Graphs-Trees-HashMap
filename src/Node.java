public class Node {

    private int numero;

    //profunditat d'aquest node sent 0 el node root i altura + 1 conforme anem baixant per cada fill
    private int altura;
    private int profunditat;
    
    private int balanceFactor;

    private int alturaMaxDreta;
    private int alturaMinDreta;

    private int alturaMaxEsquerra;
    private int alturaMinEsquerra;

    private Node pare;

    private Node filldret;
    private Node fillEsquerra;

    public Node(int numero){

        this.numero = numero;
    }

    public int getNumero(){

        return this.numero;
    }

    public void add(Node node, ArbreAVL arbre){

        if (node.getNumero() > numero) { //ex: numero actual 5 numero a inserir el 7
                                        // 7 al fill dret
            if (filldret != null) {

                filldret.add(node, arbre);

                if (fillEsquerra != null){

                    if (fillEsquerra.getAltura() < filldret.getAltura()){

                        altura = filldret.getAltura()+1;
                    }else {
                        altura = fillEsquerra.getAltura()+1;
                    }
                }else{

                    altura = filldret.getAltura()+1;
                }
            }else{
                filldret = node;
                filldret.setPare(this);
                filldret.setProfunditat(1);
                if (fillEsquerra != null){
                    if  (fillEsquerra.getAltura() >filldret.getAltura() ){
                        altura = fillEsquerra.getAltura()+1;
                    }else{
                        altura = filldret.getAltura()+1;
                    }
                }else{
                    altura = filldret.getAltura()+1;
                }

            }
        }else {

            if (fillEsquerra != null) {

                fillEsquerra.add(node, arbre);

                if (filldret != null){

                    if (fillEsquerra.getAltura() < filldret.getAltura()){

                        altura = filldret.getAltura()+1;
                    }else {
                        altura = fillEsquerra.getAltura()+1;
                    }
                }else{

                    altura = fillEsquerra.getAltura()+1;
                }
            }else{

                fillEsquerra = node;
                fillEsquerra.setPare(this);
                fillEsquerra.setProfunditat(this.profunditat+1);

                if (filldret != null){
                    if  (fillEsquerra.getAltura() > filldret.getAltura() ){
                        altura = fillEsquerra.getAltura()+1;
                    }else{
                        altura = filldret.getAltura()+1;
                    }
                }else{
                    altura = fillEsquerra.getAltura()+1;
                }

            }

            if (fillEsquerra.getAltura() - filldret.getAltura() >= 2 || fillEsquerra.getAltura() - filldret.getAltura() <= -2){
                //rotacions cas esquerra -> rotacions cap a la dreta

                //left left case = right rotation

                if (fillEsquerra.getFilldret().getAltura() < fillEsquerra.getFillEsquerra().getAltura()){
                    //ens guardem el fill esquerra el cual ara sera el pare en un node auxiliar
                    Node auxiliar = fillEsquerra;

                    //posem com a fill esquerra el node mes semblant per la esquerra (el fill dret del nostre fill esquerre)
                    fillEsquerra = fillEsquerra.getFilldret();
                    fillEsquerra.setPare(this);

                    //posem el node actual com a fill dret del auxiliar (el que abans ere el nostre fill esquerra)
                    //si abans era el nostre fill esquerra vol dir que erem un nombre menor al seu
                    //per tant aquest fill al "pujar" tinddra un nombre menor al pare i aquest passara a ser un fill dret
                    auxiliar.setFilldret(this);

                    //si el node no era root
                    if (pare != null){
                        //posem el nou fill dret o esquerra del node pare
                        if (pare.getFilldret().equals(this)){
                            pare.setFilldret(auxiliar);
                        }else{
                            pare.setFillEsquerra(auxiliar);
                        }
                    }else{
                        //si el node es root hem de modificar la classe arbre
                        arbre.setRoot(auxiliar);
                        auxiliar.setPare(null);
                    }

                    pare = auxiliar;
                    //definim les noves altures
                    definirAltura();
                    auxiliar.definirAltura();
                    if (pare != null){
                        pare.definirAltura();
                    }

                }

            }
        }



        //definirAltura();
    }

    public void setProfunditat(int profunditat){

        this.profunditat = profunditat;
    }

    public void setPare(Node node){
        this.pare = node;
    }

    /*  tipus = 1: PreOrdre
                2: InOrdre
                3: PostOrdre
     */
    public void visualitza(int tipus){
        if  (tipus == 1){
            printNode();
        }

        if (fillEsquerra != null){
            fillEsquerra.visualitza(tipus);
        }

        if (tipus == 2) {
            printNode();
        }

        if (filldret != null){
            filldret.visualitza(tipus);
        }

        if (tipus == 3){
            printNode();
        }
    }

    public void printNode() {
        for (int i = 0; i < altura; i++){
            System.out.print("--");
        }
        System.out.print(">");

        if (pare == null) {
            System.out.println("Root Node: " + numero + ", Altura: " + altura);
        } else if (pare.numero < numero) {
            System.out.println("Right Node: " + numero + ", Altura: " + altura);
        } else if (pare.numero > numero){
            System.out.println("Left Node: " + numero + ", Altura: " + altura);
        }
    }

    //Mitjançant un PostOrder redefinim l'alçada de tots els nodes
    public void definirAltura() {
        if (fillEsquerra != null){
            fillEsquerra.definirAltura();
        }
        if (filldret != null){
            filldret.definirAltura();
        }

        if (filldret == null && fillEsquerra == null) {
            altura = 0;
        } else if (filldret == null) {
            altura = fillEsquerra.altura + 1;
        } else if (fillEsquerra == null) {
            altura = filldret.altura + 1;
        } else if (fillEsquerra.altura > filldret.altura) {
            altura = fillEsquerra.altura + 1;
        } else {
            altura = filldret.altura + 1;
        }

    }

    public int getAltura(){

        return altura;
    }

    public Node getFillEsquerra(){

        return fillEsquerra;
    }

    public Node getFilldret(){

        return filldret;
    }

    public void setFillEsquerra(Node fill){

        fillEsquerra = fill;
    }

    public void setFilldret(Node fill){

        filldret = fill;
    }

}
