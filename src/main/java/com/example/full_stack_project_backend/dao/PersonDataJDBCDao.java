package com.example.full_stack_project_backend.dao;

import com.example.full_stack_project_backend.model.Person;
import com.example.full_stack_project_backend.model.PersonData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDataJDBCDao implements DAO<PersonData> {

    private static final Logger log = LoggerFactory.getLogger(PersonGDBCDao.class);
    private  JdbcTemplate jdbcTemplate;


    RowMapper<PersonData> rowMapper= (rs, rowNum) -> {
        PersonData data = new PersonData();
        data.setId(rs.getInt("id"));
        data.setClientId(rs.getInt("clientId"));
        data.setLastprice(rs.getInt("lastprice"));
        data.setGeneralprice(rs.getInt("generalprice"));
        data.setFavouritedish(rs.getString("favouritedish"));
        return data;
    };

    public PersonDataJDBCDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersonData> list() {
        String sql = "SELECT id, clientId, lastprice, generalprice, favouritedish FROM PERSON_DATA";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(PersonData personData) {
        String sql = "INSERT INTO PERSON_DATA(clientId, lastprice, generalprice, favouritedish) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, personData.getClientId(), personData.getLastprice(), personData.getGeneralprice(), personData.getFavouritedish());

    }

    @Override
    public Optional<PersonData> get(int id) {
        String sql = "SELECT * FROM PERSON_DATA WHERE id = ?";
        PersonData personData = null;
        try{
            personData = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
        } catch (DataAccessException ex) {
            log.info("Person data not found " + id);
        }
        return Optional.ofNullable(personData);
    }

    @Override
    public void update(PersonData personData, int id) {
        String sql = "UPDATE PERSON_DATA SET clientId = ?, lastprice = ?, generalprice = ?, favouritedish = ? WHERE id = ?";
        jdbcTemplate.update(sql, personData.getClientId(), personData.getLastprice(), personData.getGeneralprice(), personData.getFavouritedish(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM PERSON_DATA WHERE id = ?", id);
    }
}
