/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.calegario.ws;


import br.com.calegario.entidade.EnderecoDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 *
 * @author vinicius.kegler
 */
public class CepRest {
    
    private Client client;
    private WebResource webResource;
    
    public CepRest(){
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://viacep.com.br/ws/");
    }
    
    public EnderecoDTO pesquisaCep(String cep){
        try {
            return webResource.path(cep).path("/json").get(EnderecoDTO.class);
        } catch (UniformInterfaceException | ClientHandlerException ue) {
            System.out.println(ue.getMessage());
            return null;
        }
    }
}
