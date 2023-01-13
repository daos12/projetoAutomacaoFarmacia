package util;
public class Formatador {
    
    //converte numeros com virgula para ponto, para o banco de dados
    public double converterVirgula(String pString){
        String retorno = new String();
        
        int tamanhoString = pString.length();
        
        for (int i = 0; i < tamanhoString; i++) {
            if (pString.charAt(i) == ',') {
                retorno += '.';
            } else {
                retorno += pString.charAt(i);
            } 
        }
        return Double.parseDouble(retorno);
    }
}
