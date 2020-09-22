/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package za.co.ntier.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for zz_woocommerce
 *  @author iDempiere (generated) 
 *  @version Release 7.1 - $Id$ */
public class X_zz_woocommerce extends PO implements I_zz_woocommerce, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200919L;

    /** Standard Constructor */
    public X_zz_woocommerce (Properties ctx, int zz_woocommerce_ID, String trxName)
    {
      super (ctx, zz_woocommerce_ID, trxName);
      /** if (zz_woocommerce_ID == 0)
        {
			setAddress1 (null);
			setC_BPartner_ID (0);
			setC_Charge_ID (0);
			setC_Country_ID (0);
			setCity (null);
			setDeliveryRule (null);
			setexcl_pricelist_id (0);
			setincl_pricelist_id (0);
			setM_Product_ID (0);
			setM_Warehouse_ID (0);
			setstandard_tax_id (0);
			setzero_tax_id (0);
			setzz_woocommerce_ID (0);
        } */
    }

    /** Load Constructor */
    public X_zz_woocommerce (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_zz_woocommerce[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Address 1.
		@param Address1 
		Address line 1 for this location
	  */
	public void setAddress1 (String Address1)
	{
		set_ValueNoCheck (COLUMNNAME_Address1, Address1);
	}

	/** Get Address 1.
		@return Address line 1 for this location
	  */
	public String getAddress1 () 
	{
		return (String)get_Value(COLUMNNAME_Address1);
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.compiere.model.I_C_Charge)MTable.get(getCtx(), org.compiere.model.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Country getC_Country() throws RuntimeException
    {
		return (org.compiere.model.I_C_Country)MTable.get(getCtx(), org.compiere.model.I_C_Country.Table_Name)
			.getPO(getC_Country_ID(), get_TrxName());	}

	/** Set Country.
		@param C_Country_ID 
		Country 
	  */
	public void setC_Country_ID (int C_Country_ID)
	{
		if (C_Country_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Country_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Country_ID, Integer.valueOf(C_Country_ID));
	}

	/** Get Country.
		@return Country 
	  */
	public int getC_Country_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Country_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set City.
		@param City 
		Identifies a City
	  */
	public void setCity (String City)
	{
		set_ValueNoCheck (COLUMNNAME_City, City);
	}

	/** Get City.
		@return Identifies a City
	  */
	public String getCity () 
	{
		return (String)get_Value(COLUMNNAME_City);
	}

	/** DeliveryRule AD_Reference_ID=151 */
	public static final int DELIVERYRULE_AD_Reference_ID=151;
	/** After Receipt = R */
	public static final String DELIVERYRULE_AfterReceipt = "R";
	/** Availability = A */
	public static final String DELIVERYRULE_Availability = "A";
	/** Complete Line = L */
	public static final String DELIVERYRULE_CompleteLine = "L";
	/** Complete Order = O */
	public static final String DELIVERYRULE_CompleteOrder = "O";
	/** Force = F */
	public static final String DELIVERYRULE_Force = "F";
	/** Manual = M */
	public static final String DELIVERYRULE_Manual = "M";
	/** Set Delivery Rule.
		@param DeliveryRule 
		Defines the timing of Delivery
	  */
	public void setDeliveryRule (String DeliveryRule)
	{

		set_ValueNoCheck (COLUMNNAME_DeliveryRule, DeliveryRule);
	}

	/** Get Delivery Rule.
		@return Defines the timing of Delivery
	  */
	public String getDeliveryRule () 
	{
		return (String)get_Value(COLUMNNAME_DeliveryRule);
	}

	public org.compiere.model.I_M_PriceList getexcl_pricelist() throws RuntimeException
    {
		return (org.compiere.model.I_M_PriceList)MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
			.getPO(getexcl_pricelist_id(), get_TrxName());	}

	/** Set Exclusive Pricelist.
		@param excl_pricelist_id Exclusive Pricelist	  */
	public void setexcl_pricelist_id (int excl_pricelist_id)
	{
		set_Value (COLUMNNAME_excl_pricelist_id, Integer.valueOf(excl_pricelist_id));
	}

	/** Get Exclusive Pricelist.
		@return Exclusive Pricelist	  */
	public int getexcl_pricelist_id () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_excl_pricelist_id);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Comment/Help.
		@param Help 
		Comment or Hint
	  */
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp () 
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	public org.compiere.model.I_M_PriceList getincl_pricelist() throws RuntimeException
    {
		return (org.compiere.model.I_M_PriceList)MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
			.getPO(getincl_pricelist_id(), get_TrxName());	}

	/** Set Inclusive Pricelist.
		@param incl_pricelist_id Inclusive Pricelist	  */
	public void setincl_pricelist_id (int incl_pricelist_id)
	{
		set_Value (COLUMNNAME_incl_pricelist_id, Integer.valueOf(incl_pricelist_id));
	}

	/** Get Inclusive Pricelist.
		@return Inclusive Pricelist	  */
	public int getincl_pricelist_id () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_incl_pricelist_id);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_Warehouse getM_Warehouse() throws RuntimeException
    {
		return (org.compiere.model.I_M_Warehouse)MTable.get(getCtx(), org.compiere.model.I_M_Warehouse.Table_Name)
			.getPO(getM_Warehouse_ID(), get_TrxName());	}

	/** Set Warehouse.
		@param M_Warehouse_ID 
		Storage Warehouse and Service Point
	  */
	public void setM_Warehouse_ID (int M_Warehouse_ID)
	{
		if (M_Warehouse_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_M_Warehouse_ID, Integer.valueOf(M_Warehouse_ID));
	}

	/** Get Warehouse.
		@return Storage Warehouse and Service Point
	  */
	public int getM_Warehouse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Warehouse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Tax getstandard_tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getstandard_tax_id(), get_TrxName());	}

	/** Set Standard Tax.
		@param standard_tax_id Standard Tax	  */
	public void setstandard_tax_id (int standard_tax_id)
	{
		set_Value (COLUMNNAME_standard_tax_id, Integer.valueOf(standard_tax_id));
	}

	/** Get Standard Tax.
		@return Standard Tax	  */
	public int getstandard_tax_id () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_standard_tax_id);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Tax getzero_tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getzero_tax_id(), get_TrxName());	}

	/** Set Zero Tax.
		@param zero_tax_id Zero Tax	  */
	public void setzero_tax_id (int zero_tax_id)
	{
		set_Value (COLUMNNAME_zero_tax_id, Integer.valueOf(zero_tax_id));
	}

	/** Get Zero Tax.
		@return Zero Tax	  */
	public int getzero_tax_id () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_zero_tax_id);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set zz_woocommerce_ID.
		@param zz_woocommerce_ID zz_woocommerce_ID	  */
	public void setzz_woocommerce_ID (int zz_woocommerce_ID)
	{
		if (zz_woocommerce_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_zz_woocommerce_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_zz_woocommerce_ID, Integer.valueOf(zz_woocommerce_ID));
	}

	/** Get zz_woocommerce_ID.
		@return zz_woocommerce_ID	  */
	public int getzz_woocommerce_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_zz_woocommerce_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set zz_woocommerce_UU.
		@param zz_woocommerce_UU zz_woocommerce_UU	  */
	public void setzz_woocommerce_UU (String zz_woocommerce_UU)
	{
		set_ValueNoCheck (COLUMNNAME_zz_woocommerce_UU, zz_woocommerce_UU);
	}

	/** Get zz_woocommerce_UU.
		@return zz_woocommerce_UU	  */
	public String getzz_woocommerce_UU () 
	{
		return (String)get_Value(COLUMNNAME_zz_woocommerce_UU);
	}
}