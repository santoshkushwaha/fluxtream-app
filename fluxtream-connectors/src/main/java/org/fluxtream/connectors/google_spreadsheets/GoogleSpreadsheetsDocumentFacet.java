package org.fluxtream.connectors.google_spreadsheets;

import org.fluxtream.core.connectors.annotations.ObjectTypeSpec;
import org.fluxtream.core.domain.AbstractFacet;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by candide on 30/12/14.
 */
@Entity(name="Facet_GoogleSpreadsheetDocument")
@ObjectTypeSpec(name = "document", value = 1, prettyname = "Document", clientFacet = false)
public class GoogleSpreadsheetsDocumentFacet extends AbstractFacet {

    public String spreadsheetId;
    public String worksheetId;

    public String dateTimeColumnName;
    public String dateTimeFormat;
    public String timeZone;

    public int numberOfRows;
    public enum Status { UP, DOWN }
    public Status status;

    @Lob
    public String message;
    @Lob
    public String stackTrace;

    @Type(type="yes_no")
    public boolean incremental;

    @Lob
    public String columnNames;
    public String collectionLabel, itemLabel;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    public List<GoogleSpreadsheetRowFacet> rows;

    public GoogleSpreadsheetsDocumentFacet(){}
    public GoogleSpreadsheetsDocumentFacet(GoogleSpreadsheetsUpdater.ImportSpecs importSpecs){
        this.spreadsheetId = importSpecs.spreadsheetId;
        this.worksheetId = importSpecs.worksheetId;
        this.dateTimeColumnName = importSpecs.dateTimeField;
        this.dateTimeFormat = importSpecs.dateTimeFormat;
        this.timeZone = importSpecs.timeZone;
        this.columnNames = importSpecs.columnNames;
        this.collectionLabel = importSpecs.collectionLabel;
        this.itemLabel = importSpecs.itemLabel;
    }

}
