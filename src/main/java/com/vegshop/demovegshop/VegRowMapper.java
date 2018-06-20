package com.vegshop.demovegshop;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class VegRowMapper implements RowMapper<Vegetable>
{

	@Override
    public Vegetable mapRow(ResultSet rs, int rowNum) throws SQLException 
    {
        Vegetable veggie = new Vegetable();
        veggie.VegId = rs.getInt("VegId");
        veggie.VegName = rs.getString("VegName");
        veggie.VegCost = rs.getInt("VegCost");
        
		return veggie;
	}

}