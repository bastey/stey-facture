package com.stey.facture.business;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.stey.facture.domain.Client;
import com.stey.facture.domain.DetailRepas;
import com.stey.facture.domain.Facture;
import com.stey.facture.domain.Produit;

/**
 * @author BASTEY
 */
public class FactureFactory
{

    private int ligneDebutProduits = 14;

    protected void creerFactureXls( Facture facture )
    {
        Workbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();

        // create a new sheet
        Sheet sheet = wb.createSheet();

        // Cell style ARIAL 12 Bold
        CellStyle csArial12Bold = wb.createCellStyle();
        Font f = wb.createFont();
        f.setFontHeightInPoints( (short) 12 );
        // f.setColor( IndexedColors.RED.getIndex() );
        f.setBoldweight( Font.BOLDWEIGHT_BOLD );
        // DataFormat df = wb.createDataFormat();
        // cs.setDataFormat( df.getFormat( "#,##0.0" ) );
        csArial12Bold.setFont( f );

        // Cell style ARIAL 18 BOLD
        CellStyle csArial18Bold = wb.createCellStyle();
        Font f2 = wb.createFont();
        f2.setFontHeightInPoints( (short) 18 );
        f2.setBoldweight( Font.BOLDWEIGHT_BOLD );
        csArial18Bold.setFont( f2 );

        // Cell style ARIAL 12 Normal
        CellStyle csArial12 = wb.createCellStyle();
        Font f3 = wb.createFont();
        f3.setFontHeightInPoints( (short) 12 );
        f3.setBoldweight( Font.DEFAULT_CHARSET );
        csArial12.setFont( f3 );

        ecrireClient1( facture, sheet, createHelper, csArial12Bold );
        ecrireClient2( facture, sheet, createHelper, csArial12Bold );

        ecrireTitreFacture( facture, sheet, createHelper, csArial18Bold );

        ecrireProduits( facture, sheet, createHelper, csArial12 );

        ecrirePiedPage( facture, sheet, createHelper, csArial12 );

        try
        {
            String filename = "src/test/resources/data/maFacture.xls";
            FileOutputStream out = new FileOutputStream( filename );
            wb.write( out );
            out.close();
            System.out.println( "Génération de la facture OK" );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "FileNotFoundException : " + e );
        }
        catch ( IOException e )
        {
            System.out.println( "IOException : " + e );
        }
    }

    /**
     * Ecriture du client 1 en haut à gauche
     */
    private void ecrireClient1( Facture facture, Sheet sheet, CreationHelper createHelper, CellStyle cs )
    {
        Client client = facture.getClients().get( 0 );

        Row r = null;
        Cell c = null;

        r = sheet.createRow( 0 );
        c = r.createCell( 0 );
        c.setCellStyle( cs );
        c.setCellValue( createHelper.createRichTextString( client.getCivilite() + " " + client.getNom() + " "
            + client.getPrenom() ) );

        r = sheet.createRow( 1 );
        c = r.createCell( 0 );
        c.setCellStyle( cs );
        c.setCellValue( createHelper.createRichTextString( client.getAdresse().getNumeroEtNomRue() ) );

        r = sheet.createRow( 2 );
        c = r.createCell( 0 );
        c.setCellStyle( cs );
        c.setCellValue( createHelper.createRichTextString( client.getAdresse().getCodePostal() + " "
            + client.getAdresse().getVille() ) );

        r = sheet.createRow( 3 );
        c = r.createCell( 0 );
        c.setCellStyle( cs );
        c.setCellValue( createHelper.createRichTextString( client.getNumeroTelephone() ) );
    }

    /**
     * Ecriture du client 2 en haut à droite
     */
    private void ecrireClient2( Facture facture, Sheet sheet, CreationHelper createHelper, CellStyle cs )
    {
        if ( facture.getClients().size() == 2 )
        {
            Client client = facture.getClients().get( 1 );

            Row r = sheet.getRow( 0 );
            Cell c = r.createCell( 2 );
            c.setCellStyle( cs );
            c.setCellValue( createHelper.createRichTextString( client.getCivilite() + " " + client.getNom() + " "
                + client.getPrenom() ) );

            r = sheet.getRow( 1 );
            c = r.createCell( 2 );
            c.setCellStyle( cs );
            c.setCellValue( createHelper.createRichTextString( client.getAdresse().getNumeroEtNomRue() ) );

            r = sheet.getRow( 2 );
            c = r.createCell( 2 );
            c.setCellStyle( cs );
            c.setCellValue( createHelper.createRichTextString( client.getAdresse().getCodePostal() + " "
                + client.getAdresse().getVille() ) );

            r = sheet.getRow( 3 );
            c = r.createCell( 2 );
            c.setCellStyle( cs );
            c.setCellValue( createHelper.createRichTextString( client.getNumeroTelephone() ) );
        }
    }

    private void ecrireTitreFacture( Facture facture, Sheet sheet, CreationHelper createHelper, CellStyle csArial18Bold )
    {
        Row r = sheet.createRow( 8 );
        Cell c = r.createCell( 1 );
        c.setCellStyle( csArial18Bold );
        c.setCellValue( createHelper.createRichTextString( facture.getNomRepas() ) );

        r = sheet.createRow( 9 );
        c = r.createCell( 1 );
        c.setCellStyle( csArial18Bold );
        SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
        c.setCellValue( createHelper.createRichTextString( "du " + df.format( facture.getDateRepas() ) ) );
    }

    private void ecrireProduits( Facture facture, Sheet sheet, CreationHelper createHelper, CellStyle csArial12 )
    {
        int produitCourant = ligneDebutProduits;
        for ( Produit pi : facture.getProduits() )
        {
            Row r = sheet.createRow( produitCourant );
            Cell c = null;
            for ( int i = 0; i < 3; i++ )
            {
                c = r.createCell( i );
                c.setCellStyle( csArial12 );
                if ( i == 0 )
                {
                    c.setCellValue( createHelper.createRichTextString( pi.getFournisseur() ) );
                }
                else if ( i == 1 )
                {
                    c.setCellValue( createHelper.createRichTextString( pi.getNom() ) );
                }
                else
                {
                    c.setCellValue( createHelper.createRichTextString( pi.getPrixTTC().toString() ) );
                }
            }
            produitCourant++;
        }
    }

    private void ecrirePiedPage( Facture facture, Sheet sheet, CreationHelper createHelper, CellStyle csArial12 )
    {
        int ligneDebutPiedPage = ligneDebutProduits + facture.getProduits().size() + 3;
        Row r = sheet.createRow( ligneDebutPiedPage );
        Cell c = r.createCell( 0 );
        c.setCellStyle( csArial12 );
        c.setCellValue( createHelper.createRichTextString( "Repas fait à la salle de " + facture.getNomSalle() ) );

        for ( DetailRepas detail : facture.getDetailsRepas() )
        {
            r = sheet.createRow( ligneDebutPiedPage + 1 );
            c = r.createCell( 0 );
            c.setCellStyle( csArial12 );
            c.setCellValue( createHelper.createRichTextString( detail.getNbAdultes1() + " adultes et "
                + detail.getNbEnfants1() + " enfants " + detail.getDefinitionRepas() ) );
            ligneDebutPiedPage++;
        }
    }
}
