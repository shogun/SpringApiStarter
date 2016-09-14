package com.shn.spr.bookstore;

import org.springframework.data.repository.PagingAndSortingRepository;

interface AuthorRepository extends PagingAndSortingRepository<Author, Long>  {

}
