package com.demo.factory;

import com.demo.dao.impl.*;

public class DAOFactory {
	public static GoodsDaoImpl getGoodsDaoInstance(){
		return new GoodsDaoImpl();
	}
	public static ProductsDaoImpl getProductsDaoInstance(){
		return new ProductsDaoImpl();
	}
	public static SellersDaoImpl getSellersDaoInstance(){
		return new SellersDaoImpl();
	}
	public static ManufacturersDaoImpl getManufacturersDaoInstance(){
		return new ManufacturersDaoImpl();
	}
	public static SuppliersDaoImpl getSuppliersDaoInstance(){
		return new SuppliersDaoImpl();
	}
	public static MaterialsDaoImpl getMaterialsDaoInstance(){
		return new MaterialsDaoImpl();
	}
	public static StocksDaoImpl getStocksDaoInstance(){
		return new StocksDaoImpl();
	}
}
