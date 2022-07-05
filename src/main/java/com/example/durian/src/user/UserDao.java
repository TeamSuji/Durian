package com.example.durian.src.user;

import com.example.durian.src.user.model.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetUserRes getUserInfo(int user_id) {
        System.out.println("db entered");
        String getUserQuery = "select name, nickName, email, phone from User where userIdx = ?";
        int getUserParams = user_id;
        return this.jdbcTemplate.queryForObject(getUserQuery,
                (rs, row) -> new GetUserRes(
                        rs.getString("name"),
                        rs.getString("nickName"),
                        rs.getString("email"),
                        rs.getString("phone")),
                getUserParams);
    }

}
