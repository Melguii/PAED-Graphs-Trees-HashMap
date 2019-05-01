package TrieTree;

public class Root {
    public char[] abecedari = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Node fillDret;
    public Node fillEsquerra;
    public Node pare;
    public int altura;

    public Root() {
        pare = null;
        altura = 1;
    }





    public char[] getAbecedari() {
        return abecedari;
    }

    public void setAbecedari(char[] abecedari) {
        this.abecedari = abecedari;
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
}
