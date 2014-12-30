package org.fluxtream.connectors.google_spreadsheets;

import org.fluxtream.core.connectors.annotations.ObjectTypeSpec;
import org.fluxtream.core.domain.AbstractFacet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by candide on 30/12/14.
 */
@Entity(name="Facet_GoogleSpreadsheetCell")
@ObjectTypeSpec(name = "row", value = 4, prettyname = "Row", isMixedType = true)
public class GoogleSpreadsheetCellFacet extends AbstractFacet {

    public GoogleSpreadsheetCellFacet() {}

    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    public GoogleSpreadsheetRowFacet row;

}
