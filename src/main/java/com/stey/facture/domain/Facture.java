package com.stey.facture.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author BASTEY
 *
 */
public class Facture
{
    private List<Client> clients = new ArrayList<Client>();

    private String nomRepas;

    private Date dateRepas;

    private String nomSalle;

    private List<Produit> produits = new ArrayList<Produit>();

    private List<DetailRepas> detailsRepas = new ArrayList<DetailRepas>();

    /**
     * @return the clients
     */
    public List<Client> getClients()
    {
        return clients;
    }

    /**
     * @return the nomRepas
     */
    public String getNomRepas()
    {
        return nomRepas;
    }

    /**
     * @return the dateRepas
     */
    public Date getDateRepas()
    {
        return dateRepas;
    }

    /**
     * @return the produits
     */
    public List<Produit> getProduits()
    {
        return produits;
    }

    /**
     * @return the nomSalle
     */
    public String getNomSalle()
    {
        return nomSalle;
    }

    /**
     * @param nomRepas the nomRepas to set
     */
    public void setNomRepas( String nomRepas )
    {
        this.nomRepas = nomRepas;
    }

    /**
     * @param dateRepas the dateRepas to set
     */
    public void setDateRepas( Date dateRepas )
    {
        this.dateRepas = dateRepas;
    }

    /**
     * @param nomSalle the nomSalle to set
     */
    public void setNomSalle( String nomSalle )
    {
        this.nomSalle = nomSalle;
    }

    /**
     * @return the detailsRepas
     */
    public List<DetailRepas> getDetailsRepas()
    {
        return detailsRepas;
    }
}
