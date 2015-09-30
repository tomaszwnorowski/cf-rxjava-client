package models;

import lombok.Data;

import java.net.URI;
import java.util.List;

@Data
public class Page<T> {

    protected int totalResults;
    protected int totalPages;
    protected URI nextUrl;
    protected URI prevUrl;
    protected List<T> resources;

}
