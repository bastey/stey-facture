package com.stey.facture.domain;

/**
 * @author BASTEY
 *
 */
public class DetailRepas
{

    /**
     * ex : le samedi soir, au vin d'honner...
     */
    private String definitionRepas;

    private int nbAdultes1;

    private int nbEnfants1;

    /**
     * @return the definitionRepas
     */
    public String getDefinitionRepas()
    {
        return definitionRepas;
    }

    /**
     * @param definitionRepas the definitionRepas to set
     */
    public void setDefinitionRepas( String definitionRepas )
    {
        this.definitionRepas = definitionRepas;
    }

    /**
     * @return the nbAdultes1
     */
    public int getNbAdultes1()
    {
        return nbAdultes1;
    }

    /**
     * @param nbAdultes1 the nbAdultes1 to set
     */
    public void setNbAdultes1( int nbAdultes1 )
    {
        this.nbAdultes1 = nbAdultes1;
    }

    /**
     * @return the nbEnfants1
     */
    public int getNbEnfants1()
    {
        return nbEnfants1;
    }

    /**
     * @param nbEnfants1 the nbEnfants1 to set
     */
    public void setNbEnfants1( int nbEnfants1 )
    {
        this.nbEnfants1 = nbEnfants1;
    }
}
