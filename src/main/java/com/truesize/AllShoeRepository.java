package com.truesize;

import org.springframework.data.repository.CrudRepository;

public interface AllShoeRepository extends CrudRepository<ShoeNode, Long>  {
    ShoeNode findByModel(String model);
}
