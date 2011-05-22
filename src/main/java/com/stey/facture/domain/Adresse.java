package com.stey.facture.domain;

/**
 * @author BASTEY
 */
public class Adresse
{
    private String numeroEtNomRue;

    private String ville;

    private String codePostal;

    /**
     * @return the numeroEtNomRue
     */
    public String getNumeroEtNomRue()
    {
        return numeroEtNomRue;
    }

    /**
     * @param numeroEtNomRue the numeroEtNomRue to set
     */
    public void setNumeroEtNomRue( String numeroEtNomRue )
    {
        this.numeroEtNomRue = numeroEtNomRue;
    }

    /**
     * @return the ville
     */
    public String getVille()
    {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille( String ville )
    {
        this.ville = ville;
    }

    /**
     * @return the codePostal
     */
    public String getCodePostal()
    {
        return codePostal;
    }

    /**
     * @param codePostal the codePostal to set
     */
    public void setCodePostal( String codePostal )
    {
        this.codePostal = codePostal;
    }

}
