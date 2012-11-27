
package main;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * O programa Java abaixo pode ser utilizado como um exemplo de algoritmo guloso para o calculo do troco.
 * Faça intervenções no mesmo de modo que garanta o seu funcionamento normal no caso de querermos obter 
 * troco para R$ 0,37 (trinta e sete centavos) em moedas de 20, 15, 10 e 7 centavos
 */

public class Troco
{
    
    public static void main ( String[] args )
    {
        Scanner ler = new Scanner ( System.in );
        
        double conta , pago;
        
        try
        {
            System.out.printf ( "Informe o Valor da Conta : " );
            conta = ler.nextDouble ( );
            
            System.out.printf ( "Informe o Valor Pago     : " );
            pago = ler.nextDouble ( );
            
            System.out.printf ( "%s" , calculaTroco ( conta , pago ) );
        }
        
        catch ( InputMismatchException e )
        {
            System.err.printf ( "\nErro: dados informados inválidos !!!\n" );
        }
    }
    
    public static String calculaTroco ( double conta , double pago )
    {
        DecimalFormat formatador = new DecimalFormat ( "###,##0.00" );
        
        if ( pago < conta )
        {
            return ( "\nPagamento insuficiente, faltam R$ " + formatador.format ( conta - pago ) + "\n" );
            
        }
        
        else
        {
            int notas   [] = { 100 , 50 , 20 , 10 , 5 , 2 , 1 };
            //int centavos[] = { 50 , 25 , 10 , 5 , 1 };
            int centavos[] = { 20, 15, 10 , 7};
            
            String result;
            
            double troco;
            
            int i , vlr , ct;
            
            troco = pago - conta;
            result = "\nTroco = R$ " + formatador.format ( troco )
                    + "\n\n";
            
            // Contando as notas -->
            
            vlr = (int) troco; //valor em notas :D
            
            i = 0;
            
            
            
            while ( vlr != 0 )
            {
                ct = vlr / notas [ i ]; // calculando a qtde de notas
                System.out.println (ct);
                if ( ct != 0 )
                {
                    result = result + ( ct + " nota(s) de R$ " + notas [ i ] + "\n" );
                    vlr = vlr % notas [ i ]; // sobra
                }
                i = i + 1; // próxima nota
            }
            
            result = result + "\n";
            
            System.out.println ("Calculando o troco de moedas");
            
            // Contando as moedas -->
            vlr = (int) Math.round ( ( troco - (int) troco ) * 100 );
            System.out.println ("Quantidade inicial de centavos : "+vlr);
            i = 0;
            while ( vlr != 0 )
            {
                
                System.out.println ("\nVerificando as moedas de : "+centavos[i]);
                
                ct = vlr / centavos [ i ]; // calculando a qtde de moedas
                System.out.println (ct+" moedas de "+centavos[i]+" satisfazem");
                if ( ct != 0 )
                {
                 
                    if( vlr % centavos [ i ] >= 7 || vlr % centavos [ i ] == 0){
                    
                    result = result + ( ct + " moeda(s) de " +
                            centavos [ i ] + " centavo(s)\n" );
                    
                    vlr = vlr % centavos [ i ]; // sobra
                    }
                  
                }
                i = i + 1; // próximo centavo
                System.out.println ("restam "+vlr+" centavos para se calcular");
                
            }
            return ( result );
        }
    }
}