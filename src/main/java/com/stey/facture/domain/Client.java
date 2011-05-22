package com.stey.facture.domain;

/**
 * @author BASTEY
 *
 */
public class Client
{

    private String civilite;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String numeroTelephone;

    /**
     * @return the civilite
     */
    public String getCivilite()
    {
        return civilite;
    }

    /**
     * @param civilite the civilite to set
     */
    public void setCivilite( String civilite )
    {
        this.civilite = civilite;
    }

    /**
     * @return the nom
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom( String nom )
    {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom()
    {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom( String prenom )
    {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public Adresse getAdresse()
    {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse( Adresse adresse )
    {
        this.adresse = adresse;
    }

    /**
     * @return the numeroTelephone
     */
    public String getNumeroTelephone()
    {
        return numeroTelephone;
    }

    /**
     * @param numeroTelephone the numeroTelephone to set
     */
    public void setNumeroTelephone( String numeroTelephone )
    {
        this.numeroTelephone = numeroTelephone;
    }
}
