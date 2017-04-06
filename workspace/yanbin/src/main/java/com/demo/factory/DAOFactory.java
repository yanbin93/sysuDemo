package com.demo.factory;

import com.demo.dao.impl.GoodsDaoImpl;

public class DAOFactory {
	public static GoodsDaoImpl getGoodsDaoInstance(){
		return new GoodsDaoImpl();
	}
}
