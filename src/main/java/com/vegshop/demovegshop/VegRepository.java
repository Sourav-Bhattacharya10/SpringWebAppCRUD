package com.vegshop.demovegshop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VegRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Vegetable> findAll()
    {
        return jdbcTemplate.query("SELECT * FROM Vegetable", new VegRowMapper());
    }

    @Transactional(readOnly = false)
    public int insertItem(Vegetable veg)
    {
        int status = jdbcTemplate.update("INSERT INTO Vegetable VALUES (?,?)", veg.VegName, veg.VegCost);
        return status;
    }
}