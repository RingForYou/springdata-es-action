package com.ratel.es.repository;


import com.ratel.es.entity.Poem;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
  *@业务描述：
  *@author： fuyongnan
  *@create_time： 2020/1/12 15:40
  */  
public interface PoemRepository extends ElasticsearchRepository<Poem, String> {

    @Query("{\"bool\" : {\"must\" : {\"wildcard\" : {\"title\" : \"?\"}}}}")
    Page<Poem> findByTitle(String title, Pageable pageable);

    @Query("{\n" +
            "    \"query\": {\n" +
            "        \"query_string\" : {\n" +
            "            \"fields\" : [\"es_*\"],\n" +
            "            \"query\" : \"my\"\n" +
            "        }\n" +
            "    }\n" +
            "}")
    Page<Poem> findByTitle2(String title, Pageable pageable);
}
