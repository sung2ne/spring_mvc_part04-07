package com.example.spring.posts;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostsDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlSession session;

    private static final String namespace = "postsMapper";

    // 게시글 등록
    public int create(PostsVo postsVo) {
        return session.insert(namespace + ".create", postsVo);
    }

    // 게시글 목록
    public List<PostsVo> list() {
        return session.selectList(namespace + ".list");
    }

    // 게시글 보기
    public PostsVo read(int id) {
        return session.selectOne(namespace + ".read", id);
    }

    // 게시글 수정
    public int update(PostsVo postsVo) {
        return session.update(namespace + ".update", postsVo);
    }

    // 게시글 삭제
    public int delete(int id) {
        return session.delete(namespace + ".delete", id);
    }
}
