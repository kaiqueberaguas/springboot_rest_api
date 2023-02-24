package br.com.example.api.utils;

public class StringUtils {
    
    public static boolean isNullOrEmpty(String target){
        return target == null || target.trim().length() == 0;
    }

    public static String toCaptalize(String target){

        if(!StringUtils.isNullOrEmpty(target)){
            var primeiraLetra = target.substring(0,1).toUpperCase();
            var restoPalavra = target.substring(1,target.length()).toLowerCase();
            return primeiraLetra + restoPalavra;
        }
        return "";
    }

    private StringUtils(){
        super();
    }
}