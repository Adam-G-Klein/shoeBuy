package com.truesize.shoegraph;

import org.springframework.data.repository.CrudRepository;

public interface AllShoeRepository extends CrudRepository<ShoeNode, Long>  {
    ShoeNode findByUniqueShoeCode(String uniqueShoeCode);
}
