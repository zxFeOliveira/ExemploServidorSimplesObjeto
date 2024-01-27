package com.redes.aula3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    
    private static Socket conexao;
    private static ObjectOutputStream saida;
    private static DataInputStream entrada;
    
    public static void main(String[] args) {
        
        try {
            conexao = new Socket("127.0.0.1",55000);
            Pessoa p = new Pessoa();
            p.setNome("Rogério");
            p.setIdade(51);
            saida = new ObjectOutputStream(conexao.getOutputStream());
            saida.writeObject(p);
            
            entrada = new DataInputStream(conexao.getInputStream());
            String resposta = entrada.readUTF();
            System.out.println("Resposta do servidor: " + resposta);
            
            conexao.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
