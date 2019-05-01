package TrieTree;

public class Node {
    public Node fillDret;
    public Node fillEsquerra;
    public Node pare;
    public int altura;

    public char lletra;

    public Node(char lletra) {
        this.lletra = lletra;
        altura = 1;
    }



    public Node getFillDret() {
        return fillDret;
    }

    public void setFillDret(Node fillDret) {
        this.fillDret = fillDret;
    }

    public Node getFillEsquerra() {
        return fillEsquerra;
    }

    public void setFillEsquerra(Node fillEsquerra) {
        this.fillEsquerra = fillEsquerra;
    }

    public Node getPare() {
        return pare;
    }

    public void setPare(Node pare) {
        this.pare = pare;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public char getLletra() {
        return lletra;
    }

    public void setLletra(char lletra) {
        this.lletra = lletra;
    }
}
