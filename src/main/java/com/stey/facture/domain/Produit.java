package com.stey.facture.domain;



/**
 * @author BASTEY
 *
 */
public class Produit
{
    private String fournisseur;

    private String nom;

    private Double prixTTC;

    /**
     * @return the fournisseur
     */
    public String getFournisseur()
    {
        return fournisseur;
    }

    /**
     * @return the nom
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * @return the prixTTC
     */
    public Double getPrixTTC()
    {
        return prixTTC;
    }

    /**
     * @param fournisseur the fournisseur to set
     */
    public void setFournisseur( String fournisseur )
    {
        this.fournisseur = fournisseur;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom( String nom )
    {
        this.nom = nom;
    }

    /**
     * @param prixTTC the prixTTC to set
     */
    public void setPrixTTC( Double prixTTC )
    {
        this.prixTTC = prixTTC;
    }

}
