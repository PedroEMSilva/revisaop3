import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;
/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
       Scanner scanner = new Scanner(System.in); 
       String caminho;
        System.out.println("O caminho plox:  ");
        if (scanner.hasNext()) {
            caminho = scanner.next();
        } else {
            while (!scanner.hasNext()) {
                System.out.println("Digite uma posicao valida");

            }
            caminho = scanner.next();
        }
        ProcessaLancamentos p= new ProcessaLancamentos(caminho);
        List<Lancamento> list=p.getLancamentos();
         int numItens;
        System.out.print("Digite a conta plox: ");
        if (scanner.hasNextInt()) {
            numItens = scanner.nextInt();
        } else {
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um numero!");
                scanner.next();
            }
            numItens = scanner.nextInt();
        }
        System.out.println(list);
        exibeLancamentosConta(list,numItens);
        
        
    }
     
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {
        System.out.println("chamei a funãoç");
        for(Lancamento l:lancamentos){
            //System.out.println(String.format("%d e %d", conta,l.getConta()));
           if((double)l.getConta()== (double)conta){
               System.out.println(l);
           }
       }
    }
  
}

