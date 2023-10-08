package com.tapusd.demomongoref.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface SoftDeleteRepository<T, ID> extends MongoRepository<T, ID> {

    @Override
    @Query("{$and: [{isoCode: ?0}, {isDeleted: false}]}")
    Optional<T> findById(ID id);

    @Override
    @Query("{isDeleted: false}")
    List<T> findAll();

    @Override
    @Query(value = "{id: ?0}")
    @Update("""
            {$set:  {
                isDeleted:  true,
                deletedAt: new Date()
                }
            }
            """)
    void deleteById(ID id);
}
