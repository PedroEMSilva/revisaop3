package utfpr.ct.dainf.if62c.avaliacao;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
 
/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class ProcessaLancamentos {
    private BufferedReader reader;
 
    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }
 
    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }
     
    private String getNextLine() throws IOException {
        String linha=reader.readLine();
        
        //reader.close();
        return linha;
        
    }
    // C:\Users\Cliente\Desktop\lancamentos.txt
    private Lancamento processaLinha(String linha) {
        Integer conta;
        int ano,mes,dia;
        String s;
        Double d;
        System.out.println("treta aqui ó");
        ano = Integer.parseInt(linha.substring(6, 10));
        System.out.println(ano);
        mes = Integer.parseInt(linha.substring(10, 12));
        dia = Integer.parseInt(linha.substring(12, 14));
       conta= parseInt(linha.substring(0,6));
       s = linha.substring(14, 74).trim();
       d= parseDouble(linha.substring(74, 86))/100;
        return new Lancamento(conta, new GregorianCalendar(ano, mes-1, dia).getTime(), s, d);
    }
     
    private Lancamento getNextLancamento() throws IOException {
      String linha =getNextLine();
        if(linha!= null){
           System.out.println(linha);
           return processaLinha(linha);
       }else{
           return null;
       }
    }
     
    public List<Lancamento> getLancamentos() throws IOException {
       List<Lancamento> l1=new ArrayList<>();
       Lancamento a;
       while((a=getNextLancamento())!=null){
           l1.add(a);
       }
       for(Lancamento l:l1){
           System.out.println(l);
       }
       l1.sort(new LancamentoComparator());
        System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
       for(Lancamento l:l1){
           System.out.println(l);
       }
       return l1;
    }
     
}