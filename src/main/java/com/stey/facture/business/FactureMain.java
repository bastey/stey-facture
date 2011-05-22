package com.stey.facture.business;

import java.util.Date;

import com.stey.facture.domain.Adresse;
import com.stey.facture.domain.Client;
import com.stey.facture.domain.DetailRepas;
import com.stey.facture.domain.Facture;
import com.stey.facture.domain.Produit;

/**
 * @author BASTEY
 *
 */
public class FactureMain
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        FactureFactory ff = new FactureFactory();

        Facture facture = createDataTest();

        ff.creerFactureXls( facture );
    }

    /**
     * @return
     */
    private static Facture createDataTest()
    {
        // Facture a générer
        Facture facture = new Facture();

        Client client1 = new Client();
        client1.setCivilite( "M." );
        client1.setPrenom( "Robert" );
        client1.setNom( "Duval" );
        Adresse adresse = new Adresse();
        adresse.setNumeroEtNomRue( "1, rue de Paris" );
        adresse.setCodePostal( "75200" );
        adresse.setVille( "Paris" );
        client1.setAdresse( adresse );
        client1.setNumeroTelephone( "0699668844" );
        facture.getClients().add( client1 );

        Client client2 = new Client();
        client2.setCivilite( "M. et Mme" );
        client2.setPrenom( "Nicolas" );
        client2.setNom( "Roger" );
        Adresse adresse2 = new Adresse();
        adresse2.setNumeroEtNomRue( "2, rue de Rennes" );
        adresse2.setCodePostal( "36200" );
        adresse2.setVille( "Rennes" );
        client2.setAdresse( adresse2 );
        client2.setNumeroTelephone( "0699112233" );
        facture.getClients().add( client2 );

        Produit pi = new Produit();
        pi.setFournisseur( "Leclerc" );
        pi.setNom( "100 kg de patates douces" );
        pi.setPrixTTC( 10.50 );
        facture.getProduits().add( pi );

        pi = new Produit();
        pi.setFournisseur( "Davigel" );
        pi.setNom( "100 Tournedos et sa petite sauce" );
        pi.setPrixTTC( 115.58 );
        facture.getProduits().add( pi );

        pi = new Produit();
        pi.setFournisseur( "Carrefour Market" );
        pi.setNom( "100 nappes de papiers et serviettes et rinces doigts" );
        pi.setPrixTTC( 31.89 );
        facture.getProduits().add( pi );

        facture.setNomRepas( "Repas d'anniversaire de Baptiste" );
        facture.setDateRepas( new Date() );
        facture.setNomSalle( "La Poterie" );

        DetailRepas detail = new DetailRepas();
        detail.setDefinitionRepas( "le samedi soir" );
        detail.setNbAdultes1( 100 );
        detail.setNbEnfants1( 10 );
        facture.getDetailsRepas().add( detail );

        detail = new DetailRepas();
        detail.setDefinitionRepas( "le dimanche midi" );
        detail.setNbAdultes1( 50 );
        detail.setNbEnfants1( 5 );
        facture.getDetailsRepas().add( detail );

        return facture;
    }

}
