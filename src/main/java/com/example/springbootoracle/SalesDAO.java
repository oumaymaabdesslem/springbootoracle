package com.example.springbootoracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SalesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SalesDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sale> list() {
        String sql = "SELECT * FROM SALE";

        List<Sale> listSale = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Sale.class));

        return listSale;
    }

    public void save(Sale sale) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("sale").usingColumns("item", "quantity", "amount");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);

        insertActor.execute(param);
    }

    public Sale get(int id) {
        String sql = "SELECT * FROM SALE WHERE id= ?";
        Object[] args = {id};
        Sale sale = jdbcTemplate.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Sale.class));

        return sale;
    }

    public void update(Sale sale) {
        String sql = "UPDATE SALE SET item=:item, quantity=:quantity,amount=:amount  WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM SALE WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
