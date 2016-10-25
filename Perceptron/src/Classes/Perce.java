/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author Gilson
 */
public class Perce {
    public static int tam=16;
    static int[][] pontos = {
            {0, 0, -1},
            {0, 1, -1},
            {0, 2, -1},
            {0, 3, 1},
            {1, 0, -1},
            {1, 1, -1},
            {1, 2, -1},
            {1, 3, 1},
            {2, 0, -1},
            {2, 1, -1},
            {2, 2, -1},
            {2, 3, 1},
            {3, 2, 1},
            {3, 3, 1},
            {4, 2, 1},
            {4, 3, 1}
        };

    public static double w1=1, w2=1, n=0.5, r=1;
    public static Scanner ler = new Scanner(System.in);

    public static void preencher() {
        System.out.println("Digite a taxa de aprendizado: ");
        n = ler.nextDouble();
        System.out.println("Digite X1: ");
        w1 = ler.nextDouble();
        System.out.println("Digite X2: ");
        w2 = ler.nextDouble();
        System.out.println("Digite o resultado: ");
        r = ler.nextDouble();
        boolean condicao = false;
        int op;
        while (!condicao) {
            if(w2>0)
                System.out.println("Sua função é essa? > " + w1 + "X1+" + w2 + "X2=" + r);
            else
                System.out.println("Sua função é essa? > " + w1 + "X1" + w2 + "X2=" + r);
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            op = ler.nextInt();
            if (op == 1) {
                condicao = true;
            }
            if (op == 2) {
                condicao = false;
            }
        }
    }
    
    public static boolean acabou(boolean[] verifica){
        for(int k =0; k<verifica.length;k++){
            if(!verifica[k])
                return false;
        }
        return true;
    }

    public static double[] calcular() {
        //preencher();
        double w3=-r;
        boolean[] verifica=new boolean[tam];
        boolean fim=false;
        int x1,x2,x3=1,t;
        double f;        
        while (!fim) {
            for (int i = 0; i < tam; i++) {
                x1=pontos[i][0];
                x2=pontos[i][1];
                t=pontos[i][2];
                f=w1*x1+w2*x2+w3*x3;
                if(t>0&&f<0){
                    w1=w1+(1)*x1*n;
                    w2=w2+(1)*x2*n;
                    w3=w3+(1)*x3*n;
                    verifica[i]=false;
                }else
                if(t<0&&f>0){
                    w1=w1+(-1)*x1*n;
                    w2=w2+(-1)*x2*n;
                    w3=w3+(-1)*x3*n;
                    verifica[i]=false;
                }else{
                    verifica[i]=true;
                }
            }
            fim= acabou(verifica);
        }
        r=-w3;
        
        if(w2>0)
            System.out.println("Sua função é essa? > " + w1 + "X1+" + w2 + "X2=" + r);
        else
            System.out.println("Sua função é essa? > " + w1 + "X1" + w2 + "X2=" + r);
        double[] vet = {w1,-w2,r};
        return vet;

    }
}
